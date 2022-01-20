package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.CustomerDAO;
import com.sist.vo.CustomerVO;
 
 

@Controller
@RequestMapping("/insertCustomer.do")
public class InsetCustomerController {
	@Autowired
	private CustomerDAO dao;

	public void setDao(CustomerDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(CustomerVO c) { //Command object ��� �θ�:DeptVO
		ModelAndView mav = new ModelAndView();
		int re = dao.insert(c);
		if(re==1) {
			mav.setViewName("insetCustomerOK");
		}else {
			mav.addObject("msg","�� ��Ͽ� �����Ͽ����ϴ�.");
			mav.setViewName("error");
		}
		return mav;
	}
	
}
