package com.seerlabs.readysaster.dao;

import android.content.Context;

import com.seerlabs.readysaster.model.IncidentSector;

public class IncidentSectorDao extends BaseDao<IncidentSector> {

	public IncidentSectorDao(Context context) {
		super(context, IncidentSector.class);
	}
}
