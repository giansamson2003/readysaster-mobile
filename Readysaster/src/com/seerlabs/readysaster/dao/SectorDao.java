package com.seerlabs.readysaster.dao;

import android.content.Context;

import com.seerlabs.readysaster.model.Sector;

public class SectorDao extends BaseDao<Sector>{

	public SectorDao(Context context) {
		super(context, Sector.class);
	}
}
