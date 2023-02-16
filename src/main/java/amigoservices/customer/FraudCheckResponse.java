package amigoservices.customer;

public class FraudCheckResponse {
	
	private Boolean isFraudster;
	
	public FraudCheckResponse() {
		
	}

	public FraudCheckResponse(Boolean isFraudster) {
		super();
		this.isFraudster = isFraudster;
	}

	public Boolean getIsFraudster() {
		return isFraudster;
	}

	public void setIsFraudster(Boolean isFraudster) {
		this.isFraudster = isFraudster;
	}
	
	
	
	

}
