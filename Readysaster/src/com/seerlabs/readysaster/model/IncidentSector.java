package com.seerlabs.readysaster.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class IncidentSector {

	@DatabaseField(columnName = "server_id", dataType = DataType.INTEGER_OBJ, canBeNull = false)
	private Integer serverId;

	@DatabaseField(columnName = "incident", canBeNull = false, foreign = true, foreignAutoRefresh = true)
	private Incident incident;

	@DatabaseField(columnName = "sector", canBeNull = false, foreign = true, foreignAutoRefresh = true)
	private Sector sector;

	@DatabaseField(columnName = "notes", dataType = DataType.STRING)
	private String notes;

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

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
