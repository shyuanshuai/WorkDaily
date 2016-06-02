package com.ys.workdaily.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ys.workdaily.pojo.Schedule;

public interface IScheduleDao {

	/**
	 * 根据主键id查询单个事项
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:35:10
	 *
	 * @param id
	 *            主键
	 * @return 单个事项实体
	 */
	Schedule selectByPrimaryKey(String id);

	/**
	 * 根据条件查询事项集合
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:35:53
	 *
	 * @param operator
	 *            操作人
	 * @param status
	 *            事项状态
	 * @return 事项集合
	 */
	List<Schedule> selectByUserAndStatus(@Param("operator") String operator, @Param("status") String status);

	/**
	 * 根据主键删除单个事项实体
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:37:29
	 *
	 * @param id
	 *            主键
	 * @return
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * 新增事项
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:38:11
	 *
	 * @param schedule
	 *            事项实体
	 * @return
	 */
	int insert(Schedule schedule);

	/**
	 * 根据主键更新事项
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:38:44
	 *
	 * @param schedule
	 * @return
	 */
	int updateByPrimaryKey(Schedule schedule);

}
