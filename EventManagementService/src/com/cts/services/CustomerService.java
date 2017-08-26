package com.cts.services;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.cts.dao.CustomerManager;
import com.cts.entities.Customer;
import com.cts.entities.Message;

@Path("/CustomerService")
public class CustomerService {
	@POST
	@Path("/AddCustomer")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	
	
	public Response AddCustomerService(Customer customer) {
		
		boolean status=CustomerManager.AddCustomer(customer);
		Message message=new Message();
		message.setStatus("Not Added");
		if(status)
		{
			message.setStatus("Added");
		}
return Response.status(200).header("Acess-control-Allow-Orgin", "*")
		.header("Access-Control-Allow-Headers","orgin,content-type,accept,authorization")
		.header("Access-Control-Allow-Credentials", true)
		.header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD")
		.header("Access-Control-Max-Age","1209600" )
		.entity(message).build();
	}
	@Path("/GetCustomers")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getCustomer()
	{
		GenericEntity<List<Customer>> genentity=new GenericEntity<List<Customer>>(CustomerManager.getAll()){};
		return Response.status(200).header("Acess-control-Allow-Orgin", "*")
				.header("Access-Control-Allow-Headers","orgin,content-type,accept,authorization")
				.header("Access-Control-Allow-Credentials", true)
				.header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD")
				.header("Access-Control-Max-Age","1209600" )
				.entity(genentity).build();
				
		
				
	}
}
