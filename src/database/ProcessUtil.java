package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.MessagingException;

import email.MailYahoo;
import user.User;

public class ProcessUtil {

	public static int getLastOrderID(Connection connection) {
		
		int results = -1;
		
		try {
			
			String statement = "SELECT * FROM ORDERS ORDER BY Id DESC LIMIT 1";
			PreparedStatement ps = connection.prepareStatement(statement);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
            	results = ( (Number) rs.getObject(1) ).intValue();
            }
            
            ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return ( results );
		
		
	}
	
	public static void insertOrder(Connection connection, Cart cart, int orderNum, long userNum) {
		
		try {
			
			String statement = 
					"INSERT into ORDERS (Id, UserId, Sku, Cost) values (?,?,?,?)";
					
				PreparedStatement ps = connection.prepareStatement(statement);
				
				for (Product p : cart.getCartItems()) {
				
					ps.setInt(1, orderNum);
					ps.setLong(2, userNum);
					ps.setInt(3, p.getSKU());
					ps.setString(4, p.getCost());
					ps.executeUpdate();
				}
				
				ps.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void sendConfirmEmail(User user, Cart cart, int orderNum, double total) {
		
		String cartConfirm = "";
		
		for (Product p : cart.getCartItems() ) {
			cartConfirm = 
					cartConfirm
					+ p.getName()
					+ ":   "
					+ p.getCost()
					+ "\n";
		}
		
		String to = user.getEmail();
        String from = "sdough11@yahoo.com";
        String subject = "Order Confirmation - Order #" + orderNum;
        String body = "Dear " + user.getFirstName() + ",\n\n"
                + "Thank you for placing your most recent order!"
        		+ "\n\n"
        		+ "PURCHASED ITEMS:"
        		+ "\n"
        		+ cartConfirm
                + "\n\n"
                + "TOTAL:   "
                + total
                + "\n\n"
                + "Thank You";
        boolean isBodyHTML = false;

        try {
            
        	MailYahoo.sendMail(to, from, subject, body, isBodyHTML);
        	
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
	
}
