package com.vastika.uis.controller;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.util.EmailUtil;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping (value= {"/login"})
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping (value="/logout", method= RequestMethod.GET)
		public String logout() {
			return  "redirect:/login";
	}
	
	@RequestMapping (value="/accessdenied", method= RequestMethod.GET)
	public String accessDenied(ModelMap model) {
		model.addAttribute("error", "true");
		return  "accessDenied";
		}
	
	@PostMapping(value="/forgot_password")
	public String forgetPassword(@RequestParam String email) {
		System.out.println("email is: "+ email);
		User user = userService.getUserInfoByEmail(email);
		if(user!=null) {
			String newPassword=generateNewPassword();
			user.setPassword(newPassword);
			userService.updateUserInfo(user);
			String subject="Forgot password";
			String message= "Your new password is: "+ newPassword;
			EmailUtil.sendEmail(mailSender, email, subject, message);
		}
		return "redirect:/login";
	}
	
	public String generateNewPassword() {
		SecureRandom random= new SecureRandom();
		return new BigInteger(50, random).toString(32);
	}
}
