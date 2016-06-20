package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.MsgInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TUsertestInfoCustom;
import com.zhenapp.service.DateInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceAgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.RechargeInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.UsertestInfoService;
import com.zhenapp.util.StringUtilWxf;
@Transactional
@Controller
public class CheckFinshOrder {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckFinshOrder.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private SysconfInfoService sysconfInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private RechargeInfoService rechargeInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private DateInfoService dateInfoService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private PriceAgentInfoService priceAgentInfoService;
	@Autowired
	private UsertestInfoService usertestInfoService;
	
	@Value("${secret}")
	private String secret;
	@Value("${liuliangapp}")
	private String liuliangapp;
	/*
	 * 判断是否有任务执行完成        修改任务状态,积分处理
	 */
	@RequestMapping(value="/api/platform/cyclecheckTask")
	public @ResponseBody ModelMap cyclecheckTask() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("taskstate", "16");
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskInfoByTaskstate(hashmap);
		if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size()>0){
			for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
				boolean isfinish = false;
				boolean isfinishflow = false;
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
				TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
				TUserInfoCustom tUserInfoCustomagent = userInfoService.findUserByuserid(tUserInfoCustom.getUserid());
				TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
				TPriceAgentInfoCustom tPriceAgentInfoCustom = priceAgentInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
				hashmap.clear();
				hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("taskstate", "21,22");
				int counts = taskDetailInfoService.findCounts(hashmap);
				int checkcount = 0;
				if(tTaskInfoCustom.getTasktype().equals("33")){
					checkcount = tTaskInfoCustom.getCollectioncount()+tTaskInfoCustom.getShoppingcount();
				}else{
					checkcount = tTaskInfoCustom.getFlowcount();
				}
				if(counts==checkcount){
					//收藏和加购任务已经执行完成
					isfinish=true;
				}
				if(tTaskInfoCustom.getTasktype().equals("33")){
					TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);
					HashMap<String,Object> hashmapusertest= new HashMap<String, Object>();
					hashmapusertest.put("page", 0);
					hashmapusertest.put("rows", 10);
					hashmapusertest.put("usertestid", tTaskDetailInfoFlowCustom.getCreateuser());
					List<TUsertestInfoCustom> tUsertestInfoCustomlist = usertestInfoService.findUserTest(hashmapusertest);
					if(tUsertestInfoCustomlist!=null && tUsertestInfoCustomlist.size()>0){
						isfinishflow = true;
					}else{
						//调用接口判断流量任务是否完成
						HttpClient httpClient = new HttpClient();
						String result="";
				        GetMethod getMethod = new GetMethod(liuliangapp + "/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/total");
				        getMethod.setRequestHeader("secret", secret);
				        int statusCode =  httpClient.executeMethod(getMethod);
				        if(statusCode == 200) {
				            result = getMethod.getResponseBodyAsString();
				            if(result.indexOf("total")==-1){
				            	result = StringUtilWxf.translat(result);
				            	logger.error("调用查询完成量接口失败,返回："+result);
				            	throw new RuntimeException();
				            }else{
				            	ObjectMapper obj = new ObjectMapper();
				 	    		MsgInfoCustom msgInfoCustom = obj.readValue(result, MsgInfoCustom.class);
				 	    		result=msgInfoCustom.getTotal();
				 	    		//更新完成数
				 	    		hashmap.put("finishcount", msgInfoCustom.getTotal());
				 	    		taskDetailInfoFlowService.updatefinishcount(hashmap);
				 	    		if(tTaskInfoCustom.getFlowcount()==Integer.parseInt(msgInfoCustom.getTotal())){
				 	    			isfinishflow = true;
				 	    		}
				            }
				            map.put("msg", result);
				        } else {
				            logger.error("失败错误码："+statusCode);
				            throw new RuntimeException();
				        }
					}
				}else{
					isfinishflow = true;
				}
		        if(isfinish && isfinishflow){
		        	//表示任务已完成
		        	//更新任务状态
		        	hashmap.clear();
					hashmap.put("taskid", tTaskInfoCustom.getTaskid());
					hashmap.put("taskstate", 17);
					hashmap.put("updatetime", sdf.format(new Date()));
					hashmap.put("updateuser", "sys");
		        	taskInfoService.updateTaskstate(hashmap);
		        	//任务失败积分数返回
		        	int finishcount = 0;
		        	//给用户添加积分明细记录
					TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
					//给代理添加积分明细记录
					TPointsInfoCustom tPointsInfoCustomagent =new TPointsInfoCustom();
		        	if(tTaskInfoCustom.getTasktype().equals("33")){
		        		TTaskDetailInfoFlowCustom TTaskDetailInfoFlowCustombefore = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);
		        		finishcount = TTaskDetailInfoFlowCustombefore.getFinishcount();
		        		int pointsflow = (tTaskInfoCustom.getFlowcount()-finishcount)*Integer.parseInt(tPriceInfoCustom.getPricecounts1());
			        	int pointsflowagent = (tTaskInfoCustom.getFlowcount()-finishcount)*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts1());
			        	//加购，收藏失败
			        	hashmap.clear();
			        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
						hashmap.put("taskstate", "22");
						int collectcount = taskDetailInfoService.findcollectioncount(hashmap);
						int shoppingcount = taskDetailInfoService.findshoppingcount(hashmap);
						int pointscollect = collectcount*Integer.parseInt(tPriceInfoCustom.getPricecounts2());
						int pointsshopping = shoppingcount*Integer.parseInt(tPriceInfoCustom.getPricecounts3());
						int pointscollectagent = collectcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts2());
						int pointsshoppingagent = shoppingcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts3());
						//给用户添加终止任务所返回的积分
						tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflow + pointscollect + pointsshopping);
						
						tPointsInfoCustom.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflow + pointscollect + pointsshopping));
						tPointsInfoCustom.setPointsupdate((pointsflow + pointscollect + pointsshopping));
						tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflow + pointscollect + pointsshopping);
						//给代理添加终止任务所返回的积分
						tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagent + pointscollectagent + pointsshoppingagent);
						
						tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagent + pointscollectagent + pointsshoppingagent));
						tPointsInfoCustomagent.setPointsupdate((pointsflowagent + pointscollectagent + pointsshoppingagent));
						tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagent + pointscollectagent + pointsshoppingagent);
		        	}else{
		        		hashmap.clear();
						hashmap.put("taskid", tTaskInfoCustom.getTaskid());
						hashmap.put("taskstate", "22");
						hashmap.put("tasktype", "34");
						hashmap.put("iscollection", "0");
						hashmap.put("isshopping", "0");
						finishcount = taskDetailInfoService.findCounts(hashmap);
						int pointsflowztc = (tTaskInfoCustom.getFlowcount()-finishcount)*Integer.parseInt(tPriceInfoCustom.getPricecounts4());
			        	int pointsflowagentztc = (tTaskInfoCustom.getFlowcount()-finishcount)*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts4());
			        	hashmap.clear();
			        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
						hashmap.put("taskstate", "22");
						hashmap.put("tasktype", "34");
						hashmap.put("iscollection", "1");
						hashmap.put("isshopping", "1");
			        	int errorcounts = taskDetailInfoService.findCounts(hashmap);
						int pointscollectztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts5());
						int pointsshoppingztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts6());
						int pointscollectagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts5());
						int pointsshoppingagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts6());
						//给用户添加终止任务所返回的积分
						tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflowztc + pointscollectztc + pointsshoppingztc);
						
						tPointsInfoCustom.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowztc + pointscollectztc + pointsshoppingztc));
						tPointsInfoCustom.setPointsupdate((pointsflowztc + pointscollectztc + pointsshoppingztc));
						tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflowztc + pointscollectztc + pointsshoppingztc);
						//给代理添加终止任务所返回的积分
						tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc);
						
						tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc));
						tPointsInfoCustomagent.setPointsupdate((pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc));
						tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc);
		        	}
		        	tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
					tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
					userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
		        	
					tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
					tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
					tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
					tPointsInfoCustom.setUpdateuser("检查订单是否完成");
					tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
					tPointsInfoCustom.setPointstype("28");
					tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
					tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
					pointsInfoService.savePoints(tPointsInfoCustom);
					
					tUserInfoCustomagent.setUpdatetime(sdf.format(new Date()));
					tUserInfoCustomagent.setUpdateuser(tUserInfoCustomagent.getUserid());
					userInfoService.updateUserinfoPointByUserid(tUserInfoCustomagent);
					
					tPointsInfoCustomagent.setCreateuser(tUserInfoCustomagent.getUserid());
					tPointsInfoCustomagent.setCreatetime(sdf.format(new Date()));
					tPointsInfoCustomagent.setUpdatetime(sdf.format(new Date()));
					tPointsInfoCustomagent.setUpdateuser("sys");
					tPointsInfoCustomagent.setPointsid(UUID.randomUUID().toString().replace("-", ""));
					tPointsInfoCustomagent.setPointstype("28");
					tPointsInfoCustomagent.setTaskpk(tTaskInfoCustom.getTaskpk());
					tPointsInfoCustomagent.setUserid(tUserInfoCustomagent.getUserid());
					pointsInfoService.savePoints(tPointsInfoCustomagent);
		        }
			}
			logger.info("检查订单是否已完成结束!");
			map.put("msg", "检查订单是否已完成结束!");
		}else{
			logger.info("没有正在运行中的订单!");
			map.put("msg", "没有正在运行中的订单!");
		}
		return map;	
	}
}
