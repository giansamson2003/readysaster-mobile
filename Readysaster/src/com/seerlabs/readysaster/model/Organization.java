package com.seerlabs.readysaster.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class Organization {
	
	@DatabaseField(columnName = "server_id", dataType = DataType.INTEGER_OBJ, canBeNull = false)
	private Integer serverId;
	
	@DatabaseField(columnName = "name", dataType = DataType.STRING, canBeNull = false)
	private String name;
	
	public Integer getServerId() {
		return serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
