package edu.skku.db.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.skku.db.product.Product;

public class OrderDAO {

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
	
	public List<Product> order() throws SQLException {
		Connection con=getConnection();
		String q="Select * from product where number>0;";
		PreparedStatement ps=con.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		List<Product> list=new ArrayList<Product>();
		while(rs.next()) {
			Product p=new Product();
			p.setPid(rs.getString(1));
			p.setName(rs.getString(2));
			p.setKind(rs.getString(3));
			p.setPrice(rs.getString(4));
			p.setNumber(rs.getInt(5));
			p.setSpace(rs.getString(6));
			list.add(p);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
	}
	
	public List<Product> list(String cid) throws SQLException {
		Connection con=getConnection();
		String q="select id,o.pid,p.name,p.kind,p.price,o.number,p.space,o.process"
				+ " from order_list o left join product p on o.pid=p.pid"
				+ " where cid='"+cid+"' and o.pid<>'';";
		PreparedStatement ps=con.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		List<Product> list=new ArrayList<Product>();
		while(rs.next()) {
			Product p=new Product();
			p.setId(Integer.toString(rs.getInt(1)));
			p.setPid(rs.getString(2));
			p.setName(rs.getString(3));
			p.setKind(rs.getString(4));
			p.setNumber(rs.getInt(6));
			p.setPrice(Integer.toString(Integer.parseInt(rs.getString(5))*p.getNumber()));
			p.setSpace(rs.getString(7));
			p.setProcess(rs.getString(8));
			list.add(p);
		}
		
		rs.close();
		ps.close();
		con.close();
		return list;
	}

	public boolean save(String pid,String cid, int number) throws SQLException {
		Connection con=getConnection();
		
		if(check(pid, number, con)==false) {
			return false;
		}

		String q="update product set number=number-"+number+" where pid='"+pid+"';";
		PreparedStatement ps=con.prepareStatement(q);
		int count=ps.executeUpdate();
		System.out.println(q);
		if(count>0) {
			System.out.println("주문1 성공");
		} else {
			System.out.println("주문1 실패");
			ps.close();
			con.close();
			return false;
		}
		q="insert into order_list(pid,cid,number,process) values ('"
				+pid+"','"+cid+"',"+number+",'준비중');";
		ps=con.prepareStatement(q);
		count=ps.executeUpdate();
		System.out.println(q);
		if(count>0) {
			System.out.println("주문2 성공");
		} else {
			System.out.println("주문2 실패");
			ps.close();
			con.close();
			return false;
		}
		ps.close();
		con.close();
		return true;
	}

	public boolean check(String pid, int number, Connection con) throws SQLException {

		String q="Select pid from product where number>="+number+" and pid='"+pid+"';";
		System.out.println(q);
		PreparedStatement ps=con.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			rs.close();
			ps.close();
			return true;
		}
		rs.close();
		ps.close();
		return false;
		
	}
	
	public void delete(String id) throws SQLException {
		Connection con=getConnection();
		String q="delete from order_list where id='"+id+"';";
		PreparedStatement ps=con.prepareStatement(q);
		int count = ps.executeUpdate();
		
		if(count>0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		ps.close();
		con.close();
	}

	
}
