   package com.vastika.uis.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.util.ImageUtil;

@Controller
//@Slf4f will directly allow you to use logger if using lombak
 public class UserController {
 	
	//logger if not using lombak and getLogger(whatever is class name.class)
	private static final Logger log = Logger.getLogger(UserController.class);
	
 	@Autowired
 	private UserService userService;
 	
 	
 	@RequestMapping("/user_form")
 	public String getUserForm() {
 		log.info("user form is opened");
 		return "createUser";
 	}

 	@RequestMapping("/user_edit")
 	public String editUserForm(@RequestParam int id, Model model) {
 		log.info ("user edit form is opened for id {}" + id);
		
 		model.addAttribute("u" , userService.getUserById(id) );
 		return "editUser";
 	}
 	
 	@RequestMapping(value= "/user_save", method = RequestMethod.POST)
 	public String saveUser(@ModelAttribute @Valid User user, BindingResult result, @RequestParam CommonsMultipartFile file) {
 		
 		if(result.hasErrors()) {
 			log.error("error is: "+ result.getFieldError());
			//model.addAttribute("error", result.getFieldError() );
			log.fatal("this is fatal error");
			return "createUser";
		}
 		
// 		String fileName= file.getOriginalFilename();
 		
 		String imagePath= ImageUtil.writeImageToFile(file);
 		log.info("image path is "+ imagePath);
 		user.setImagePath(imagePath);
 		
 		userService.saveUserInfo(user);
 		log.info("user image is saved sucessfully");
 		return "redirect:/user_list";
 	}
 	
 	
 	@RequestMapping(value= "/user_update", method = RequestMethod.POST)
 	public String updateUser(@ModelAttribute User user, @RequestParam CommonsMultipartFile file, Model model) {
 		log.warn("filepath must not be null");
 		
 		if(file!=null) {
 			String imagePath= ImageUtil.writeImageToFile(file);
 	 		user.setImagePath(imagePath);
 		}
 		userService.updateUserInfo(user);
 		return "redirect:/user_list";
 	}
 	
 	
 	@RequestMapping(value= "/user_list", method = RequestMethod.GET)
 	public String getAllUser(Model model) {
 		model.addAttribute("users" , userService.getAllUserInfo());
 		return "listUser";
 	}
 	
 	@RequestMapping(value= {"/user_delete"}, method = RequestMethod.GET)
 	public String deleteUserInfo(@RequestParam int id) {
 		 userService.deleteUserInfo(id);
 		 return "redirect:/user_list";
 	}
 	
 }
