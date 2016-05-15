package com.ys.workdaily.controller;

import java.util.Date;
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

	@RequestMapping("/itemOngoing")
	public String itemOngoing(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "正在进行");
		model.addAttribute("schedules", schedules);
		model.addAttribute("user", user);
		return "item_ongoing";
	}

	@RequestMapping("/itemPlan")
	public String itemPlan(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "待办事项");
		model.addAttribute("schedules", schedules);
		model.addAttribute("user", user);
		return "item_plan";
	}

	@RequestMapping("/itemComplete")
	public String itemComplete(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "完成事项");
		model.addAttribute("schedules", schedules);
		model.addAttribute("user", user);
		return "item_complete";
	}

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
	
	@RequestMapping("/deleteItem")
	public String deleteItem(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		scheduleService.deleteByPrimaryKey(id);
		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "待办事项");
		model.addAttribute("schedules", schedules);
		return "item_plan";
	}

	@RequestMapping("/updateItemToPlan")
	public String updateItemToPlan(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		Schedule schedule = scheduleService.selectByPrimaryKey(id);
		schedule.setStatus("正在进行");
		schedule.setExecuteTime(new Date());
		scheduleService.updateByPrimaryKey(schedule);

		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "待办事项");
		model.addAttribute("schedules", schedules);
		return "item_plan";
	}

	@RequestMapping("/updateItemToComplete")
	public String updateItemToComplete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		Schedule schedule = scheduleService.selectByPrimaryKey(id);
		schedule.setStatus("完成事项");
		schedule.setCompleteTime(new Date());
		scheduleService.updateByPrimaryKey(schedule);

		User user = (User) request.getSession().getAttribute("loginUser");
		List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "正在进行");
		model.addAttribute("schedules", schedules);
		return "item_ongoing";
	}

}
