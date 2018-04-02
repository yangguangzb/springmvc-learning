package com.san.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MyController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView();
		//设置页面回显数据
		mv.addObject("hello","欢迎学习springmvc");
		//返回物理视图
		mv.setViewName("index");
		return mv;
	}
	
}




















