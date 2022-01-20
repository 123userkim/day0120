package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.DeptDAO;

@Controller
public class DeleteDeptController {
	@Autowired
	private DeptDAO dao;
	
	 
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
 
	@RequestMapping("/deleteDept.do")
	public ModelAndView delete(int dno) {
		ModelAndView mav = new ModelAndView();
		int re = dao.delete(dno);
		if(re==1){
			mav.setViewName("deleteDeptOK");
		}else {
			mav.setViewName("error");
			mav.addObject("msg","부서 삭제에 실패하였습니다.");
		}
		return mav;
	}
	
}
