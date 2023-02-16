package amigoservices.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.amigoservices.amqp.RabbitMQMessageProducer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerService {

	CustomerRepository customerRepository;
	@Autowired
	NotificationRequest notificationRequest;
	
	//RabbitMQMessageProducer rabbitMQMessageProducer;
	
	//RestTemplate restTemplate = new RestTemplate();
	@Autowired
	RestTemplate restTemplate;
	
	
	//I had to create another restTemplate object as the post request was not being send using the first object.
	@Autowired
	RestTemplate restTemplate3;
	
	
	public CustomerService(CustomerRepository customerRepository)
	{
		this.customerRepository = customerRepository;
	}

	public void register(CustomerRegistrationRequest request) {
		// TODO Auto-generated method stub
		Customer customer = new Customer ();
		
		customer.setFirstName(request.getFirstName());
		customer.setEmail(request.getEmail());
		customer.setLastName(request.getLastName());
		
		//todo: check if email is valid
		//check if email is taken	
		customerRepository.saveAndFlush(customer);
		//check if fraudster
		FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
		
		if (fraudCheckResponse.getIsFraudster()) {
			throw new IllegalStateException("fraudster");	
		}
		
		notificationRequest.setCustomerEmail(customer.getEmail());
		notificationRequest.setCustomerId(customer.getId());
		notificationRequest.setMessage(String.format("hello my man, %s", customer.getFirstName()));
		
		restTemplate3.postForObject("http://NOTIFICATION/api/v1/notifications", notificationRequest, NotificationRequest.class);	
		
	//	rabbitMQMessageProducer.publish(notificationRequest,"internal.exchange","internal.notification.routing-key");
	
	
	}


}
