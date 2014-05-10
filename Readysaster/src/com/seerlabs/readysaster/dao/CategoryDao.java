package com.seerlabs.readysaster.dao;

import android.content.Context;

import com.seerlabs.readysaster.model.Category;

public class CategoryDao extends BaseDao<Category> {

	public CategoryDao(Context context) {
		super(context, Category.class);
	}
}
