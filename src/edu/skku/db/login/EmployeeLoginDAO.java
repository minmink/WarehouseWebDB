package edu.skku.db.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeLoginDAO {
	
	static { //��Ŭ������ �޸𸮿� �ε��Ǹ� �ڵ�����
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql Ŭ���� ����");
			e.printStackTrace();
			System.exit(1);
		}
	}
	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/final?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "dksalsrud01");
		return con;
	}
	
	public boolean loginCheck(String id, String password) throws SQLException {
		Connection con=getConnection();
		String q="Select password from employee where id='"+id+"';";
		PreparedStatement ps=con.prepareStatement(q);

		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			String pw=rs.getString(1);
			if(pw.equals(password)) {
				rs.close();
				ps.close();
				con.close();
				return true;
			}
		}
		
		rs.close();
		ps.close();
		con.close();
		return false;
	}
	
	public void delete(String id) throws SQLException {
		Connection con=getConnection();
		String q="delete from employee where id='"+id+"';";
		PreparedStatement ps=con.prepareStatement(q);
		System.out.println(q);
		int count=ps.executeUpdate();
		
		if(count>0) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
		
		ps.close();
		con.close();
	}

}
