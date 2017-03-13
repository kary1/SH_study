package com.hw.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HBUtils {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static{
		Configuration cfg = new Configuration().configure();
		
		StandardServiceRegistryBuilder ssrb = 
				new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties());
		
		ServiceRegistry service = ssrb.build();
		
		sessionFactory = cfg.buildSessionFactory(service);
	}

	
	public static Session getSession(){
		
		if(session==null || !session.isOpen() ){
			session = sessionFactory.openSession();
		}
		
		return session;
	}
}
