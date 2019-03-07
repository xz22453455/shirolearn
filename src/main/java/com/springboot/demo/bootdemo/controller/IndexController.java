package com.springboot.demo.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webSocket")
public class IndexController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
}
