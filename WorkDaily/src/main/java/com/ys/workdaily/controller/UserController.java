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
import com.ys.workdaily.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;

	@Resource
	private IScheduleService scheduleService;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {

		String loginName = request.getParameter("username");
		String password = request.getParameter("password");

		User user = userService.getUserByNameAndPassword(loginName, password);

		if (user != null) {
			request.getSession().setAttribute("loginUser", user);
			model.addAttribute("user", user);
			List<Schedule> schedules = scheduleService.selectByUserAndStatus(user.getUserName(), "正在进行");
			model.addAttribute("schedules", schedules);
			return "item_ongoing";
		} else {
			return "login";
		}
	}
	
	@RequestMapping("/loginOff")
	public String loginOff(HttpServletRequest request, Model model) {
		request.getSession().removeAttribute("loginUser");
		return "login";
	}

}
