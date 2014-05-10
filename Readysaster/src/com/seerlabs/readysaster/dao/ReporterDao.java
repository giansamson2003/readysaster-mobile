package com.seerlabs.readysaster.dao;

import android.content.Context;

import com.seerlabs.readysaster.model.Reporter;

public class ReporterDao extends BaseDao<Reporter>{
	
	public ReporterDao(Context context) {
		super(context, Reporter.class);
	}

}
