package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                           //need to create column for java class User
@Table(name="users")              //if you dont like User name put @Table(change the name of User to users)
public class User {
	@Id                           //primary key
	private int id;
	
	private String name;
	
	
	public String toString()
	{
		return name+" : "+ id;
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

}
