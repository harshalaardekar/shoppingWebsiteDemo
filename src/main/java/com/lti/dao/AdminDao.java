package com.lti.dao;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Retailer;
import com.lti.entity.RetailerDocs;

public interface AdminDao {

	boolean adminLogin(String username, String password);
	
	Retailer serachRetailer(int retailerId);
	Retailer viewRetailerDetails(int retailerId);
	
	List<Retailer> approvedRetailers();
	List<Retailer> nonApprovedRetailers();
	Retailer approveReailer(Retailer retailer);
	Retailer searchRetailer(int retailerId);
	void removeRetailer(int retailerId);
}
