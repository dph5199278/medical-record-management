package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.*;
import com.service.*;

@Controller
public class AdminAction {
	@Autowired
	private AdminService adminService;

	@RequestMapping("/mimaAdmin")
	public String mimaAdmin(HttpServletRequest request,
							HttpServletResponse response,
							Model model) {
		String adminPassword = request.getParameter("adminPassword");
		String adminPassword1 = request.getParameter("adminPassword1");
		Admin admin = new Admin();
		admin.setAdminName("admin");
		admin.setAdminPassword(adminPassword);
		if (adminService.queryAdmins(admin, 0, 0).size()==1) {
			admin = (Admin)(adminService.queryAdmins(admin, 0, 0)).get(0);
			admin.setAdminPassword(adminPassword1);
			adminService.modifyAdmin(admin);
			model.addAttribute("error", "密码修改成功！");
		}else{
			model.addAttribute("error", "原密码错误，请重新输入！");
		}
		return "adminmima";
	}
}
