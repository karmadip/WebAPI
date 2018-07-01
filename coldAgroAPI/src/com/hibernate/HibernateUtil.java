package com.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static Session session = null;
	private static SessionFactory sessionFactory = null;

    private static void _buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//       	   return new Configuration().configure().buildSessionFactory();
        	//return new AnnotationConfiguration().configure().buildSessionFactory();
        	sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
        	//System.out.println("Session fact is null");
        	_buildSessionFactory();
        }
        //System.out.println(sessionFactory);
        
    	return sessionFactory;
    }
    
    public static Session getSession() {
    	 try {
    		 return getSessionFactory().getCurrentSession();
    		 
    	 }catch(Exception e){
    		 //System.out.println("In exception");
    		 return getSessionFactory().openSession();
    	 }
	
    }
    
    
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}