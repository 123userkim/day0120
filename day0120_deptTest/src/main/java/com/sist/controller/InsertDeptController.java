package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

@Controller
@RequestMapping("/insertDept.do")
public class InsertDeptController {
	@Autowired
	private DeptDAO dao;
	 
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(/*value="/insertDept.do",*/method=RequestMethod.GET)
	/*	
	public ModelAndView form() {
			ModelAndView mav = new ModelAndView("insertDept");
			//mav.setViewName("insertDept");
			//view�̸��� ��ü �����ÿ� ���� �� ����
			return mav;
		}
	*/
	
	
	public void form() {
		//���� view�� �������� �ʴ´ٸ�, ���� ��û�� �̸�(("/insertDept.do"))�� view�� ã��
	}
	
	@RequestMapping(/*value="/insertDeptOK.do",*/method=RequestMethod.POST)	
		public ModelAndView submit(DeptVO d) { //Command object ��� �θ�:DeptVO
			ModelAndView mav = new ModelAndView();
			int re = dao.insert(d);
			if(re==1) {
				mav.setViewName("insetDeptOK");
			}else {
				mav.addObject("msg","�μ���Ͽ� �����Ͽ����ϴ�.");
				mav.setViewName("error");
			}
			return mav;
		}
		
		//���񽺸��� �����ص� ��� x -> �۵��ϴ� �޼ҵ��� ����� �ٸ��ϱ�
}
