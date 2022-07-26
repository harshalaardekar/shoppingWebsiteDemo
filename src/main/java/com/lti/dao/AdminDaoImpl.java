package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.Retailer;
import com.lti.entity.RetailerDocs;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	EntityManager em;

//	@Transactional
//	public Admin addOrUpdateAdmin(Admin admin) {
//		Admin userPersisted = em.merge(admin);
//		return userPersisted;
//	}

	public boolean adminLogin(String username, String password) {

		String jpql = "select u from Admin u where u.username=:uid and u.password=:pwd";
		TypedQuery<Admin> query = em.createQuery(jpql, Admin.class);
		query.setParameter("uid", username);
		query.setParameter("pwd", password);

		Admin admin = null;
		try {
			admin = query.getSingleResult();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Retailer serachRetailer(int retailerId) {
		return em.find(Retailer.class,retailerId);
	}

	public List<Retailer> approvedRetailers() {
		String jpql="select a from Retailer a where a.isApproved=:val";
		TypedQuery<Retailer> query=em.createQuery(jpql, Retailer.class);
		query.setParameter("val", true);
		List<Retailer> rdata = query.getResultList();
		return rdata;
	}

	public List<Retailer> nonApprovedRetailers() {
		String jpql="select a from Retailer a where a.isApproved=:val";
		TypedQuery<Retailer> query=em.createQuery(jpql, Retailer.class);
		query.setParameter("val", false);
		List<Retailer> rdata = query.getResultList();
		return rdata;
	}

	public Retailer viewRetailerDetails(int retailerId) {
		return em.find(Retailer.class, retailerId);
	}
	
	@Transactional
	public Retailer approveReailer(Retailer retailer) {
		return em.merge(retailer);
//		String jpql="update Retailer a set a.isApproved=:val where retailerId=:rid";
//		TypedQuery<Retailer> query = em.createQuery(jpql,Retailer.class);
//		query.setParameter("val", true);
//		query.setParameter("rid", retailerId);
//		
//		int result = query.executeUpdate();
//		return result;
	}

	public Retailer searchRetailer(int retailerId) {
		return em.find(Retailer.class, retailerId);
	}

	@Transactional
	public void removeRetailer(int retailerId) {
		Retailer retailer = em.find(Retailer.class,retailerId);
		em.remove(retailer);
	}
	
}
