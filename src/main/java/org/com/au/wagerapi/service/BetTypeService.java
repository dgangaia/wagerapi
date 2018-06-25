package org.com.au.wagerapi.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.com.au.wagerapi.model.BetCountPerBetTypeModel;
import org.com.au.wagerapi.model.BetCountPerHourModel;
import org.com.au.wagerapi.model.BetInvestmentCustomerModel;
import org.com.au.wagerapi.model.BetInvestmentTypeModel;
import org.com.au.wagerapi.model.BetTypeModel;
import org.com.au.wagerapi.utilites.DBConnection;

public class BetTypeService {

	public static Logger LOG = Logger.getLogger(BetTypeService.class);
	
	List<BetTypeModel> betlist = new ArrayList<BetTypeModel>(); 
	
	public List<BetTypeModel> getBetTypeService(){

		DBConnection conn = new DBConnection();
		LOG.info("BetTypeService : getBetTypeService");
		Connection con = conn.connect();
		BetTypeModel bet = null;
		try{
			String sql= "select * from WAGER_TRAN.BET_TYPES";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();  

			while(rs.next()) { 
				bet = new BetTypeModel();
				bet.setId(rs.getInt("id"));
				bet.setBetName(rs.getString("name").trim());
				bet.setBetDescription(rs.getString("description").trim());
				betlist.add(bet);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null){
				try {
					con.close();
					conn.disconnect();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return betlist;
	}

	public List<BetInvestmentTypeModel> getInvestmentBetTypeAllService() {
		List<BetInvestmentTypeModel> betInvtlist = new ArrayList<BetInvestmentTypeModel>(); 
		DBConnection conn = new DBConnection();
		LOG.info("BetTypeService : getInvestmentBetTypeAllService");
		Connection con = conn.connect();
		BetInvestmentTypeModel betInvest = null;
		try{
			String sql= "SELECT b.id as betid, b.name as betname, SUM(a.investment) as Investment FROM wager_tran.bets AS a "
					+ "LEFT JOIN wager_tran.bet_types AS b ON b.id = a.bet_type_id "
					+ "GROUP BY a.bet_type_id, b.name, betid";
			LOG.info("BetTypeService: getInvestmentBetTypeAllService :sql "+sql);
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();  

			while(rs.next()) { 
				betInvest = new BetInvestmentTypeModel();
				betInvest.setBetId(rs.getInt("betid"));
				betInvest.setBetName((rs.getString("betname").trim()));
				betInvest.setBetInvestment(rs.getInt("Investment"));
				betInvtlist.add(betInvest);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null){
				try {
					con.close();
					conn.disconnect();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return betInvtlist;
	}

	public List<BetInvestmentCustomerModel> getInvestmentByCustomerService() {
		List<BetInvestmentCustomerModel> betInvtlist = new ArrayList<BetInvestmentCustomerModel>(); 
		DBConnection conn = new DBConnection();
		LOG.info("BetTypeService : getInvestmentByCustomerService");
		Connection con = conn.connect();
		BetInvestmentCustomerModel betInvest = null;
		try{
			String sql= "SELECT c.id as customer_id, c.firstname as firstname, c.lastname as lastname, c.email as emailid, SUM(a.investment) as investment "
					+"FROM wager_tran.bets AS a "
					+"LEFT JOIN wager_tran.customers AS c ON c.id = a.customer_id "
					+"GROUP BY a.customer_id, c.email, c.id";
			LOG.info("BetTypeService: getInvestmentByCustomerService :sql "+sql);
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();  

			while(rs.next()) { 
				betInvest = new BetInvestmentCustomerModel();
				betInvest.setCustomerId(rs.getInt("customer_id"));
				betInvest.setFirstName(rs.getString("firstname").trim());
				betInvest.setLastName(rs.getString("lastname").trim());
				betInvest.setEmailId(rs.getString("emailid").trim());
				betInvest.setBetInvestment(rs.getInt("investment"));
				betInvtlist.add(betInvest);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null){
				try {
					con.close();
					conn.disconnect();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return betInvtlist;
	
	}

	public List<BetCountPerBetTypeModel> getCountByBetTypeService() {
		List<BetCountPerBetTypeModel> betInvtlist = new ArrayList<BetCountPerBetTypeModel>(); 
		DBConnection conn = new DBConnection();
		LOG.info("BetTypeService : getCountByBetTypeService");
		Connection con = conn.connect();
		BetCountPerBetTypeModel betInvest = null;
		try{
			String sql= "SELECT b.id as bet_id,b.name as bet_name, COUNT(a.id) as betsold "
					+"FROM wager_tran.bets AS a "
					+"LEFT JOIN wager_tran.bet_types AS b ON b.id = a.bet_type_id "
					+"GROUP BY b.name,b.id order by bet_id";
			LOG.info("BetTypeService: getInvestmentByCustomerService :sql "+sql);
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();  

			while(rs.next()) { 
				betInvest = new BetCountPerBetTypeModel();
				betInvest.setBetId(rs.getInt("bet_id"));
				betInvest.setBetName(rs.getString("bet_name").trim());
				betInvest.setNumberofbetsold(rs.getInt("betsold"));
				betInvtlist.add(betInvest);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null){
				try {
					con.close();
					conn.disconnect();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return betInvtlist;
	}

	public List<BetCountPerHourModel> getBetPerHourService() {
		List<BetCountPerHourModel> betInvtlist = new ArrayList<BetCountPerHourModel>(); 
		DBConnection conn = new DBConnection();
		LOG.info("BetTypeService : getBetPerHourService");
		Connection con = conn.connect();
		BetCountPerHourModel betInvest = null;
		try{
			String sql= "select date_trunc('hour', a.created_at - interval '1 minute') as duration_start,"
					+"date_trunc('hour', a.created_at - interval '1 minute')  + interval '1 hours' as duration_end,"
					+"count(a.id) as count from wager_tran.bets a group by date_trunc('hour', a.created_at - interval '1 minute') "
					+"order by duration_start";
			LOG.info("BetTypeService: getInvestmentByCustomerService :sql "+sql);
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();  

			while(rs.next()) { 
				betInvest = new BetCountPerHourModel();	
				betInvest.setDuration_start(rs.getTimestamp("duration_start"));
				betInvest.setDuration_end(rs.getTimestamp("duration_end"));
				betInvest.setTotalNumberofBet(rs.getInt("count"));
				betInvtlist.add(betInvest);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null){
				try {
					con.close();
					conn.disconnect();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return betInvtlist;
	}
}
