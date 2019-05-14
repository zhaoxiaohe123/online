package com.zxh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zxh.api.request.AddOrUpdateUserRequest;
import com.zxh.api.request.DelRequest;
import com.zxh.api.request.ListUserRequest;
import com.zxh.api.request.LoginRequest;
import com.zxh.api.request.UpdatePassWordRequest;
import com.zxh.api.service.IUserService;
import com.zxh.entity.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/user/")
public class UserController {

	@Autowired
	IUserService userService;

	// 用户登录
	@ApiOperation(value = "用户登录", notes = "用户登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "account", value = "账号", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String", paramType = "body") })
	@RequestMapping(value = "login/v1", method = RequestMethod.POST)
	public User login(@RequestBody LoginRequest request) {
		return userService.login(request);
	}

	// 增加用户
	@ApiOperation(value = "增加用户", notes = "增加用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "account", value = "账号", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "role", value = "角色", required = true, dataType = "String", paramType = "body") })
	@RequestMapping(value = "add/v1", method = RequestMethod.POST)
	public void addUser(@RequestBody AddOrUpdateUserRequest request) {
		userService.addUser(request);
	}

	// 更新用户
	@ApiOperation(value = "更新用户", notes = "更新用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "account", value = "账号", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String", paramType = "body"),
			@ApiImplicitParam(name = "role", value = "角色", required = true, dataType = "String", paramType = "body") })
	@RequestMapping(value = "update/v1", method = RequestMethod.POST)
	public void updateUser(@RequestBody AddOrUpdateUserRequest request) {
		userService.updateUser(request);
	}

	// 删除用户
	@ApiOperation(value = "删除用户", notes = "删除用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "body") })
	@RequestMapping(value = "del/v1", method = RequestMethod.POST)
	public void delUser(@RequestBody DelRequest request) {
		userService.delUser(request);
	}

	// 用户列表
	@ApiOperation(value = "用户列表", notes = "用户列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "int", paramType = "body"),
			@ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "body"),
			@ApiImplicitParam(name = "role", value = "角色", required = true, dataType = "String", paramType = "body") })
	@RequestMapping(value = "list/v1", method = RequestMethod.POST)
	public PageInfo<User> listUser(@RequestBody ListUserRequest request) {
		return userService.listUser(request);
	}

	// 更新密码
	@ApiOperation(value = "更新密码", notes = "更新密码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "body"),
		@ApiImplicitParam(name = "oldPass", value = "旧密码", required = true, dataType = "String", paramType = "body"),
		@ApiImplicitParam(name = "newPass", value = "新密码", required = true, dataType = "String", paramType = "body") })
	@RequestMapping(value = "restPassWord/v1", method = RequestMethod.POST)
	public void restPassWord(@RequestBody UpdatePassWordRequest request) {
		userService.restPassWord(request);
	}
}
