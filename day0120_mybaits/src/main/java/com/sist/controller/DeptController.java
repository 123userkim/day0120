package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

@Controller
public class DeptController {
		
	
		@Autowired
		private DeptDAO dao;

		public void setDao(DeptDAO dao) {
			this.dao = dao;
		}
		
		@RequestMapping("/listDept.do")
		public ModelAndView list() {
			ModelAndView mav = new ModelAndView();
			mav.addObject("list", dao.listAll());
			
			return mav;
		}
		
		@RequestMapping("/detailDept.do")
		public ModelAndView detail(int dno) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("d",dao.getDept(dno));
			return mav;
		}
		
		@RequestMapping(value= "/insertDept.do", method = RequestMethod.GET)
		public void insertForm() {
			//��û�� �̸��� �䰡 �����ϸ� �ϸ� ��
		}
		
		@RequestMapping(value= "/insertDept.do", method = RequestMethod.POST)
		public ModelAndView insertSubmit(DeptVO d) {
			int re = dao.insertDept(d);
			ModelAndView mav = new ModelAndView("redirect:/listDept.do");
			if(re!=1) {
				mav.setViewName("error");
				mav.addObject("msg","�μ� ��Ͽ� �����Ͽ����ϴ�.");
			}
			return mav;
		}		
		
		
		
		@RequestMapping(value= "/updateDept.do", method = RequestMethod.GET)
		public ModelAndView updateForm(int dno) {
			ModelAndView mav = new ModelAndView( );
			mav.addObject("d",dao.getDept(dno));
			return mav;
		}
		
		@RequestMapping(value= "/updateDept.do", method = RequestMethod.POST)
		public ModelAndView updateSubmit(DeptVO d) {
			int re = dao.updateDept(d);
			ModelAndView mav = new ModelAndView();
			if(re!=1) {
				mav.setViewName("error");
				mav.addObject("msg","�μ� ��Ͽ� �����Ͽ����ϴ�.");
			}else {
				mav.setViewName("updateDeptOK");
			}
			return mav;
		}		
		
		
		@RequestMapping("/deleteDept.do")
		public ModelAndView delete(int dno) {
			ModelAndView mav = new ModelAndView();
			int re = dao.deleteDept(dno);
			if(re == 1) {
				mav.setViewName("deleteDeptOK");
			}else {
				mav.addObject("msg", "�� ������ �����Ͽ����ϴ�.");
				mav.setViewName("error");
			}
			return mav;
		}
	}
