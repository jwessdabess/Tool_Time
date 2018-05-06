package membership.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.*;
import database.*;

import java.lang.*;
import java.text.*;
import java.util.*;


/**
 * Servlet implementation class MembershipServlet
 */
@WebServlet("/MembershipServlet")
public class MembershipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembershipServlet() {
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
		
		//default url
        String url = "/login.jsp";
        ServletContext sc = getServletContext();
        
        //session object
        HttpSession session = request.getSession();
        
        String message=" ";
        
        // get current action
        String action = request.getParameter("action");
        
        // When the user clicks on Registration
        if (action.equals("toRegister")) {
       	url = "/register.jsp";
        }
         //When the user clicks login
        else if (action.equals("login")) {
             //validate the parameters
        	String email = request.getParameter("email");
        	String password = request.getParameter("password");
            if (UserDB.emailExists(email) && UserDB.correctPassword(email, password)) {
            	url = "/index.jsp";
            	User user = UserDB.selectUser(email);
                session.setAttribute("results", user);   
            }
            else {
                message = "You have entered an incorrect email or password. Try again.";
                url = "/login.jsp";
            }
        }
        
        // When the user clicks register
        else if (action.equals("register")){
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
        	String password = request.getParameter("Password");
        	String bStreet = request.getParameter("bStreet");
        	String bCity = request.getParameter("bCity");
        	String bState = request.getParameter("bState");
        	String bZip = request.getParameter("bZip");
        	String dStreet = request.getParameter("dStreet");
        	String dCity = request.getParameter("dCity");
        	String dState = request.getParameter("dState");
        	String dZip = request.getParameter("dZip");
        	String creditCardType = request.getParameter("paymentMethod");
        	String cardNumber = request.getParameter("cardNumber");
        	String expDay = request.getParameter("ExpDay");
        	String expYear = request.getParameter("ExpYear");
        	String cvv = request.getParameter("cvv");

            User user = (User) session.getAttribute("results");
            // store data in User object
            if (user == null)
            	user = new User();
        	user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setbStreet(bStreet);
            user.setbCity(bCity);
            user.setbState(bState);
            user.setbZip(bZip);
            user.setdStreet(dStreet);
            user.setdCity(dCity);
            user.setdState(dState);
            user.setdZip(dZip);
            user.setCreditCardType(creditCardType);
            user.setCardNumber(Integer.parseInt(cardNumber));
            user.setExpDay(Integer.parseInt(expDay));
            user.setExpYear(Integer.parseInt(expYear));
            user.setCvv(Integer.parseInt(cvv));
            
            url = "/index.jsp";
            
            //insert into DB
            UserDB.insert(user);
            session.setAttribute("results", user);   
        }
        //request.setAttribute("message", message);

        sc.getRequestDispatcher(url).forward(request, response);
	}

}
