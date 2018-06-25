package org.com.au.wagerapi.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.com.au.wagerapi.model.BetCountPerBetTypeModel;
import org.com.au.wagerapi.model.BetCountPerHourModel;
import org.com.au.wagerapi.model.BetInvestmentCustomerModel;
import org.com.au.wagerapi.model.BetInvestmentTypeModel;
import org.com.au.wagerapi.model.BetTypeModel;
import org.com.au.wagerapi.model.CustomerModel;
import org.com.au.wagerapi.service.BetTypeService;
import org.com.au.wagerapi.service.CustomerService;

@Path("/bet")
public class BetResource {
	public static Logger LOG = Logger.getLogger(BetResource.class);
	
	BetTypeService serv = new BetTypeService();
	public BetResource() {
		BasicConfigurator.configure();
	}
	
	@GET
	@Path("/types")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BetTypeModel> getbetTypeResource(){
		LOG.info("BetResource : getbetTypeResource");
		return serv.getBetTypeService();	
	}
	
	@GET
	@Path("/investment/bettypes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BetInvestmentTypeModel> getInvestmentBetTypeAllResource(){
		LOG.info("BetResource : getInvestmentBetTypeAllResource");
		return serv.getInvestmentBetTypeAllService();	
	}
	
	@GET
	@Path("/investment/customer")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BetInvestmentCustomerModel> getInvestmentByCustomerResource(){
		LOG.info("BetResource : getInvestmentByCustomerResource");
		return serv.getInvestmentByCustomerService();	
	}
	
	
	@GET
	@Path("/countbettype")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BetCountPerBetTypeModel> getCountByBetTypeResource(){
		LOG.info("BetResource : getCountByBetTypeResource");
		return serv.getCountByBetTypeService();	
	}
	
	@GET
	@Path("/countbetperhour")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BetCountPerHourModel> getBetPerHourResource(){
		LOG.info("BetResource : getBetPerHourResource");
		return serv.getBetPerHourService();	
	}
		
	
}
