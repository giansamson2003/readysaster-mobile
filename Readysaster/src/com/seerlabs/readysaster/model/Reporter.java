package com.seerlabs.readysaster.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class Reporter {
	
	@DatabaseField(columnName = "id", dataType = DataType.INTEGER_OBJ, generatedId = true)
	private Integer id;
	
	@DatabaseField(columnName = "server_id", dataType = DataType.INTEGER_OBJ)
	private Integer serverId;
	
	@DatabaseField(columnName = "imei", dataType = DataType.STRING, canBeNull = false)
	private String imei;
	
	@DatabaseField(columnName = "name", dataType = DataType.STRING, canBeNull = false)
	private String name;
	
	@DatabaseField(columnName = "organization", canBeNull = false, foreign = true, foreignAutoRefresh = true)
	private Organization organization;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
}
