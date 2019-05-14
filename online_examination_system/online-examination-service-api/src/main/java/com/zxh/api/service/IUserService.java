package com.zxh.api.service;

import com.github.pagehelper.PageInfo;
import com.zxh.api.request.AddOrUpdateUserRequest;
import com.zxh.api.request.DelRequest;
import com.zxh.api.request.ListUserRequest;
import com.zxh.api.request.LoginRequest;
import com.zxh.api.request.UpdatePassWordRequest;
import com.zxh.entity.User;

public interface IUserService {

	// 用户登录
	User login(LoginRequest request);

	// 增加用户
	void addUser(AddOrUpdateUserRequest request);

	// 更新用户
	void updateUser(AddOrUpdateUserRequest request);

	// 删除用户
	void delUser(DelRequest request);

	// 用户列表
	PageInfo<User> listUser(ListUserRequest request);
	
	//更新密码
	void restPassWord(UpdatePassWordRequest request);
}
