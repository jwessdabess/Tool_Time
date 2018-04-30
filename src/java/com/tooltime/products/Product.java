/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooltime.products;

import java.io.Serializable;

/**
 *
 * @author MikeWilkinson
 */
public class Product implements Serializable{
    
    private int PLU;
    private String name;
    private String description;
    private double cost;
    private String dimensions;
    private String department;
    private String category;
    private String imagePath;
    
    public Product(){
        
    }

    /**
     * @return the PLU
     */
    public int getPLU() {
        return PLU;
    }

    /**
     * @param PLU the PLU to set
     */
    public void setPLU(int PLU) {
        this.PLU = PLU;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the dimensions
     */
    public String getDimensions() {
        return dimensions;
    }

    /**
     * @param dimensions the dimensions to set
     */
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the image
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String imagePath) {
        this.imagePath = imagePath;
    }
    
    
}
