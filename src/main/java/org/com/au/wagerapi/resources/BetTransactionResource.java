package org.com.au.wagerapi.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	public BetTransactionCreateModel setbetTypeResource(BetTransactionCreateModel bean){
		LOG.info("BetTransactionResource : setbetTypeResource"+bean.getBetType());
		return bean;
	}


}
