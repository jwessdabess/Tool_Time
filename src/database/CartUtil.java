package database;

public class CartUtil {
	
	public static double getCartTotal(Cart cart) {
		double totalCost = 0;
		for (Product product : cart.getCartItems()) {
			double thisProductCost = Double.parseDouble(product.getCost());
			totalCost = totalCost + thisProductCost;
		}
		
		return totalCost;
	}

}
