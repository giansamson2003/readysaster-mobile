package com.seerlabs.readysaster.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class Incident {

	@DatabaseField(columnName = "id", dataType = DataType.INTEGER_OBJ, generatedId = true)
	private Integer id;

	@DatabaseField(columnName = "server_id", dataType = DataType.INTEGER_OBJ)
	private Integer serverId;

	@DatabaseField(columnName = "latitude", dataType = DataType.FLOAT_OBJ, canBeNull = false)
	private Float latitude;

	@DatabaseField(columnName = "longitude", dataType = DataType.FLOAT_OBJ, canBeNull = false)
	private Float longitude;

	@DatabaseField(columnName = "timestamp", dataType = DataType.STRING, canBeNull = false)
	private String timestamp;

	@DatabaseField(columnName = "reporter", canBeNull = false, foreign = true, foreignAutoRefresh = true)
	private Reporter reporter;

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Reporter getReporter() {
		return reporter;
	}

	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}

}
