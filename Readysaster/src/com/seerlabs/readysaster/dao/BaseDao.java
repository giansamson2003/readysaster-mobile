package com.seerlabs.readysaster.dao;

import java.util.Collections;
import java.util.Map;

import android.content.Context;

public class BaseDao<T> {

	protected DataManager dbMgr;
	private Class<T> className;
	
	public BaseDao( Context context, Class<T> className ) {
		dbMgr = DataManager.getInstance(context);
		this.className = className;
	}
	
	@SuppressWarnings("unchecked")
	public T persistRecord(T record) {
		return dbMgr.persistRecord(this.className, record);
	}
	
	public T getRecord(Map<String, Object> fieldAttributes) {
		return dbMgr.getRecord(this.className, fieldAttributes, false);
//		return dbMgr.getMatchingRecord(this.className, fieldAttributes);
	}
	
	public T getRecord(Integer id) {
		return dbMgr.getRecord(this.className, Collections.singletonMap("id", (Object)id), false);
	}
	
	public void deleteRecord( Integer id ) {
		dbMgr.deleteRecord(this.className, id);
	}
	
	public void deleteRecords() {
		dbMgr.deleteAll(this.className);
	}
	
	public void clearDatabase() {
		dbMgr.clearAllRecords();
	}
	
}
