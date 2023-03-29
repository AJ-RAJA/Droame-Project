package com.list;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Location;
import com.helper.FactoryProvider;

public class SetDataLocation {
	public static void main(String[] args) {
		try {
			Session s = FactoryProvider.getFactory().openSession();
			Location l1 = (Location)new Location(1,"Bengaluru"); 
			Location l2 = (Location)new Location(2,"Jaipur"); 
			Location l3 = (Location)new Location(3,"Darjiling"); 
			Transaction tx = s.beginTransaction();
			s.save(l1);
			s.save(l2);
			s.save(l3);
			
			tx.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
