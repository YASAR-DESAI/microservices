package amigoservices.customer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	CustomerService customerService;
	
	public CustomerController() {
		
	}

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}





	@PostMapping
	public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
		
		log.info("new customer registration {}"+customerRequest);
		customerService.register(customerRequest);
		
	}

}
