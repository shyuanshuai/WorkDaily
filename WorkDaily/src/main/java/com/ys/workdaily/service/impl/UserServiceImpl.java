package com.ys.workdaily.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ys.workdaily.dao.IUserDao;
import com.ys.workdaily.pojo.User;
import com.ys.workdaily.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	public User getUserById(int userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	public User getUserByNameAndPassword(String userName, String password) {
		return userDao.selectByNameAndPassword(userName, password);
	}

}
