package com.zhenapp.mapper.Custom;

import java.util.List;

import com.zhenapp.po.Custom.TDurationInfoCustom;

public interface TDurationInfoCustomMapper {
	/*
	 * 查询全部的停留时长信息
	 */
	public List<TDurationInfoCustom> findAllDuration() throws Exception;
}
