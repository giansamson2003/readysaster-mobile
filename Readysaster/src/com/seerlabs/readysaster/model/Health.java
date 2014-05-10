package com.seerlabs.readysaster.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class Health {

	@DatabaseField(columnName = "incident", canBeNull = false, foreign = true, foreignAutoRefresh = true)
	private Incident incident;
	
	@DatabaseField(columnName = "injuryCount", dataType = DataType.INTEGER_OBJ, canBeNull = false)
	private Integer injuryCount;
	
	@DatabaseField(columnName = "severity", canBeNull = false, foreign = true, foreignAutoRefresh = true)
	private Severity severity;

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public Integer getInjuryCount() {
		return injuryCount;
	}

	public void setInjuryCount(Integer injuryCount) {
		this.injuryCount = injuryCount;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	
}
