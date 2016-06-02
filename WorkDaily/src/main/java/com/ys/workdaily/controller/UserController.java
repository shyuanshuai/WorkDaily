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

	/**
	 * 系统登录
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:32:21
	 *
	 * @param request
	 * @param model
	 * @return
	 */
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

	/**
	 * 退出系统
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:32:35
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/loginOff")
	public String loginOff(HttpServletRequest request, Model model) {
		request.getSession().removeAttribute("loginUser");
		return "login";
	}

}
