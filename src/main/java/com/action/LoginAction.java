package com.action;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.*;
import com.service.*;
import com.util.*;

@Controller
public class LoginAction {
	@Autowired
	private RizhiService rizhiService;
	@Autowired
	private UserService userService;
	@Autowired
	private YonghuService yonghuService;
	@Autowired
	private AdminService adminService;

	@RequestMapping("/loginUser")
	public String loginUser(HttpServletRequest request,
							HttpServletResponse response,
							Model model) throws Exception {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String loginType = request.getParameter("loginType");
		
		String ip = request.getRemoteAddr();
		Date date = new Date();
		Rizhi rizhi = new Rizhi();
		if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
			model.addAttribute("error", "用户名或密码为空！");
			return "index";
		} else {
			if (loginType.equals("admin")) {
				Admin admin = new Admin();
				admin.setAdminName(userName);
				admin.setAdminPassword(password);
				try {
					if (adminService.queryAdmins(admin, 0, 0).size()==1) {						
						rizhi.setRizhiName(userName);
						rizhi.setDate(date);
						rizhi.setDengluIp(ip);
						rizhiService.save(rizhi);
						// 获取Session
						HttpSession session=request.getSession();
						session.setAttribute("admin", admin);
						// 客户端跳转
						return "adminMain";
					}else{
						model.addAttribute("error", "用户名或密码错误！");
						// 服务器跳转
						return "index";
					}
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("error", "服务器错误！");
					// 服务器跳转
					return "index";
				}
			} else if (loginType.equals("yonghu")){
				Yonghu yonghu = new Yonghu();
				yonghu.setYonghuName(userName);
				yonghu.setYonghuPassword(password);
				try {
					if (yonghuService.queryYonghus(yonghu, userName, 0, 0, null, null).size() == 1) {
						rizhi.setRizhiName(userName);
						rizhi.setDate(date);
						rizhi.setDengluIp(ip);
						rizhiService.save(rizhi);
						Yonghu yonghuLogin = (Yonghu)(yonghuService.queryYonghus(yonghu, userName, 0, 0, null, null)).get(0);
						// 获取Session
						HttpSession session=request.getSession();
						session.setAttribute("yonghu", yonghuLogin);
						// 客户端跳转
						return "yonghuMain";
					}else{
						model.addAttribute("error", "用户名或密码错误！");
						// 服务器跳转
						return "index";
					}
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("error", "服务器错误！");
					// 服务器跳转
					return "index";
				}
			}else{
				User user = new User();
				user.setUserName(userName);
				user.setUserPassword(password);
				try {
					if (userService.queryUsers(user, userName, 0, 0, null, null).size() == 1) {
						rizhi.setRizhiName(password);
						rizhi.setDate(date);
						rizhi.setDengluIp(ip);
						rizhiService.save(rizhi);
						User userLogin = (User)(userService.queryUsers(user, userName, 0, 0, null, null)).get(0);
						// 获取Session
						HttpSession session=request.getSession();
						session.setAttribute("user", userLogin);
						// 客户端跳转
						return "userMain";
					}else{
						model.addAttribute("error", "用户名或密码错误！");
						// 服务器跳转
						return "index";
					}
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("error", "服务器错误！");
					// 服务器跳转
					return "index";
				}
			}
		}
	}
}
