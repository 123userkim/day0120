package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.stereotype.Repository;

import com.sist.db.ConnectionProvider;
import com.sist.vo.CustomerVO;
 
 
@Repository
public class CustomerDAO {
	
	//--------------삭제하기--------------
		public int deleteCustomer(int custid) {
			int re= -1;
			try {
				String sql = "delete customer where custid=?";
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			 
				pstmt.setInt(1, custid);
	 
				 re= pstmt.executeUpdate();
				 ConnectionProvider.close(conn, pstmt, null);
			}catch(Exception e) {
				
			}
			return re;
		}
	
	//--------------수정하기--------------
	public int update(CustomerVO c) {
		int re= -1;
		try {
			String sql = "update customer set name=?, address=?, phone=? where custid=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getAddress());
			pstmt.setString(3, c.getPhone());
			pstmt.setInt(4, c.getCustid());
 
			 re= pstmt.executeUpdate();
			 ConnectionProvider.close(conn, pstmt, null);
		}catch(Exception e) {
			
		}
		return re;
	}
	
		//--------------상세보기--------------
		public CustomerVO getCustomer(int custid) {
			CustomerVO c= null;
			String sql="select * from customer where custid=?";
			try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, custid);
				ResultSet rs =pstmt.executeQuery();
				
				if(rs.next()) {
					c = new CustomerVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				}
				ConnectionProvider.close(conn, pstmt, rs);
			}catch(Exception e) {
				
			}
			return c;
		}
	
		//--------------추가하기--------------
		public int insert(CustomerVO c) {
			int re= -1;
			try {
				String sql = "insert into customer values(?,?,?,?)";
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, c.getCustid());
				pstmt.setString(2, c.getName());
				pstmt.setString(3, c.getAddress());
				pstmt.setString(4, c.getPhone());
	 
				 re= pstmt.executeUpdate();
				 ConnectionProvider.close(conn, pstmt, null);
			}catch(Exception e) {
				
			}
			return re;
		}
		
	
		//--------------전체보여주기--------------
	public ArrayList<CustomerVO> listAll(){
		ArrayList<CustomerVO>list= new ArrayList<CustomerVO>();
		String sql ="select * from customer order by custid";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt =  conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new CustomerVO(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4) ));
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch(Exception e) {
			
		}
		return list;
	}

 
}
