package com.taxation.bureau.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Tbase {
	
	private String id;
	
	@Id
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
