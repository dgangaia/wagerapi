package org.com.au.wagerapi.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.com.au.wagerapi.exceptions.DataNotFoundException;
import org.com.au.wagerapi.model.CustomerModel;
import org.com.au.wagerapi.service.CustomerService;


@Path("/customer")
public class CustomerResource {
	
	public static Logger LOG = Logger.getLogger(CustomerResource.class);
	
	CustomerService serv = new CustomerService();
	public CustomerResource() {
		BasicConfigurator.configure();
	}
	
	@GET
	@Path("/details")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CustomerModel> getCustomerResource(){
		LOG.info("Customer Resource : Resources");
		return serv.getCustomerService();	
	}
	
	@GET
	@Path("{ID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CustomerModel> getCustomerResource(@PathParam("ID") Integer customer_id){
		LOG.info("Customer getCustomerResource : Resources"+customer_id);
		if(customer_id == 2){
			throw new DataNotFoundException("Customer ID not Found :"+ customer_id);
		}
		return serv.getCustomerService();	
	}
	
}
