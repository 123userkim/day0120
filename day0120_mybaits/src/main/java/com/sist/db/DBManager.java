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
	//mybaits �������Ͽ� �����ϱ� ���� SqlSessionFactory�� ����
	//�� ������ ��ü ���̵� ������ �� �ֵ���
	//SqlSessionFactory: �����ͺ��̽����� ����� SQL�� ���࿡ ���� ��� ���� ���� ���� �߿��� ��ü
	private static SqlSessionFactory sqlMapper;
	
	//���α׷� ����� ���ÿ� �ڵ����� �����Ͽ�
	//mybaits ���������� �о� ���̱� ���ؼ� static ���� �ڵ�
	static {
		try {
			//���������� �о����
			Reader reader 
			= Resources.getResourceAsReader("com/sist/db/sqlMapConfig.xml");
			
			//mybatis ���������� ��Ʈ���� ���� sql�� ����� �� �ִ� SqlSessionFactory ��ü�� ����
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
	
	//���������� Ư�� sql(dept�� selectAll�̶�� ���̵� ����)�� ��û�ϴ� �޼ҵ带 ���ϱ�
	public static List<DeptVO> listAll(){
		//mybaits �������Ͽ� �ִ� sql�� ����ϱ� ���Ͽ�
		//SqlSessionFactory�� ���� session�� ����
		SqlSession session= sqlMapper.openSession();
		
		//SqlSessio�� ���ؼ� sql����
		//sqlSession�� crud�� ���� insert,update,delete,select�޼ҵ���� ����
		//������ selectList�� �̿���
		//�̶� �Ű������� mubatis�������Ͽ� �ִ� ���ӽ����̽�(dept) id(selectAll) ��������
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
		
		//�����ͺ��̽��� ������ �ִ� sql(insert, update, delete)�� ������ ���� �ݵ��
		//session.commit() OR rollback�޼ҵ带 ȣ���ؾ���
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
		
		//�����ͺ��̽��� ������ �ִ� sql(insert, update, delete)�� ������ ���� �ݵ��
		//session.commit() OR rollback�޼ҵ带 ȣ���ؾ���
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
		
		//�����ͺ��̽��� ������ �ִ� sql(insert, update, delete)�� ������ ���� �ݵ��
		//session.commit() OR rollback�޼ҵ带 ȣ���ؾ���
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

