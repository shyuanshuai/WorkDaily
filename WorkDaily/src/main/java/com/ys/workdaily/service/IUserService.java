package com.ys.workdaily.service;

import com.ys.workdaily.pojo.User;

public interface IUserService {

	public User getUserById(int userId);

	public User getUserByNameAndPassword(String userName, String password);

}
