package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.User;
import com.nt.service.IPersonService;

@Controller
public class PersonHandler {

	@Autowired
	public IPersonService ips;

	@RequestMapping
	public String homePage(Map<String,Object> map) {
		System.out.println("fuck of getMappinng");
		
		return "Home";
	}

	@RequestMapping("/details")
	public String process(Map<String,Object> map){
		Iterable<User> user=ips.findAllpersons();
		
		map.put("userObj", user);
		//lvn
		return "NewFile";
	}
	
	@GetMapping("/addUser")
	public String userAdd(Map<String,Object> map, @ModelAttribute("model") User user){
		//lvn
		return "AddUser";
	}

	
	@PostMapping("/reg")
	public String userRegister(Map<String,Object> map,@ModelAttribute("model") User user,RedirectAttributes attr){
		System.out.println(user);
		
		ips.savedata(user);
		//map.put("SucMsg","SuccessFully Added");
		attr.addFlashAttribute("SucMsg","Sucessfully Added");
		System.out.println("PersonHandler.userRegister()");
		System.out.println("saved success fully");
		//lvn
		return "redirect:person_redirect";
	}
	@GetMapping("/person_redirect")
	public String showPersonDetails(Map<String,Object> map){
		Iterable<User> user=ips.findAllpersons();
		map.put("userObj",user);
		//lvn
		return "NewFile";
	}
	
	@GetMapping("/update")
	public String UpdateUserData(@RequestParam("id") int no,@ModelAttribute("update") User user) {
		User use=ips.getUserForUpdate(no);
		BeanUtils.copyProperties(use,user);
		return "updateUser";
	}
	
	@PostMapping("/updateUser")
	public String UpdateAndSave(@ModelAttribute("update") User user,RedirectAttributes attr){
		System.out.println(user);
		
		ips.savedata(user);
		//map.put("SucMsg","SuccessFully Added");
		attr.addFlashAttribute("SucMsg","Sucessfully  Updated");
		
		System.out.println("Updated success fully");
		//lvn
		return "redirect:person_redirect";
	}
	
	@GetMapping("/delete")
	public String DeleteUser(@RequestParam("id") int no,RedirectAttributes attr) {
		ips.DeleteUserById(no);
		attr.addFlashAttribute("SucMsg","Sucessfully  deleted");
		return "redirect:person_redirect";
	}
	
	
}
