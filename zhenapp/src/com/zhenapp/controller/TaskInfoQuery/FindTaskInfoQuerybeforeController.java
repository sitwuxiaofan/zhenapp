package com.zhenapp.controller.TaskInfoQuery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TTaskInfoQueryCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.TaskInfoQueryService;

@Controller
public class FindTaskInfoQuerybeforeController {
	@Autowired
	private TaskInfoQueryService taskInfoQueryService;
	
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	@Value("${middleRows}")
	private Integer middleRows;
	
	@RequestMapping("/api/findTaskInfoQuerybeforeuser")
	public @ResponseBody ModelAndView findTaskInfoQuerybeforeuser(HttpSession session,Integer page,String taskpk,String taskkeyword,String datefrom,String dateto,String taskid,String usernick,String taskkeynum,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		if(datefrom!=null && !datefrom.equals("")){
			pagemap.put("datefrom", datefrom.replace("-", "")+"000000");
		}
		if(dateto!=null && !dateto.equals("")){
			pagemap.put("dateto", dateto.replace("-", "")+"235959");
		}
		pagemap.put("taskpk", taskpk);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskkeyword", taskkeyword);
		pagemap.put("tasktype", tasktype);
		pagemap.put("before", yyyyMMdd.format(new Date()));
		pagemap.put("userid", tUserInfoCustom.getUserid());
		//系统管理员
		List<TTaskInfoQueryCustom> tTaskInfoQueryCustomList = taskInfoQueryService.findTaskInfoByMap(pagemap);
		int total = taskInfoQueryService.findTotalTaskInfoByMap(pagemap);
		mv.addObject("tTaskInfoQueryCustomList", tTaskInfoQueryCustomList);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("taskpk", taskpk);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("taskkeyword", taskkeyword);
		mv.addObject("tasktype", tasktype);
		mv.addObject("datefrom", datefrom);
		mv.addObject("dateto", dateto);
		mv.setViewName("/backstage/task/taskQuerylistbefore.jsp");
		return mv;
	}
}
