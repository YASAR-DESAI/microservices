package amigoservices.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Customer {
	
	private String firstName;
	private String lastName;
	private String email;
	@Id
	@SequenceGenerator(name="customer_id_sequence",sequenceName="customer_id_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_id_sequence")
	private Integer id;
	
	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName, String email, Integer id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
