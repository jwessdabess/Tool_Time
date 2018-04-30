/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooltime.util;

import com.tooltime.products.Category;
import com.tooltime.products.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 *
 * @author MikeWilkinson
 */
public class DepartmentUtil {
    
    public static List<Product> getProducts(String department,Set<String> imagePaths){
        List<Product> theProducts = new ArrayList<>();
        int PLUCount = 1234567;
        for (String imagePath : imagePaths) {
            if (imagePath.contains(".jpg")) {
                Product nextProduct = new Product();
                nextProduct.setImage(imagePath.replaceFirst("/", ""));
                nextProduct.setCost(0);
                nextProduct.setDepartment(department);
                nextProduct.setDescription("A dummy description for this " + department  + "product");
                nextProduct.setDimensions("1 x 1");
                String[] splitString = imagePath.split("[\\/\\.]");
                nextProduct.setName(splitString[splitString.length-2]);
                nextProduct.setPLU(PLUCount);
                nextProduct.setCategory(nextProduct.getName().replaceAll("\\d", ""));
                PLUCount++;
                theProducts.add(nextProduct);
            }
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
    
}
