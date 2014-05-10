package com.seerlabs.readysaster.dao;

import android.content.Context;

import com.seerlabs.readysaster.model.Organization;

public class OrganizationDao extends BaseDao<Organization> {

	public OrganizationDao(Context context) {
		super(context, Organization.class);
	}
}
