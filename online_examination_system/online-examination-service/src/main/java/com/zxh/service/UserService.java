package com.zxh.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxh.api.exception.UserException;
import com.zxh.api.request.AddOrUpdateUserRequest;
import com.zxh.api.request.DelRequest;
import com.zxh.api.request.ListUserRequest;
import com.zxh.api.request.LoginRequest;
import com.zxh.api.request.UpdatePassWordRequest;
import com.zxh.api.service.IUserService;
import com.zxh.dao.IUserDao;
import com.zxh.entity.User;

@Service
public class UserService implements IUserService {

	private static final Logger log = Logger.getLogger(UserService.class);

	@Autowired
	IUserDao userDao;

	@Override
	public User login(LoginRequest request) {
		log.info(String.format("login,request is %s", JSONObject.toJSONString(request)));
		User u = userDao.selectByAccount(request.getAccount());
		if (u == null) {
			throw new UserException("当前账号不存在");
		}
		if (!request.getPassWord().equalsIgnoreCase(u.getPassWord())) {
			throw new UserException("当前账号密码不正确");
		}
		return u;
	}

	@Override
	public void addUser(AddOrUpdateUserRequest request) {
		log.info(String.format("addUser,request is %s", JSONObject.toJSONString(request)));
		User u = userDao.selectByAccount(request.getAccount());
		if (u != null) {
			throw new UserException("当前账号已存在");
		}
		userDao.insert(new User().setAccount(request.getAccount()).setCreateTime(new Date())
				.setPassWord(request.getPassWord()).setRole(request.getRole()));
	}

	@Override
	public void updateUser(AddOrUpdateUserRequest request) {
		log.info(String.format("updateUser,request is %s", JSONObject.toJSONString(request)));

		User user = userDao.selectByAccount(request.getAccount());

		if (user != null && !user.getId().equalsIgnoreCase(request.getId())) {
			throw new UserException("当前更新的账号已被使用，请重新修改");
		}

		User u = userDao.get(request.getId());
		u.setAccount(request.getAccount()).setPassWord(request.getPassWord()).setRole(request.getRole());
		userDao.updateById(u);
	}

	@Override
	public void delUser(DelRequest request) {
		log.info(String.format("delUser,request is %s", JSONObject.toJSONString(request)));
		userDao.deleteById(request.getId());
		// 应该删除用户考试资料？
	}

	@Override
	public PageInfo<User> listUser(ListUserRequest request) {
		log.info(String.format("listUser,request is %s", JSONObject.toJSONString(request)));
		PageInfo<User> info = PageHelper.startPage(request.getPageNum(), request.getPageSize())
				.doSelectPageInfo(new ISelect() {
					@Override
					public void doSelect() {
						userDao.selectByCondition(request.getRole());
					}
				});
		return info;
	}

	@Override
	public void restPassWord(UpdatePassWordRequest request) {
		log.info(String.format("restPassWord,request is %s", JSONObject.toJSONString(request)));

		User u = userDao.selectByAccount(request.getId());
		if (u == null) {
			throw new UserException("当前账号不存在");
		}

		if (!request.getOldPass().equalsIgnoreCase(u.getPassWord())) {
			throw new UserException("原密码错误，请重新输入");
		}
		u.setPassWord(request.getNewPass());
		userDao.updateById(u);
	}

}
