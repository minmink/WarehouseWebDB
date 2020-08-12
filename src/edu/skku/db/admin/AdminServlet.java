package edu.skku.db.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin.do")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDAO dao = new AdminDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String action=request.getParameter("action");
		try {	
			if(action.equals("wlist")) {
				wlist(request, response);
			} else if (action.equals("rlist")){
				rlist(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void wlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Processed> list=dao.wlist();
		request.setAttribute("list", list);
		request.getRequestDispatcher("WarehouseList.jsp").forward(request, response);
	}
	
	protected void rlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Processed> list=dao.rlist();
		request.setAttribute("list", list);
		request.getRequestDispatcher("ReleaseList.jsp").forward(request, response);
	}

}
