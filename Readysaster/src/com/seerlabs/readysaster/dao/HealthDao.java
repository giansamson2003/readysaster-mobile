package com.seerlabs.readysaster.dao;

import android.content.Context;

import com.seerlabs.readysaster.model.Health;

public class HealthDao extends BaseDao<Health> {

	public HealthDao(Context context) {
		super(context, Health.class);
	}
}
