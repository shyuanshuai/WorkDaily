package com.ys.workdaily.service;

import java.util.List;

import com.ys.workdaily.pojo.Schedule;

public interface IScheduleService {

	public Schedule selectByPrimaryKey(String id);

	public List<Schedule> selectByUserAndStatus(String operator, String status);
	
	public int deleteByPrimaryKey(String id);
	
	public int insert(Schedule schedule);
	
	public int updateByPrimaryKey(Schedule schedule);
	
}
