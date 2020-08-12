package edu.skku.db.customer;

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
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    OrderDAO dao=new OrderDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String action=request.getParameter("action");
		try {	
			if(action.equals("order")) {
				order(request, response);
			} else if (action.equals("list")){
				list(request, response);
			} else if (action.equals("save")) {
				save(request, response);
			} else if (action.equals("delete")) {
				delete(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Product> list= dao.order();
		request.setAttribute("list", list);
		System.out.println("주문 가능 목록 완료");
		request.getRequestDispatcher("Order.jsp").forward(request, response);
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession ss=request.getSession();
		List<Product> list=dao.list(ss.getAttribute("id").toString());
		request.setAttribute("order_list", list);
		request.getRequestDispatcher("OrderList.jsp").forward(request, response);
	}

	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, NumberFormatException {
		HttpSession ss=request.getSession();
		String pid=request.getParameter("pid");
		String number=request.getParameter("number");
		
		boolean ch=dao.save(pid,ss.getAttribute("id").toString(),Integer.parseInt(number));
		if(ch==false) {
			request.setAttribute("ordermsg", "개수를 다시 조정해주세요.");
			request.getRequestDispatcher("order.do?action=order").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("order.do?action=list").forward(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession ss=request.getSession();
		String id=request.getParameter("oid");//주문번호
		dao.delete(id);
		request.getRequestDispatcher("order.do?action=list").forward(request, response);
	}
	
}
