package database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{
	private List<Product> CartItems;
	
	public Cart() {
		CartItems = new ArrayList<>();
	}

	public List<Product> getCartItems() {
		return CartItems;
	}

	public void setCartItems(List<Product> cartItems) {
		CartItems = cartItems;
	}
	
	public void addCartItem(Product cartItem) {
		CartItems.add(cartItem);
	}
	public void removeCartItem(Product cartItem) {
		CartItems.remove(cartItem);
	}
}
