package com.ys.workdaily.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ys.workdaily.pojo.Schedule;

public interface IScheduleDao {

	Schedule selectByPrimaryKey(String id);

	List<Schedule> selectByUserAndStatus(@Param("operator") String operator, @Param("status") String status);
	
	int deleteByPrimaryKey(String id);
	
	int insert(Schedule schedule);
	
	int updateByPrimaryKey(Schedule schedule);

}
