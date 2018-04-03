package com.san.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.san.domain.User;

public class CommandController extends AbstractCommandController{
	
	//指定参数绑定到那个javaBean
	public CommandController(){
		this.setCommandClass(User.class);
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		//把命令对象强制转化为User对象
		User user=(User) command;
		ModelAndView mv=new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("index");
		return mv;
	}
	
	@Override
	/**
	 * SpringMVC 时间转换
	 */
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		String str = request.getParameter("birthday");
		if(str.contains("/")){
			binder.registerCustomEditor(Date.class, 
					new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		}else if(str.contains("-")){
			binder.registerCustomEditor(Date.class, 
					new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		}
	}
}
