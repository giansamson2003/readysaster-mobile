package com.seerlabs.readysaster.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.seerlabs.readysaster.model.Category;
import com.seerlabs.readysaster.model.Health;
import com.seerlabs.readysaster.model.Incident;
import com.seerlabs.readysaster.model.IncidentSector;
import com.seerlabs.readysaster.model.Media;
import com.seerlabs.readysaster.model.Organization;
import com.seerlabs.readysaster.model.Reporter;
import com.seerlabs.readysaster.model.Sector;
import com.seerlabs.readysaster.model.Severity;

public class DataManager extends OrmLiteSqliteOpenHelper {

	private static final String TAG = "DataManager";

	private static final String DATABASE_NAME = "cliqueclicks.db";
	private static final int DATABASE_VERSION = 1;

	private static DataManager instance = null;

	public synchronized static DataManager getInstance(Context context) {
		if (instance == null)
			instance = new DataManager(context);
		return instance;
	}

	private DataManager(Context aContext) {
		super(aContext, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, Category.class);
			TableUtils.createTable(connectionSource, Health.class);
			TableUtils.createTable(connectionSource, Incident.class);
			TableUtils.createTable(connectionSource, IncidentSector.class);
			TableUtils.createTable(connectionSource, Media.class);
			TableUtils.createTable(connectionSource, Organization.class);
			TableUtils.createTable(connectionSource, Reporter.class);
			TableUtils.createTable(connectionSource, Sector.class);
			TableUtils.createTable(connectionSource, Severity.class);
		} catch (SQLException e) {
			Log.e(DataManager.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int oldVersion, int newVersion) {

		//nothing to see here; initial version
	}

	public <T> T getRecord(Class<T> clazz, Map<String, Object> fieldAttributes,
			boolean createIfNotFound) {
		List<T> records = this.getMatchingRecords(clazz, fieldAttributes);
		if (records == null || records.size() == 0) {
			if (createIfNotFound) {
				return this.createRecord(clazz);
			} else {
				return null;
			}
		}
		return records.get(0);
	}

	public <D extends Dao<T, I>, T, I> void deleteRecord(Class<T> clazz, I id) {
		Dao<T, ?> dao;

		try {
			dao = this.getDao(clazz);
			@SuppressWarnings("unchecked")
			D castDao = (D) dao;
			castDao.deleteById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public <D extends Dao<T, I>, T, I> void deleteAll(Class<T> clazz) {
		Dao<T, ?> dao;

		try {
			dao = this.getDao(clazz);
			@SuppressWarnings("unchecked")
			D castDao = (D) dao;
			DeleteBuilder<T, I> deleteBuilder = castDao.deleteBuilder();
			deleteBuilder.delete();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public <D extends Dao<T, ?>, T> T getMatchingRecord(Class<T> clazz, Map<String, Object> fieldAttributes) {
		Dao<T, ?> dao;
		try {
			dao = this.getDao(clazz);
			@SuppressWarnings("unchecked")
			D castDao = (D) dao;
			List<T> results = castDao.queryForFieldValues(fieldAttributes);
			castDao.closeLastIterator();
			return results.get(0); //get only the first result
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public <D extends Dao<T, ?>, T> List<T> getMatchingRecords(Class<T> clazz,
			Map<String, Object> fieldAttributes) {
		Dao<T, ?> dao;
		try {
			dao = this.getDao(clazz);
			@SuppressWarnings("unchecked")
			D castDao = (D) dao;
			List<T> results = castDao.queryForFieldValues(fieldAttributes);
			castDao.closeLastIterator();
			// castDao.
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public <D extends Dao<T, ?>, T> QueryBuilder<T, ?> getQueryBuilder(
			Class<T> clazz) {
		Dao<T, ?> dao;
		try {
			dao = this.getDao(clazz);
			@SuppressWarnings("unchecked")
			D castDao = (D) dao;
			return castDao.queryBuilder();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> List<T> getMatchingRecords(QueryBuilder<T, ?> qb) {
		try {
			qb.query();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public <D extends Dao<T, ?>, T> T persistRecord(Class<T> class1, T record) {

		Log.i(TAG, "persistRecord " + class1.getName());
		Dao<T, ?> dao;

		try {
			dao = this.getDao(class1);

			@SuppressWarnings("unchecked")
			D castDao = (D) dao;
			castDao.createOrUpdate(record);
			castDao.refresh(record);
			return record;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public <T> T createRecord(Class<T> clazz) {
		T newRecord = null;
		try {
			newRecord = clazz.getConstructor().newInstance();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return newRecord;
	}
	
	public void clearAllRecords() {
		try {
			TableUtils.clearTable(connectionSource, Category.class);
			TableUtils.clearTable(connectionSource, Health.class);
			TableUtils.clearTable(connectionSource, Incident.class);
			TableUtils.clearTable(connectionSource, IncidentSector.class);
			TableUtils.clearTable(connectionSource, Media.class);
			TableUtils.clearTable(connectionSource, Organization.class);
			TableUtils.clearTable(connectionSource, Reporter.class);
			TableUtils.clearTable(connectionSource, Sector.class);
			TableUtils.clearTable(connectionSource, Severity.class);
		} catch (SQLException e) {
			Log.e(DataManager.class.getName(), "Can't clear database", e);
			throw new RuntimeException(e);
		}
	}
	
}