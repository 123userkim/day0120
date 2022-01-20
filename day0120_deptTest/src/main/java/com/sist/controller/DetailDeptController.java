package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.DeptDAO;

 

@Controller
public class DetailDeptController {
	@Autowired	 
	private DeptDAO dao;
	 
	 
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping("/detailDept.do")
	public  ModelAndView detail(int dno) {
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("d",dao.getDept(dno));
		//mav.setViewName("detailCustomer.jsp")
		//요청한 서비스 이름과 같은 view로 설정할 때에, setViewName생략이 가능하하
		return mav;
	}
}
