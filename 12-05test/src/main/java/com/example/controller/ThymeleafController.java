package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.User;
import com.example.service.UserService;



@Controller
public class ThymeleafController {
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping("test1")
//	public String showTest1(HttpServletRequest request) {
//		request.setAttribute("msg", "qwer");
//		return "show";
//	}
	
	@RequestMapping("showUser")
	public String showUser(Model model) {
		List<User> list = userService.findAllUser();
		model.addAttribute("list", list);
		return "showUser";
	}
	
	@RequestMapping("toAddUser")
	public String toaddUser() {
		return "addUser";
	}
	
	@RequestMapping("addUser")
	public String addUser(@ModelAttribute("User") User user) {
		System.out.println(user);
		userService.addUser(user);
		return "ok";
	}
	
	@RequestMapping("toupdate")
	public String toupdateUser(@RequestParam String id,Model model) {
		int parseInt = Integer.parseInt(id);
		System.out.println(parseInt);
		User user = userService.findUserById(parseInt);
		model.addAttribute(user);
		return "updateUser";
	}
	
	@RequestMapping("updateUser")
	public String updateUser(@ModelAttribute("User") User newUser) {
		userService.updateUser(newUser);
		return "ok";
	}
	
//	@RequestMapping("test2")
//	public String showTest2(Model model) {
//		List<User> list = new ArrayList<User>();
//		User u1 = new User(1, "aaa", 1, "111");
//		User u2 = new User(2, "bbb", 0, "222");
//		User u3 = new User(3, "ccc", 0, "333");
//		User u4 = new User(4, "ddd", 1, "444");
//		
//		list.add(u1);
//		list.add(u2);
//		list.add(u3);
//		list.add(u4);
//		
//		model.addAttribute("list", list);
//		
//		return "showUser";
//	}
	
	
}
