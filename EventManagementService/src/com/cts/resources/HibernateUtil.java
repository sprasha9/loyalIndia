package com.cts.resources;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	public static SessionFactory GetFactory()
	{	
		return new Configuration().configure("com/cts/resources/hibernate.cfg.xml").buildSessionFactory();
	}
	
}
