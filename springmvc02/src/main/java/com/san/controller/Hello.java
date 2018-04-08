package com.san.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		//添加注解,相当于<bean class="Hello类的全限定名"/>
public class Hello {
	
	@RequestMapping("hello")	//请求的方法
	public String myHello(){
		return "hello";
	}
}
