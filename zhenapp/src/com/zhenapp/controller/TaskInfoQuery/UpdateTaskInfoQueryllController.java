package com.zhenapp.controller.TaskInfoQuery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskInfoQueryCustom;
import com.zhenapp.service.TaskInfoQueryService;

@Controller
public class UpdateTaskInfoQueryllController {
	@Autowired
	private TaskInfoQueryService taskInfoQueryService;

	@Autowired
	private UpdateTaskInfoQueryllService updateTaskInfoQueryllService;
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@RequestMapping("/api/updateTaskInfo33")
	public @ResponseBody ModelMap updateTaskInfo33() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskdate", yyyyMMdd.format(new Date()));
		hashmap.put("tasktype", "33");
		hashmap.put("taskstate", "16,18");
		hashmap.put("page", 0);
		hashmap.put("rows", 1000);
		List<TTaskInfoQueryCustom> tTaskInfoQueryCustomList = taskInfoQueryService.findTaskInfoByMap(hashmap);
		for (int i = 0; i < tTaskInfoQueryCustomList.size(); i++) {
			TTaskInfoQueryCustom tTaskInfoQueryCustom = tTaskInfoQueryCustomList.get(i);
			updateTaskInfoQueryllService.updateTaskInfo33(tTaskInfoQueryCustom);
		}
		return map;
	}
}
