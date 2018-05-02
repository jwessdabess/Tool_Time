/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooltime.servlets;

import com.tooltime.products.Category;
import com.tooltime.products.Product;
import com.tooltime.util.DepartmentUtil;
import java.io.IOException;

import java.util.List;
import java.util.Set;
import javax.servlet.ServletContext;
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
        ServletContext servletContext = getServletContext();
        String department = request.getParameter("department");
        String createCategoryPage = request.getParameter("categoryPage");
        String category = request.getParameter("category");
        String url = "/web/department.jsp";
        List<Product> products = null;
        List<Category> departmentCategories = null;
        List<String> categories = null;
        Set<String> imagePaths  = null;
        
        switch (department){
            case "electrical":
                imagePaths = servletContext.getResourcePaths("/web/departments/electrical_images");
                break;
            case "hardware":
                imagePaths = servletContext.getResourcePaths("/web/departments/hardware_images");
                break;
            case "paint":
                imagePaths = servletContext.getResourcePaths("/web/departments/paint_images");
                break;
            case "plumbing":
                imagePaths = servletContext.getResourcePaths("/web/departments/plumbing_images");
                break;
            case "tools" :
                imagePaths = servletContext.getResourcePaths("/web/departments/tools_images");
                break;      
        }

        products = DepartmentUtil.getProducts(department,imagePaths);
        categories = DepartmentUtil.getCategories(products);
        if (createCategoryPage != null){
            departmentCategories = DepartmentUtil.getDepartmentCategories(products);
            url = "/web/department_category.jsp";
            request.setAttribute("categories", departmentCategories);
        }
        else{
            request.setAttribute("categories", categories);
        }
        if (category != null){
            products = DepartmentUtil.filterProductsByCategory(products, category);
            url = "/web/shopByCategory.jsp";
            request.setAttribute("category", category);
        }
        
        //department = department.substring(0, 1).toUpperCase() + department.substring(1);
        request.setAttribute("products", products);
        request.setAttribute("department", department);
        
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
