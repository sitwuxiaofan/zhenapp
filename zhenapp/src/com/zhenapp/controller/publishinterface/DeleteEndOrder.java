package com.zhenapp.controller.publishinterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
@Transactional
@Controller
public class DeleteEndOrder {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(DeleteEndOrder.class);
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	
	/*
	 * 详情任务状态为执行终止的前一天的详情任务删除
	 */
	@RequestMapping(value="/api/platform/deleteTaskstate")
	public @ResponseBody ModelMap deleteTaskstate() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskstate", "23");
		hashmap.put("taskdate", yyyyMMdd.format(new Date()));
		taskDetailInfoService.deleteTaskBystate(hashmap);
		taskDetailInfoTempService.deletetaskDetailInfoTemp(hashmap);
		logger.info("删除详情任务状态为执行终止的前一天的详情任务!");
		return map;
	}
}
