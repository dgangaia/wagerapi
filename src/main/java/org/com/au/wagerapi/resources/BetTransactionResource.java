package org.com.au.wagerapi.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.com.au.wagerapi.model.BetTransactionCreateModel;
import org.com.au.wagerapi.service.BetTransactionService;

@Path("/transaction")
public class BetTransactionResource {

	public static Logger LOG = Logger.getLogger(BetTransactionResource.class);

	BetTransactionService serv = new BetTransactionService();
	public BetTransactionResource() {
		BasicConfigurator.configure();
	}

	@POST
	@Path("/createbet")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setbetTypeResource(@QueryParam("bettype") String betType){
		LOG.info("BetTransactionResource : setbetTypeResource"+betType);
		return betType;	
	}


}