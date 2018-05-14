package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ProcessUtil;
import database.Cart;
import user.User;

/**
 * Servlet implementation class OrderProcessServlet
 */
@WebServlet("/OrderProcess")
public class OrderProcessServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int orderNumber = -1;
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("results");
		Cart cart = (Cart) session.getAttribute("cart");
		double total = (double) session.getAttribute("totalCost");
		
		try {
			
			//CONNECT TO DATABASE
			Class.forName("com.mysql.jdbc.Driver");
	        String dbUrl = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3230335";
	        String dbUserName = "sql3230335";
	        String dbPassWord = "gvitcsZz4d";
	        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassWord);
	        
	        //ASSIGN ORDER NUMBER
			orderNumber = ProcessUtil.getLastOrderID(connection) + 1;
			
			//PUSH ORDER DATA TO DATBASE
			ProcessUtil.insertOrder(connection, cart, orderNumber, user.getUserID());
			
			//SEND OUT CONFIRMATION EMAIL
			ProcessUtil.sendConfirmEmail(user, cart, orderNumber, total);
			
			connection.close();
			
			//DIRECT TO CONFIRMATION PAGE
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/confirm.jsp");
			dispatcher.forward(request, response);
	        
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
