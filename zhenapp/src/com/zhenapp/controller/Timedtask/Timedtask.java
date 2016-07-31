package com.zhenapp.controller.Timedtask;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component(value="/Timedtask")
public class Timedtask {
	private static Logger logger = Logger.getLogger(Timedtask.class);
	
	@Value("${host}")
	private String host;
	
	@Scheduled(cron = "0 */1 * * * ?")//判断终止中的流量任务是否已终止
	public void job1() throws HttpException, IOException {
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/platform/checkEndOrderll";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/platform/checkEndOrderll)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/platform/checkEndOrderll)，返回："+statusCode);
        }
        logger.info("判断终止中的流量任务是否已终止....每分钟执行一次");
	}
	@Scheduled(cron = "0 */1 * * * ?")//判断终止中的直通车任务是否已终止
	public void job11() throws HttpException, IOException {
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/platform/checkEndOrderztc";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/platform/checkEndOrderztc)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/platform/checkEndOrderztc)，返回："+statusCode);
        }
        logger.info("判断终止中的直通车任务是否已终止....每分钟执行一次");
	}
	
	@Scheduled(cron = "0 */5 * * * ?")//每隔1分钟执行一次 将执行终止状态的详情任务删除
	public void job2() throws HttpException, IOException {
		logger.info("任务执行开始....每5分钟执行一次");
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/platform/deleteTaskstate";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/platform/deleteTaskstate)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/platform/deleteTaskstate)，返回："+statusCode);
        }
        logger.info("将执行终止状态的详情任务删除....每5分钟执行一次");
	}
	
	@Scheduled(cron = "0 */3 * * * ?")//每隔3分钟执行一次 判断任务是否已完成
	public void job3() throws HttpException, IOException {
		logger.info("任务执行开始....每3分钟执行一次检查<直通车>任务是否执行完成");
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/platform/cyclecheckTaskByztc";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/platform/cyclecheckTaskByztc)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/platform/cyclecheckTaskByztc)，返回："+statusCode);
        }
        logger.info("任务执行结束....每3分钟执行一次检查<直通车>任务是否执行完成");
	}
	@Scheduled(cron = "0 */3 * * * ?")//每隔3分钟执行一次 判断任务是否已完成
	public void job33() throws HttpException, IOException {
		logger.info("任务执行开始....每3分钟执行一次检查<流量>任务是否执行完成");
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/platform/cyclecheckTaskByll";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/platform/cyclecheckTaskByll)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/platform/cyclecheckTaskByll)，返回："+statusCode);
        }
        logger.info("任务执行结束....每3分钟执行一次检查<流量>任务是否执行完成");
	}
	
	@Scheduled(cron = "0 */1 * * * ?")//检测流量任务执行错误数是否超出限制
	public void job4() throws HttpException, IOException {
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/platform/checkErrorll";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/platform/checkErrorll)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/platform/checkErrorll)，返回："+statusCode);
        }
        logger.info("每分钟检测执行任务错误数是否超出限制");
	}
	
	@Scheduled(cron = "0 */1 * * * ?")//检测直通车任务执行错误数是否超出限制
	public void job44() throws HttpException, IOException {
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/platform/checkErrorztcTaskztc";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/platform/checkErrorztcTaskztc)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/platform/checkErrorztcTaskztc)，返回："+statusCode);
        }
        logger.info("每分钟检测执行任务错误数是否超出限制");
	}
	
	@Scheduled(cron = "0 */1 * * * ?")//每隔2分钟执行一次 将符合要求的详情任务放入详情任务临时表 (流量任务)  
	public void job5() throws HttpException, IOException {
		logger.info("给(流量任务)任务指定手机执行开始....每隔2分钟执行一次");
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/allocationTask";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/allocationTask)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/allocationTask)，返回："+statusCode);
        }
	}
	@Scheduled(cron = "0 */1 * * * ?")//每隔2分钟执行一次 将符合要求的详情任务放入详情任务临时表   
	public void job6() throws HttpException, IOException {
		logger.info("给(直通车任务)指定手机执行开始....每隔2分钟执行一次");
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/allocationztcTask";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/allocationztcTask)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/allocationztcTask)，返回："+statusCode);
        }
	}
	
	@Scheduled(cron = "0 5 0 * * ?")//每天0点1分执行一次
	public void updateTaskstateByTime() throws Exception { 
		logger.info("处理前一天的任务....每天0点5分执行一次");
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(host+"/api/platform/updateTaskstateByTime");
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/platform/updateTaskstateByTime)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/platform/updateTaskstateByTime)，返回："+statusCode);
        }
		logger.info("处理前一天的任务....每天0点5分执行一次");
	}
	@Scheduled(cron = "0 5 0 * * ?")//每天0点1分执行一次
	public void updateTaskstateByTimeEnd() throws Exception { 
		logger.info("处理前一天的任务....每天0点5分执行一次");
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(host+"/api/platform/updateTaskstateByTimeEnd");
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/platform/updateTaskstateByTimeEnd)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/platform/updateTaskstateByTimeEnd)，返回："+statusCode);
        }
		logger.info("处理前一天的任务....每天0点5分执行一次");
	}
	@Scheduled(cron = "0 2 0 * * ?")//每天0点2分执行一次
	public void insertDateByTimes() throws Exception { 
		logger.info("插入日期....每天0点2分执行一次");
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(host+"/api/platform/insertDateByTimes");
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/platform/insertDateByTimes)，返回："+result);
        }else {
            logger.info("调用接口失败(/api/platform/insertDateByTimes)，返回："+statusCode);
        }
		logger.info("插入日期....每天0点2分执行一次");
	}
	@Scheduled(cron = "0 */1 * * * ?")//每1分钟执行一次
	public void allocation() throws Exception { 
		logger.info("分配任务开始....每1分钟执行一次");
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(host+"/api/allocation");
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/allocation),返回："+result);
        }else {
            logger.info("调用接口失败(/api/allocation),返回："+statusCode);
        }
		logger.info("分配任务完成....每1分钟执行一次");
	}
}
