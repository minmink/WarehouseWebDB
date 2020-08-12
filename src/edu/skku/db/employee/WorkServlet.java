package edu.skku.db.employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.skku.db.product.Product;

/**
 * Servlet implementation class WorkServlet
 */
@WebServlet("/work.do")
public class WorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    WorkDAO dao=new WorkDAO();   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String action=request.getParameter("action");
		try {
			if(action.equals("warehouse")) {
				warehouse(request, response);
			} else if (action.equals("release")) {
				release(request, response);
			} else if (action.equals("waitinglist")) {
				wlist(request,response);
			} else if (action.equals("releaselist")) {
				rlist(request,response);
			} else if (action.equals("productlist")) {
				plist(request,response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void warehouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession ss=request.getSession();
		String wid=request.getParameter("wid");
		String id=ss.getAttribute("id").toString();
		dao.warehouse(wid);
		dao.deleteW(wid, id);
		
		request.getRequestDispatcher("work.do?action=waitinglist").forward(request, response);
	}
	
	protected void release(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession ss= request.getSession();
		String rid=request.getParameter("rid");
		String id=ss.getAttribute("id").toString();
		dao.release(rid,id);
		request.getRequestDispatcher("work.do?action=releaselist").forward(request, response);
	}
	
	protected void wlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Product> list=dao.wlist();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Warehouse.jsp").forward(request, response);
	}
	
	protected void rlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Product> list=dao.rlist();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Release.jsp").forward(request, response);
	}

	protected void plist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Product> list=dao.plist();
		request.setAttribute("list", list);
		request.getRequestDispatcher("ProductList.jsp").forward(request, response);
	}
	
}
