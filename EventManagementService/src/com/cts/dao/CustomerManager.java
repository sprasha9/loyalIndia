package com.cts.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




import com.cts.entities.Customer;
import com.cts.resources.HibernateUtil;

public class CustomerManager {

	private static SessionFactory factory;
	private static Session session;
	private static boolean status;
	
	public static boolean AddCustomer(Customer customer) {
		factory=HibernateUtil.GetFactory();
		session=factory.openSession();
		session.beginTransaction();
		try {
			session.save(customer);
			session.getTransaction().commit();
			status=true;
		} catch (HibernateException e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		}
		session.close();
		return status;
		
	}
	
	public static List<Customer> getAll() {
		factory=HibernateUtil.GetFactory();
		session=factory.openSession();
		return session.createQuery("from Customer").list();
		
	}
	
}
