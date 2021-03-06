/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author MikeWilkinson
 */
public class Product implements Serializable{
    
    private int SKU;
    private String name;
    private String description;
    private String cost;
    private String dimensions;
    private String department;
    private String category;
    private String imagePath;
    private int quantity;
    
    public Product(){
        
    }

    /**
     * @return the SKU
     */
    public int getSKU() {
        return SKU;
    }

    /**
     * @param SKU the SKU to set
     */
    public void setSKU(int SKU) {
        this.SKU = SKU;
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
    public String getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(String cost) {
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
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
    public boolean equals(Object o) {
    	if (this == o) {
    		return true;
    	}
    	if (o == null) {
    		return false;
    	}
    	if (getClass() != o.getClass()) {
    		return false;
    	}
    	Product product = (Product) o;
    	return Objects.equals(SKU, product.SKU);
    }
    
    
}
