package com.seerlabs.readysaster.model;


import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class Severity {

	@DatabaseField(columnName = "code", dataType = DataType.STRING, canBeNull = false)
	private String code;
	
	@DatabaseField(columnName = "label", dataType = DataType.STRING, canBeNull = false)
	private String label;
	
	@DatabaseField(columnName = "description", dataType = DataType.STRING)
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
