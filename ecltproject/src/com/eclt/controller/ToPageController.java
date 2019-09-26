package com.eclt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author asus
 * 
 * 页面跳转
 */
@Controller
public class ToPageController {
	
	@RequestMapping("/index.do")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping("/product.do")
	public String toProduct(){
		return "product";
	}
	
	@RequestMapping("/case.do")
	public String toCase(){
		return "case";
	}
	
	@RequestMapping("/ncp.do")
	public String toNcp(){
		return "ncp";
	}
	
	@RequestMapping("/we.do")
	public String toWe(){
		return "we";
	}
}
