package com.ys.workdaily.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ys.workdaily.pojo.Schedule;
import com.ys.workdaily.service.impl.ScheduleServiceImpl;

/**
 * @author YuanShuai E-mail:shyuanshuai@163.com
 * @date 2016年6月2日 下午9:41:25
 * @version 1.0
 * @parameter
 * @since 
 * @return 
 */
public class ScheduleServiceTest {

	@Test
	public void testInsert() {
		IScheduleService service = new ScheduleServiceImpl();
		
		Schedule schedule = new Schedule("C", "测试事项", "A", "yuanshuai", "yuanshuai", "note");
		
		assertEquals(0, service.insert(schedule));
	}
	
}
