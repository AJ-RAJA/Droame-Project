package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DroneShot {
@Id
private int id;
private String name;
public DroneShot() {
	super();
	// TODO Auto-generated constructor stub
}
public DroneShot(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "DroneShot [id=" + id + ", name=" + name + "]";
}
}
