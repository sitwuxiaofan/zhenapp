package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Vo.TUserinfoVo;

public interface UserInfoService {
	
	/*
	 * 根据用户名查询用户信息
	 */
	public List<TUserInfoCustom> findUserBynick(String usernick) throws Exception;
	
	/*
	 * 根据id查询用户信息
	 */
	public TUserInfoCustom findUserByuserid(String userid) throws Exception;
	
	/*
	 * 分页查询出用户
	 */
	public List<TUserInfoCustom> findUserByPage(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 分页查询出用户总数量
	 */
	public int findTotalUserByPage(HashMap<String, Object> pagemap) throws Exception;
	
	/*
	 * 根据角色为代理  分页查询出用户
	 */
	public List<TUserInfoCustom> findUserByPageandRole(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 根据角色为代理  分页查询出用户总数量
	 */
	public int findTotalUserByPageandRole(HashMap<String, Object> pagemap) throws Exception;
	
	/*
	 * 保存用户信息
	 */
	public int saveUser(TUserInfoCustom tUserInfoCustom) throws Exception;
	
	/*
	 * 根据用户信息查询积分
	 */
	public String findpointsByUsernickAndPwd(TUserInfoCustom tUserInfoCustom) throws Exception;
	
	/*
	 * 根据用户名和注册邮箱找回密码
	 */
	public TUserInfoCustom findPasswordByemail(TUserinfoVo tUserinfoVo) throws Exception;
	/*
	 * 修改用户信息
	 */
	public int updateUserinfo(TUserinfoVo tUserinfoVo) throws Exception;
	/*
	 * 根据userid修改用户积分
	 */
	public int updateUserinfoPointByUserid(TUserInfoCustom tUserInfoCustom) throws Exception;
	/*
	 * 根据用户主键删除用户信息
	 */
	public int deleteUserinfoBypk(String userpk) throws Exception;
	/*
	 * 根据用户主键修改角色为代理用户
	 */
	public int updaterole(String userpk) throws Exception;
	/*
	 * 根据用户主键查询用户信息
	 */
	public TUserInfoCustom findUserByuserpk(String userpk) throws Exception;
}
