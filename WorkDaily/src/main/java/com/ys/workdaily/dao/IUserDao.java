package com.ys.workdaily.dao;

import org.apache.ibatis.annotations.Param;

import com.ys.workdaily.pojo.User;

public interface IUserDao {

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectByNameAndPassword(@Param("userName") String userName, @Param("password") String password);

}
