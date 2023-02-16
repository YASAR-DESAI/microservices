package amigoservices.customer;

import org.springframework.stereotype.Component;

@Component
public class NotificationRequest {
	
	Integer customerId;
	String customerEmail;
	String message;
	
	public NotificationRequest() {
		
	}
	
	public NotificationRequest(Integer customerId, String customerEmail, String message) {
		super();
		this.customerId = customerId;
		this.customerEmail = customerEmail;
		this.message = message;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
