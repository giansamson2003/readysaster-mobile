package com.seerlabs.readysaster.dao;

import android.content.Context;

import com.seerlabs.readysaster.model.Severity;

public class SeverityDao extends BaseDao<Severity>{

	public SeverityDao(Context context) {
		super(context, Severity.class);
	}
}
