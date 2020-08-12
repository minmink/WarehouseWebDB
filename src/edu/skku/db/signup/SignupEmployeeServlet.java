package edu.skku.db.signup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup_employee.do")
public class SignupEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeSignupDAO dao=new EmployeeSignupDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet().....called...");
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()......called....");
		request.setCharacterEncoding("EUC-KR");
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String sex=request.getParameter("sex");
		
		Employee e=new Employee(id, password, name, age, sex);
		
		try {
			boolean ch=dao.save(e);
			if(ch==false) {
				request.setAttribute("esmsg", "아이디가 존재합니다.\n아이디를 바꿔주세요.");
				request.getRequestDispatcher("signup_employee.jsp").forward(request, response);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out=response.getWriter();
		out.print("<html><body>");
		out.print("<h1>결과페이지</h1>");
		out.print(name+"님 회원가입이 되었습니다.<br>로그인 해주세요.<br><a href='index.html'>메인 페이지로</a>");
		out.print("</body></html>");
		out.close();
	}
}
