package servlet;

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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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
        boolean logged = false;
        
        User user = (User) session.getAttribute("results");
        if (user == null) {
        	logged = false;
        	session.setAttribute("logged", logged);
        	url = "/loginMessage.jsp";
        }
        else
        {
        	logged = true;
        	message=" ";
        	url = "/accountView.jsp";
        }
                
        sc.getRequestDispatcher(url).forward(request, response);
	}

}
