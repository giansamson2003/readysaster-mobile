package com.seerlabs.readysaster.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class Media {

	@DatabaseField(columnName = "id", dataType = DataType.INTEGER_OBJ, generatedId = true)
	private Integer id;
	
	@DatabaseField(columnName = "server_id", dataType = DataType.INTEGER_OBJ)
	private Integer serverId;
	
	@DatabaseField(columnName = "incident", canBeNull = false, foreign = true, foreignAutoRefresh = true)
	private Incident incident;
	
	@DatabaseField(columnName = "type", dataType = DataType.STRING, canBeNull = false)
	private String type;
	
	@DatabaseField(columnName = "url", dataType = DataType.STRING, canBeNull = false)
	private String url;

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

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
