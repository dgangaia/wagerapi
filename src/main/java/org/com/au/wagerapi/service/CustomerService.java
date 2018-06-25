package org.com.au.wagerapi.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.com.au.wagerapi.model.CustomerModel;
import org.com.au.wagerapi.utilites.DBConnection;


public class CustomerService {
	public static Logger LOG = Logger.getLogger(CustomerService.class);
	
	List<CustomerModel> cust_list = new ArrayList<CustomerModel>(); 
	
	public List<CustomerModel> getCustomerService(){

		DBConnection conn = new DBConnection();
		LOG.info("CustomerService : getCustomerService");
		Connection con = conn.connect();
		CustomerModel cust = null;
		try{
			String sql= "select * from WAGER_TRAN.CUSTOMER";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();  

			while(rs.next()) { 
				cust = new CustomerModel();
				cust.setFirstName(rs.getString("firstname").trim());
				cust.setLastName(rs.getString("lastname").trim());
				cust.setEmailId(rs.getString("email_id").trim());
				cust.setAddressId(rs.getString("address_id").trim());
				cust.setActiveCustomer(rs.getBoolean("active_account"));
				cust.setUserCreationDate(rs.getDate("created_date"));
				cust.setLastRecordUpdateDate(rs.getDate("record_upadted_date"));
				cust_list.add(cust);
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
		return cust_list;
	}	
	
}
