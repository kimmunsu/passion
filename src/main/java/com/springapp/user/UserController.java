package com.springapp.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/user/Login")
	public String executeLogin(@RequestParam("userId") String userId,
								@RequestParam("userPassword") String userPassword,
								ModelMap model,
								HttpSession session){
		
		try {
			User user = userService.findByUserIdNPassword(userId, userPassword);
			model.addAttribute("userInfo", user);
			model.addAttribute("message", user.getUserId()+"님, 반갑습니다.");
			session.setAttribute("loginUser", user);
		} catch (NotFoundUserByUserIdNPasswordException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "/user/Welcome";
	}
	
	@RequestMapping("/user/Join")
	public String executeJoin(@ModelAttribute User user, ModelMap model, HttpSession session){
		try {
			userService.join(user);
			model.addAttribute("message", user.getUserId()+"님, 환영합니다.");
			session.setAttribute("loginUser", user);
		} catch (ExistedUserException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "/user/Welcome";
	}
	
	@RequestMapping("/user/Deactive")
	public String executeDeactive(ModelMap model, HttpSession session){
		boolean isSuccessDeactiveProcess = false;
		User user = (User)session.getAttribute("loginUser");
		if(user!=null){
			isSuccessDeactiveProcess = userService.deactive((User)session.getAttribute("loginUser"));
			session.removeAttribute("loginUser");
		}
		model.addAttribute("message", isSuccessDeactiveProcess ? "진달래꽃 즈려 밟고 가시옵소서." : "정상적인 접근이 아닙니다.");
		return "/user/Login";
	}
	
	@RequestMapping("/user/Logout")
	public String executeLogout(ModelMap model, HttpSession session){
		User user = (User)session.getAttribute("loginUser");
		if(user!=null)
			session.removeAttribute("loginUser");
		model.addAttribute("message", user!=null?"로그아웃 되었습니다." : "정상적인 접근이 아닙니다.");
		return "/user/Login";
	}
}