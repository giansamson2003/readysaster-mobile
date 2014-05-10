package com.seerlabs.readysaster.dao;

import android.content.Context;

import com.seerlabs.readysaster.model.Media;

public class MediaDao extends BaseDao<Media> {

	public MediaDao(Context context) {
		super(context, Media.class);
	}

}
