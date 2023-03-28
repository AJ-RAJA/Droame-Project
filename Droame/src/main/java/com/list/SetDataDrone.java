package com.list;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.DroneShot;
import com.helper.FactoryProvider;

public class SetDataDrone {
	public static void main(String[] args) {
		try {
			Session s = FactoryProvider.getFactory().openSession();

			DroneShot drone1 = (DroneShot) new DroneShot(1, "Spinning elevation shot");
			DroneShot drone2 = (DroneShot) new DroneShot(2, "Half moon bay shot");
			DroneShot drone3 = (DroneShot) new DroneShot(3, "Object shot");
			DroneShot drone4 = (DroneShot) new DroneShot(4, "180-degree shot");
			DroneShot drone5 = (DroneShot) new DroneShot(5, "Obstacle shot to reveal the subject");
			DroneShot drone6 = (DroneShot) new DroneShot(6, "Object shot with large reveal down");
			DroneShot drone7 = (DroneShot) new DroneShot(7, "Slow reveal out of the subject");
			DroneShot drone8 = (DroneShot) new DroneShot(8, "High angle shot");
			DroneShot drone9 = (DroneShot) new DroneShot(9, "Arc shot");

			Transaction tx = s.beginTransaction();
			s.save(drone1);
			s.save(drone2);
			s.save(drone3);
			s.save(drone4);
			s.save(drone5);
			s.save(drone6);
			s.save(drone7);
			s.save(drone8);
			s.save(drone9);
			tx.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
