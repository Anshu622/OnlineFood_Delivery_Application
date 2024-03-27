package org.FoodDelivery.Controller;

import org.FoodDelivery.Model.Login;
import org.FoodDelivery.Model.LoginToken;
import org.FoodDelivery.Model.User;
import org.FoodDelivery.Service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/login")
@SessionAttributes("userId")
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private User user;
	
	@GetMapping("/customerlogin")
	public String login(Model model)
	{
		Login login=new Login();
		model.addAttribute("login",login);
	return "login/login";
	}
	
	@GetMapping("/adminlogin")
	public String adminLogin(Model model)
	{
		Login login=new Login();
		model.addAttribute("login",login);
	return "login/adminlogin";
	}
	
@PostMapping("/customerlogin")
public String checkLogin(@ModelAttribute("login") Login login,Model model) {
		user=loginService.validateLogin(login.getEmail(), login.getPassWord());
		if(user==null)
			return "login/loginFailed";
		else {
			model.addAttribute("userId",user.getUserId());
			return "login/loginSuccess";
		}
			
}

@PostMapping("/adminlogin")
public String checkAdminLogin(@ModelAttribute("login")Login login,Model model) {
	if(login.getEmail().equals("root") && login.getPassWord().equals("18112001")) {
		return "login/adminLoginSuccess";
	}else
			return "login/adminLoginFailed";
	}
}

