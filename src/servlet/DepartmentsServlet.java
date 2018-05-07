/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import database.Category;
import database.Product;
import database.DepartmentUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MikeWilkinson
 */
@WebServlet(name = "DepartmentsServlet", urlPatterns = {"/shopDepartment"})
public class DepartmentsServlet extends HttpServlet {

    

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String department = request.getParameter("department");
        String createCategoryPage = request.getParameter("categoryPage");
        String category = request.getParameter("category");
        String url = "/department.jsp";
        List<Product> products = null;
        List<Category> departmentCategories = null;
        List<String> categories = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9235659";
            String dbUserName = "sql9235659";
            String dbPassWord = "cBYz7nz3Rw";
            Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassWord);
        
            products = DepartmentUtil.getProducts(connection,department);
            categories = DepartmentUtil.getCategories(products);
        if (createCategoryPage != null){
            departmentCategories = DepartmentUtil.getDepartmentCategories(products);
            url = "/department_category.jsp";
            request.setAttribute("categories", departmentCategories);
        }
        else{
            request.setAttribute("categories", categories);
        }
        if (category != null){
            products = DepartmentUtil.filterProductsByCategory(products, category);
            url = "/shopByCategory.jsp";
            request.setAttribute("category", category);
        }
        
        request.setAttribute("products", products);
        request.setAttribute("department", department);
        } catch (SQLException | ClassNotFoundException e) {
        	e.printStackTrace();
		}
        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
