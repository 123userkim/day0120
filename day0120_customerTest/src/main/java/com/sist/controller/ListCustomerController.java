package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.CustomerDAO;
import com.sist.vo.CustomerVO;
 
@Controller
public class ListCustomerController {
	@Autowired
	//모든 고객의 정보를 읽어오기 위한 dao가 필요함
	private CustomerDAO dao;
	 
	//setter에 의해서 초기화가 됨
	public void setDao(CustomerDAO dao) {
		this.dao = dao;
	}
	
	//실제로 반환하는 것()안에 요청하는 서비스명을 적어주기
	@RequestMapping("/listCustomer.do")
	//메소드 이름은 (listDept)아무거나
	public ModelAndView listDept() {
		ModelAndView mav = new ModelAndView();
		
		//list를 상태유지를 시킴
		mav.addObject("list",dao.listAll());		
		mav.setViewName("listCustomer");
		return mav;
	}
	
	@RequestMapping("/detailCustomer.do")
	public  ModelAndView detail(int custid) {
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("c",dao.getCustomer(custid));
		//mav.setViewName("detailCustomer.jsp")
		//요청한 서비스 이름과 같은 view로 설정할 때에, setViewName생략이 가능하하
		return mav;
	}
}
