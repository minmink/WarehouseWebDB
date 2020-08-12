package edu.skku.db.signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerSignupDAO {
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
	
	public boolean save(Customer c) throws SQLException {
		Connection con=getConnection();
		
		if(check(c, con)==false) {
			return false;
		}
		
		String q="Insert into Customer values('"+c.getId()+"', '"+c.getPassword()
		+"', '"+c.getName()+"', '"+c.getAge()+"', '"+c.getSex()+"', '"+c.getAddress()+"');";
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
	
	public boolean check(Customer c, Connection con) throws SQLException {

		String q="Select id from customer where id='"+c.getId()+"';";
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
