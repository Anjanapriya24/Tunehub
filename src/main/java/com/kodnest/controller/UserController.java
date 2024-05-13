package com.kodnest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kodnest.entity.Song;
import com.kodnest.entity.User;
import com.kodnest.service.SongService;
import com.kodnest.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	SongService songservice;
	
	@PostMapping("/register")
	//@ResponseBody
public String userdata(@ModelAttribute User user) {         //email from user-from
		boolean userExists = userservice.emailExists(user);//to check user with email present or no
		if(userExists==false) {
	userservice.SaveUser(user);
	System.out.print("user added successfully");
		}
		else {
			System.out.println("Duplicate user");
		}
		return "Login";
	}
		@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session, Model model) { 
			//System.out.println(email+ "-" +password+"login");
			if( userservice.validUser(email,password)==true) {
				session.setAttribute("email",email);
				String role=userservice.getRole(email);
				if(role.equals("admin")) {
					return"adminhome";
				}
				else {
					  User user=userservice.getUser(email);
					  boolean userstatus=user.isPremium();
					  
					  List<Song> fetchAllSongs= songservice.fetchAllSongs();
					  model.addAttribute("songs",fetchAllSongs);
					  model.addAttribute("ispremium",userstatus);
					  return"customerhome";
				}
				
			}
			else {
				return "Login";
			}
    }
		@GetMapping("logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "Login";
		}
@GetMapping("/exploresongs")
public String exploresongs(String email) {
	return email;
}
		
	
}
