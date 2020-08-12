package edu.skku.db.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginEmployeeServlet
 */
@WebServlet("/login_employee.do")
public class LoginEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeLoginDAO dao = new EmployeeLoginDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet().....called...");
		doPost(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost().....called...");
		request.setCharacterEncoding("EUC-KR");
		
		String action=request.getParameter("action");
		try {
			if(action.equalsIgnoreCase("LOGIN")){//대소문자 상관 없이
				login(request, response);
				return;
			}else if(action.equalsIgnoreCase("LOGOUT")){
				logout(request,response);
				return;
			}else if(action.equalsIgnoreCase("delete")){
				delete(request,response);
				return;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		try {
			if(dao.loginCheck(id, password)) {

				HttpSession ss=request.getSession();
				ss.setAttribute("id", id);
				ss.setAttribute("person", "employee");
				RequestDispatcher rd=request.getRequestDispatcher("EmployeeIndex.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String msg="아이디 또는 패스워드가 틀립니다.";
		request.setAttribute("elmsg", msg);
		request.getRequestDispatcher("login_employee.jsp").forward(request, response);
		
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession ss=request.getSession(false);
		if(ss!=null) ss.invalidate();
		request.getRequestDispatcher("index.html").forward(request, response);
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession ss=request.getSession();
		String id=ss.getAttribute("id").toString();
		dao.delete(id);
		request.getRequestDispatcher("index.html").forward(request, response);
	}
	
}
