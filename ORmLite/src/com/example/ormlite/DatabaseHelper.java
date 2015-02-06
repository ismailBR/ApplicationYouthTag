package com.example.ormlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	
	private Context context;
	// name of the database file for your application — change to something
	// appropriate for your app
	private static final String DATABASE_NAME = "scotchadmins";
	// any time you make changes to your database, you may have to increase the
	// database version
	private static final int DATABASE_VERSION = 1;
	// the DAO object we use to access the any table
	private Dao<DemoORMLite, Integer> DemoORMLiteDao = null;
	private RuntimeExceptionDao<DemoORMLite, Integer> DemoORMLiteRuntimeDao = null;

	 public DatabaseHelper(Context context) {
		  super(context, DATABASE_NAME, null, DATABASE_VERSION);
		  context = context;
		 }

	/**
	 * This is called when the database is first created. Usually you should
	 * call createTable statements here to create the tables that will store
	 * your data.
	 */
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, DemoORMLite.class);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can’t create database", e);
			throw new RuntimeException(e);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This is called when the application is upgraded and it has a higher
	 * version number. This allows you to adjust the various data to match the
	 * new version number.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int oldVersion, int newVersion) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");
			TableUtils.dropTable(connectionSource, DemoORMLite.class, true);
			// after we drop the old databases, we create the new ones
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can’t drop databases", e);
			throw new RuntimeException(e);
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
	}

	
	public RuntimeExceptionDao<DemoORMLite, Integer> getSimpleDataDao() {
		  if (DemoORMLiteRuntimeDao == null) {
			  DemoORMLiteRuntimeDao = getRuntimeExceptionDao(DemoORMLite.class);
		  }
		  return DemoORMLiteRuntimeDao;
		 }
	
	// method for insert data
	public int addData(DemoORMLite dol) {
		RuntimeExceptionDao<DemoORMLite, Integer> dao = getSimpleDataDao();
		int i = dao.create(dol);
		return i;
	}

	/**
	 * Close the database connections and clear any cached DAOs.
	 */
	@Override
	public void close() {
		super.close();
		DemoORMLiteRuntimeDao = null;
	}

}
