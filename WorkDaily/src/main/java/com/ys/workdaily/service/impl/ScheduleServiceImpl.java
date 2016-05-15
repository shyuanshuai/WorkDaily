package com.ys.workdaily.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ys.workdaily.dao.IScheduleDao;
import com.ys.workdaily.pojo.Schedule;
import com.ys.workdaily.service.IScheduleService;

@Service("scheduleService")
public class ScheduleServiceImpl implements IScheduleService {

	@Resource
	private IScheduleDao scheduleDao;
	
	public Schedule selectByPrimaryKey(String id) {
		return scheduleDao.selectByPrimaryKey(id);
	}

	public List<Schedule> selectByUserAndStatus(String operator, String status) {
		return scheduleDao.selectByUserAndStatus(operator, status);
	}

	public int deleteByPrimaryKey(String id) {
		return scheduleDao.deleteByPrimaryKey(id);
	}

	public int insert(Schedule schedule) {
		return scheduleDao.insert(schedule);
	}

	public int updateByPrimaryKey(Schedule schedule) {
		return scheduleDao.updateByPrimaryKey(schedule);
	}

}
