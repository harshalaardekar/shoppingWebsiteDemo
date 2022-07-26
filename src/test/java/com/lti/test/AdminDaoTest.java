package com.lti.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.AdminDao;
import com.lti.entity.Admin;
import com.lti.entity.Retailer;

public class AdminDaoTest {

	@Autowired
	AdminDao dao;

	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(AdminDao.class);
	}

	@Test
	public void adminLogin() {
		Boolean loginResult = dao.adminLogin("admin", "adm");
		if (loginResult != true) {
			System.out.println("Invalid Credentials");
		} else {
			System.out.println("Login Sucessful");
		}

	}
	
	@Test
	public void viewRetailerDetails() {
		Retailer r=dao.viewRetailerDetails(1006);
		assertNotNull(r);
		System.out.println(r.getRetailerdocs().toString());
	}

	@Test
	public void viewRetailers() {
		List<Retailer> retailers = dao.approvedRetailers();
//		List<Retailer> retailers = dao.nonApprovedRetailers();
		if(retailers.isEmpty())
			System.out.println("No Record Found");
		else
			for(Retailer r:retailers)
				System.out.println(r.toString());
	}
	
	@Test
	public void approveRetailer() {
		Retailer r=dao.searchRetailer(1010);
		if(r!=null) {
			r.setApproved(true);
			System.out.println(dao.approveReailer(r));
		}
		else
			System.out.println("Retailer not present");
	}
	
	@Test
	public void removeTest() {
		dao.removeRetailer(1006);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
