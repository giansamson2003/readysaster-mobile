package com.seerlabs.readysaster.dao;

import android.content.Context;

import com.seerlabs.readysaster.model.Incident;

public class IncidentDao extends BaseDao<Incident> {
	
	public IncidentDao(Context context) {
		super(context, Incident.class);
	}
}
