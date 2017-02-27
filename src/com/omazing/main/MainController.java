package com.omazing.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	public MainController(){
		System.out.println("MainController()");
	}
	
	@RequestMapping(value="/main.do")
	public String resumeIn(){
		return "/resources/views/main.jsp";

	}

}
