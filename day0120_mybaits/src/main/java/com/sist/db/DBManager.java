package com.sist.db;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

public class DBManager {
	//mybaits 설정파일에 접근하기 위한 SqlSessionFactory를 선언
	//이 변수에 객체 없이도 접근할 수 있도록
	//SqlSessionFactory: 데이터베이스와의 연결과 SQL의 실행에 대한 모든 것을 가진 가장 중요한 객체
	private static SqlSessionFactory sqlMapper;
	
	//프로그램 실행과 동시에 자동으로 실행하여
	//mybaits 설정파일을 읽어 들이기 위해서 static 블럭에 코딩
	static {
		try {
			//설정파일을 읽어들임
			Reader reader 
			= Resources.getResourceAsReader("com/sist/db/sqlMapConfig.xml");
			
			//mybatis 설정파일의 스트림을 통해 sql을 사용할 수 있는 SqlSessionFactory 객체를 생성
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	//설정파일의 특정 sql(dept의 selectAll이라는 아이디를 갖는)을 요청하는 메소드를 정하기
	public static List<DeptVO> listAll(){
		//mybaits 설정파일에 있는 sql을 사용하기 위하여
		//SqlSessionFactory를 통해 session을 얻어옴
		SqlSession session= sqlMapper.openSession();
		
		//SqlSessio을 통해서 sql실행
		//sqlSession엔 crud를 위한 insert,update,delete,select메소드들이 있음
		//지금은 selectList를 이용함
		//이때 매개변수로 mubatis설정파일에 있는 네임스페이스(dept) id(selectAll) 전달해줌
		List<DeptVO> list  =session.selectList("dept.selectAll");
		session.close();
		return list;
	}
	
	
	
	public static DeptVO getDept(int dno) {
		SqlSession session = sqlMapper.openSession();
		DeptVO d = session.selectOne("dept.selectDept",dno);
		session.close();
		return d;
	}
	
	
	public static int insert(DeptVO d) {
		int re=-1;
		SqlSession session = sqlMapper.openSession();		
		re = session.insert("dept.insert",d);
		
		//데이터베이스에 변경이 있는 sql(insert, update, delete)을 실행할 때에 반드시
		//session.commit() OR rollback메소드를 호출해야함
		if(re==1) {
			session.commit();
		}
		session.close();
		return re;
	}
	
	
	public static int update(DeptVO d) {
		int re=-1;
		SqlSession session = sqlMapper.openSession();		
		re = session.update("dept.update",d);
		
		//데이터베이스에 변경이 있는 sql(insert, update, delete)을 실행할 때에 반드시
		//session.commit() OR rollback메소드를 호출해야함
		if(re==1) {
			session.commit();
		}
		session.close();
		return re;
	}
	
	
	public static int delete(int dno) {
		int re=-1;
		SqlSession session = sqlMapper.openSession();		
		re = session.delete("dept.delete",dno);
		
		//데이터베이스에 변경이 있는 sql(insert, update, delete)을 실행할 때에 반드시
		//session.commit() OR rollback메소드를 호출해야함
		if(re==1) {
			session.commit();
		}
		session.close();
		return re;
	}
	
	 
		public static List<EmpVO> listEmp(){			 
			SqlSession session= sqlMapper.openSession();
			 
			List<EmpVO> list  = session.selectList("emp.selectAll");
			session.close();
			return list;
		}
		
}

