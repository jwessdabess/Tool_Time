/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooltime.util;

import com.tooltime.products.Category;
import com.tooltime.products.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;


/**
 *
 * @author MikeWilkinson
 */
public class DepartmentUtil {
    
    public static List<Product> getProducts(Connection connection, String department) throws SQLException{
    	
    	String queryProductsForDepartment = "SELECT * FROM PRODUCT "
                + "WHERE DEPARTMENT = ?";
    	PreparedStatement productsForDepartmentStatement = connection.prepareStatement(queryProductsForDepartment);
    	productsForDepartmentStatement.setString(1,department);
        ResultSet productsForDepartmentResult = productsForDepartmentStatement.executeQuery();
        
        List<Product> theProducts = new ArrayList<>();
        
        while(productsForDepartmentResult.next()) {
        	String imageName = productsForDepartmentResult.getString("IMAGE_NAME");
        	theProducts.add(DepartmentUtil.findProductFromImageName(connection,department,imageName));
        }
        return theProducts;
    }
    
    public static List<String> getCategories(List<Product> theProducts){
        
        List<String> theCategories = new ArrayList<>();
        theProducts.stream().filter((theProduct) -> (!theCategories.contains(theProduct.getCategory()))).forEachOrdered((theProduct) -> {
            theCategories.add(theProduct.getCategory());
        });
        return theCategories;
    }
    
    public static List<Category> getDepartmentCategories(List<Product> theProducts){
        List<Category> theCategories = new ArrayList<>();
        theProducts.forEach((theProduct) -> {
            boolean foundMatch = false;
            for (Category theCategory : theCategories) {
                if (theCategory.getName() == null ? 
                        theProduct.getCategory() == null : 
                        theCategory.getName().equals(theProduct.getCategory())) {
                    foundMatch = true;
                }
            }
            if (!foundMatch) {
                Category nextCategory = new Category();
                nextCategory.setDepartment(theProduct.getDepartment());
                nextCategory.setName(theProduct.getCategory());
                nextCategory.setImagePath(theProduct.getImagePath());
                theCategories.add(nextCategory);
            }
        });
        return theCategories;
    }
    
    public static List<Product> filterProductsByCategory(List<Product> theProducts,String theCategory){
        
        List<Product> filteredProducts = new ArrayList<>();
        theProducts.stream().filter((theProduct) -> (theProduct.getCategory().equals(theCategory))).forEachOrdered((theProduct) -> {
            filteredProducts.add(theProduct);
        });
        return filteredProducts;
    }
    
    private static Product findProductFromImageName(Connection connection,String department,String imageName) throws SQLException {
    	
    	String queryProducts = "SELECT * FROM PRODUCT "
                + "WHERE DEPARTMENT = ?"
    			+ "AND IMAGE_NAME = ?";
    	PreparedStatement productsFromImageStatement = connection.prepareStatement(queryProducts);
    	productsFromImageStatement.setString(1,department);
    	productsFromImageStatement.setString(2, imageName);
        ResultSet resultSet = productsFromImageStatement.executeQuery();
        
        Product nextProduct = new Product();
    	while (resultSet.next()){
    	
    		
        nextProduct.setImage("departments/" + resultSet.getString("DEPARTMENT").toLowerCase() + "_images/" + resultSet.getString("IMAGE_NAME"));
        nextProduct.setCost(resultSet.getString("COST"));
        nextProduct.setDepartment(resultSet.getString("DEPARTMENT"));
        nextProduct.setDescription(resultSet.getString("DESCRIPTION"));
        nextProduct.setDimensions(resultSet.getString("LENGTH") + "x" + resultSet.getString("HEIGHT") + 
        		"x" + resultSet.getString("WIDTH") + " " + resultSet.getString("UNITS"));
        nextProduct.setName(resultSet.getString("NAME"));
        nextProduct.setSKU(Integer.parseInt(resultSet.getString("SKU")));
        nextProduct.setCategory(resultSet.getString("CATEGORY").trim());
    	}
        return nextProduct;
    }
    
}
