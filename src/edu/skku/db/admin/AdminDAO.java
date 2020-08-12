package edu.skku.db.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

	static { //이클래스가 메모리에 로딩되면 자동실행
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql 클래스 없음");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/final?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "dksalsrud01");
		return con;
	}
	
	public List<Processed> wlist() throws SQLException {
		Connection con=getConnection();
		String q="select * from warehouse;";
		PreparedStatement ps=con.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		List<Processed> list=new ArrayList<Processed>();
		while (rs.next()) {
			Processed p=new Processed();
			p.setId(rs.getInt(1));
			p.setWid(rs.getString(2));
			p.setPid(rs.getString(3));
			p.setNumber(rs.getInt(4));
			p.setEid(rs.getString(5));
			list.add(p);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
	}
	
	public List<Processed> rlist() throws SQLException {
		Connection con=getConnection();
		String q="select * from releasing;";
		PreparedStatement ps=con.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		List<Processed> list=new ArrayList<Processed>();
		while (rs.next()) {
			Processed p=new Processed();
			p.setId(rs.getInt(1));
			p.setRid(rs.getString(2));
			p.setPid(rs.getString(3));
			p.setNumber(rs.getInt(4));
			p.setEid(rs.getString(5));
			p.setCid(rs.getString(6));
			list.add(p);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
	}
	
}
