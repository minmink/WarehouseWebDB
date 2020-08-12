package edu.skku.db.signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeSignupDAO {

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
		System.out.println("�����ͺ��̽� ���� ����");
		return con;
	}
	
	public boolean save(Employee e) throws SQLException {
		Connection con=getConnection();
		
		if(check(e, con)==false) {
			return false;
		}
		
		String q="Insert into Employee values('"+e.getId()+"', '"+e.getPassword() 
						+"', '"+e.getName()+"', '"+e.getAge()+"', '"+e.getSex()+"');";
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
		return true;
	}
	
	public boolean check(Employee e, Connection con) throws SQLException {

		String q="Select id from employee where id='"+e.getId()+"';";
		System.out.println(q);
		PreparedStatement ps=con.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			rs.close();
			ps.close();
			return false;
		}
		rs.close();
		ps.close();
		return true;
	
	}
	
}
