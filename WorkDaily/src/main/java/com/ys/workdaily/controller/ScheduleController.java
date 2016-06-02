package com.ys.workdaily.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ys.workdaily.pojo.Schedule;
import com.ys.workdaily.pojo.User;
import com.ys.workdaily.service.IScheduleService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Resource
	private IScheduleService scheduleService;

	/**
	 * 查询正在进行的项目
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:28:14
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/itemOngoing")
	public String itemOngoing(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "正在进行");
		model.addAttribute("schedules", schedules);
		model.addAttribute("user", user);
		return "item_ongoing";
	}

	/**
	 * 查询计划中的项目
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:28:45
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/itemPlan")
	public String itemPlan(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "待办事项");
		model.addAttribute("schedules", schedules);
		model.addAttribute("user", user);
		return "item_plan";
	}

	/**
	 * 查询已完成的项目
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:29:12
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/itemComplete")
	public String itemComplete(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "完成事项");
		model.addAttribute("schedules", schedules);
		model.addAttribute("user", user);
		return "item_complete";
	}

	/**
	 * 创建项目
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:29:27
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/itemCreate")
	public String itemCreate(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("loginUser");
		model.addAttribute("user", user);

		String edit = request.getParameter("edit");
		String type = request.getParameter("type");
		String content = request.getParameter("content");
		String level = request.getParameter("level");
		String operator = request.getParameter("operator");
		String note = request.getParameter("note");

		if ("1".equals(edit)) {
			Schedule schedule = new Schedule(type, content, level, operator, user.getUserName(), note);
			if (scheduleService.insert(schedule) > 0) {
				List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "待办事项");
				model.addAttribute("schedules", schedules);
				return "item_plan";
			} else {
				return "item_create";
			}
		} else {
			return "item_create";
		}
	}

	/**
	 * 删除项目
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:29:41
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteItem")
	public String deleteItem(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		scheduleService.deleteByPrimaryKey(id);
		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "待办事项");
		model.addAttribute("schedules", schedules);
		return "item_plan";
	}

	/**
	 * 更新项目状态为正在进行
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:29:57
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateItemToPlan")
	public String updateItemToPlan(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		Schedule schedule = scheduleService.selectByPrimaryKey(id);
		schedule.setStatus("正在进行");
		schedule.setExecuteTime(System.currentTimeMillis());
		scheduleService.updateByPrimaryKey(schedule);

		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "待办事项");
		model.addAttribute("schedules", schedules);
		return "item_plan";
	}

	/**
	 * 将项目状态更新为完成项目
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:31:29
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateItemToComplete")
	public String updateItemToComplete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		Schedule schedule = scheduleService.selectByPrimaryKey(id);
		schedule.setStatus("完成事项");
		schedule.setCompleteTime(System.currentTimeMillis());
		scheduleService.updateByPrimaryKey(schedule);

		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "正在进行");
		model.addAttribute("schedules", schedules);
		return "item_ongoing";
	}

}
