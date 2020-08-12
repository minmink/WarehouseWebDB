package edu.skku.db.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.skku.db.product.Product;

public class WorkDAO {

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
	
	public void deleteW(String id, String eid) throws SQLException {
		Connection con=getConnection();
		String q="select pid,number from waiting_list where id="+id+";";
		PreparedStatement ps=con.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		rs.next();
		String pid=rs.getString(1);
		int number=rs.getInt(2);
		rs.close();
		
		q="insert into warehouse(wid,pid,number,eid) values ('"
				+ id+"','"+pid+"',"+number+",'"+eid+"');";
		ps=con.prepareStatement(q);
		ps.executeUpdate();
		
		q="delete from waiting_list where id="+id+";";
		ps=con.prepareStatement(q);
		int count = ps.executeUpdate();
		
		if(count>0) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
		ps.close();
		con.close();
	}
	
	public void release(String id,String eid) throws SQLException {
		Connection con=getConnection();
		String q="update order_list set process='�����' where id="+id+";";
		System.out.println(q);
		PreparedStatement ps=con.prepareStatement(q);
		int count = ps.executeUpdate();
		
		if(count>0) {
			System.out.println("��� ����");
		} else {
			System.out.println("��� ����");
		}
		
		q="select pid,cid,number from order_list where id="+id+";";
		ps=con.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		rs.next();
		String pid=rs.getString(1);
		String cid=rs.getString(2);
		int number=rs.getInt(3);
		rs.close();
		
		q="insert releasing(rid,pid,number,eid,cid) values ('"
				+id +"','"+pid+"',"+number+",'"+eid+"','"+cid+"');";
		ps=con.prepareStatement(q);
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}

	public List<Product> wlist() throws SQLException {
		Connection con=getConnection();
		String q="select id,w.pid,p.name,w.number,p.space"
				+" from waiting_list w left join product p on w.pid=p.pid;";
		PreparedStatement ps=con.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		List<Product> list=new ArrayList<Product>();
		while(rs.next()) {
			Product p=new Product();
			p.setId(Integer.toString(rs.getInt(1)));
			p.setPid(rs.getString(2));
			p.setName(rs.getString(3));
			p.setNumber(rs.getInt(4));
			p.setSpace(rs.getString(5));
			list.add(p);
		}
		
		rs.close();
		ps.close();
		con.close();
		return list;
	}
	
	public List<Product> rlist() throws SQLException {
		Connection con=getConnection();
		String q="select id,o.pid,p.name,o.number,p.space"
				+" from order_list o left join product p on o.pid=p.pid"
				+" where process<>'�����';";
		PreparedStatement ps=con.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		List<Product> list=new ArrayList<Product>();
		while(rs.next()) {
			Product p=new Product();
			p.setId(Integer.toString(rs.getInt(1)));
			p.setPid(rs.getString(2));
			p.setName(rs.getString(3));
			p.setNumber(rs.getInt(4));
			p.setSpace(rs.getString(5));
			list.add(p);
		}
		
		rs.close();
		ps.close();
		con.close();
		return list;
	}
	
	public void warehouse(String id) throws SQLException {
		Connection con=getConnection();
		String q="select pid, number from waiting_list where id="+id+";";
		PreparedStatement ps=con.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		rs.next();
		String pid=rs.getString(1);
		int number=rs.getInt(2);
		
		q="update product set number=number+"+number+" where pid='"+pid+"';";
		ps=con.prepareStatement(q);
		int count = ps.executeUpdate();
		
		if(count>0) {
			System.out.println("�԰� ����");
		} else {
			System.out.println("�԰� ����");
		}
		ps.close();
		con.close();
	}
	
	public List<Product> plist() throws SQLException {
		Connection con=getConnection();
		String q="select * from product;";
		System.out.println(q);
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
		System.out.println("list: "+list.size());
		rs.close();
		ps.close();
		con.close();
		return list;
	}
	
}
