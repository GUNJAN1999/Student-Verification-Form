package com.student.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController 
{
	//need the controller method to show the initial html form
	
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
		
	//need a controller method to process the html form
	
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}
	
	//new controller method to read form data and add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request,Model model)
	{
		//read the request parameter from html form
		String theName=request.getParameter("studentName");
		//convert data to uppercase
		theName=theName.toUpperCase();	
		//create the message
		String result="YO YO : "+theName;
		//add message to model
		model.addAttribute("message",result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName			
			,Model model)
	{
		
		//convert data to uppercase
		theName=theName.toUpperCase();	
		//create the message
		String result="Namesty from v3! : "+theName;
		//add message to model
		model.addAttribute("message",result);
		return "helloworld";
	}

}






















