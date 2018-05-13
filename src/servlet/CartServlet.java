package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Cart;
import database.CartUtil;
import database.DepartmentUtil;
import user.User;

/**
 * Servlet implementation class CartSevlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/cart.jsp";
		//session object
        HttpSession session = request.getSession();
		//User user = (User) session.getAttribute("results");
		
        //TEMPORARY USER
		User user = new User();
		user.setFirstName("Mike");
		user.setLastName("Wilkinson");
		user.setEmail("ltmikewilkinson@gmail.com");
		session.setAttribute("user", user);
		
		Cart cart = (Cart) session.getAttribute("cart");
		String productSKU = request.getParameter("SKU");
		String viewCart = request.getParameter("viewCart");
		String addToCart = request.getParameter("addToCart");
		String removeFromCart = request.getParameter("removeFromCart");
		int numItems;
		
		
		if (user == null) {
			url = "/login.jsp";
		}else {
			
			try {
	            
				Class.forName("com.mysql.jdbc.Driver");
	            String dbUrl = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3230335";
	            String dbUserName = "sql3230335";
	            String dbPassWord = "gvitcsZz4d";
	            Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassWord);
	        
	            if (cart == null) {
	            	cart = new Cart();
	            }
	            if (addToCart != null) {
	            	cart.addCartItem(DepartmentUtil.getProductBySKU(connection, productSKU));
	            }
	            if (removeFromCart != null) {
	            	cart.removeCartItem(DepartmentUtil.getProductBySKU(connection, productSKU));
	            }
	            
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				numItems = cart.getCartItems().size();
				double totalCost = CartUtil.getCartTotal(cart);
				session.setAttribute("cart", cart);
				session.setAttribute("cartItems",cart.getCartItems());
				session.setAttribute("numItems",numItems);
				session.setAttribute("totalCost", totalCost);
			}
			
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
