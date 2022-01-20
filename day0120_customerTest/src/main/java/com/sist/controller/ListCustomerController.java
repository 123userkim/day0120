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
	//��� ���� ������ �о���� ���� dao�� �ʿ���
	private CustomerDAO dao;
	 
	//setter�� ���ؼ� �ʱ�ȭ�� ��
	public void setDao(CustomerDAO dao) {
		this.dao = dao;
	}
	
	//������ ��ȯ�ϴ� ��()�ȿ� ��û�ϴ� ���񽺸��� �����ֱ�
	@RequestMapping("/listCustomer.do")
	//�޼ҵ� �̸��� (listDept)�ƹ��ų�
	public ModelAndView listDept() {
		ModelAndView mav = new ModelAndView();
		
		//list�� ���������� ��Ŵ
		mav.addObject("list",dao.listAll());		
		mav.setViewName("listCustomer");
		return mav;
	}
	
	@RequestMapping("/detailCustomer.do")
	public  ModelAndView detail(int custid) {
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("c",dao.getCustomer(custid));
		//mav.setViewName("detailCustomer.jsp")
		//��û�� ���� �̸��� ���� view�� ������ ����, setViewName������ ��������
		return mav;
	}
}
