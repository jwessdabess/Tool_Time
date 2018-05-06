package user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userID;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String bStreet;
	private String bCity;
	private String bState;
	private String bZip;
	private String dStreet;
	private String dCity;
	private String dState;
	private String dZip;
	private String creditCardType;
	private int cardNumber;
	private int expDay;
	private int expYear;
	private int cvv;

	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getbStreet() {
		return bStreet;
	}
	public void setbStreet(String bStreet) {
		this.bStreet = bStreet;
	}
	public String getbCity() {
		return bCity;
	}
	public void setbCity(String bCity) {
		this.bCity = bCity;
	}
	public String getbState() {
		return bState;
	}
	public void setbState(String bState) {
		this.bState = bState;
	}
	public String getbZip() {
		return bZip;
	}
	public void setbZip(String bZip) {
		this.bZip = bZip;
	}
	public String getdStreet() {
		return dStreet;
	}
	public void setdStreet(String dStreet) {
		this.dStreet = dStreet;
	}
	public String getdCity() {
		return dCity;
	}
	public void setdCity(String dCity) {
		this.dCity = dCity;
	}
	public String getdState() {
		return dState;
	}
	public void setdState(String dState) {
		this.dState = dState;
	}
	public String getdZip() {
		return dZip;
	}
	public void setdZip(String dZip) {
		this.dZip = dZip;
	}
	public String getCreditCardType() {
		return creditCardType;
	}
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getExpDay() {
		return expDay;
	}
	public void setExpDay(int expDay) {
		this.expDay = expDay;
	}
	public int getExpYear() {
		return expYear;
	}
	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}


}
