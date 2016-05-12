package com.ys.workdaily.dao;

import com.ys.workdaily.pojo.User;

public interface IUserDao {
	
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	
}
