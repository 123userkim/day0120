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
			//view이름은 객체 생성시에 받을 수 있음
			return mav;
		}
	*/
	
	
	public void form() {
		//따로 view를 설정하지 않는다면, 내가 요청한 이름(("/insertDept.do"))의 view를 찾음
	}
	
	@RequestMapping(/*value="/insertDeptOK.do",*/method=RequestMethod.POST)	
		public ModelAndView submit(DeptVO d) { //Command object 라고 부름:DeptVO
			ModelAndView mav = new ModelAndView();
			int re = dao.insert(d);
			if(re==1) {
				mav.setViewName("insetDeptOK");
			}else {
				mav.addObject("msg","부서등록에 실패하였습니다.");
				mav.setViewName("error");
			}
			return mav;
		}
		
		//서비스명을 같게해도 상관 x -> 작동하는 메소드의 방식이 다르니까
}
