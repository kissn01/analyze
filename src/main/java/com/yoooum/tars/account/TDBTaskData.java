// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.account;

import com.qq.tars.protocol.util.*;
import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.*;
import com.qq.tars.protocol.tars.annotation.*;

@TarsStruct
public class TDBTaskData {

	@TarsStructProperty(order = 0, isRequire = true)
	public TDBDailyTaskData stdailytaskdata = null;
	@TarsStructProperty(order = 1, isRequire = true)
	public TDBMainTaskData stmaintaskdata = null;
	@TarsStructProperty(order = 2, isRequire = true)
	public TDBTimeLimitTaskData sttimelimittaskdata = null;
	@TarsStructProperty(order = 3, isRequire = true)
	public TDBGrowTaskData stgrowtaskdata = null;
	@TarsStructProperty(order = 4, isRequire = false)
	public TDBGuideTaskData stguidetaskdata = null;
	@TarsStructProperty(order = 5, isRequire = false)
	public TDBShoppingTaskData stshoppingtaskdata = null;

	public TDBDailyTaskData getStdailytaskdata() {
		return stdailytaskdata;
	}

	public void setStdailytaskdata(TDBDailyTaskData stdailytaskdata) {
		this.stdailytaskdata = stdailytaskdata;
	}

	public TDBMainTaskData getStmaintaskdata() {
		return stmaintaskdata;
	}

	public void setStmaintaskdata(TDBMainTaskData stmaintaskdata) {
		this.stmaintaskdata = stmaintaskdata;
	}

	public TDBTimeLimitTaskData getSttimelimittaskdata() {
		return sttimelimittaskdata;
	}

	public void setSttimelimittaskdata(TDBTimeLimitTaskData sttimelimittaskdata) {
		this.sttimelimittaskdata = sttimelimittaskdata;
	}

	public TDBGrowTaskData getStgrowtaskdata() {
		return stgrowtaskdata;
	}

	public void setStgrowtaskdata(TDBGrowTaskData stgrowtaskdata) {
		this.stgrowtaskdata = stgrowtaskdata;
	}

	public TDBGuideTaskData getStguidetaskdata() {
		return stguidetaskdata;
	}

	public void setStguidetaskdata(TDBGuideTaskData stguidetaskdata) {
		this.stguidetaskdata = stguidetaskdata;
	}

	public TDBShoppingTaskData getStshoppingtaskdata() {
		return stshoppingtaskdata;
	}

	public void setStshoppingtaskdata(TDBShoppingTaskData stshoppingtaskdata) {
		this.stshoppingtaskdata = stshoppingtaskdata;
	}

	public TDBTaskData() {
	}

	public TDBTaskData(TDBDailyTaskData stdailytaskdata, TDBMainTaskData stmaintaskdata, TDBTimeLimitTaskData sttimelimittaskdata, TDBGrowTaskData stgrowtaskdata, TDBGuideTaskData stguidetaskdata, TDBShoppingTaskData stshoppingtaskdata) {
		this.stdailytaskdata = stdailytaskdata;
		this.stmaintaskdata = stmaintaskdata;
		this.sttimelimittaskdata = sttimelimittaskdata;
		this.stgrowtaskdata = stgrowtaskdata;
		this.stguidetaskdata = stguidetaskdata;
		this.stshoppingtaskdata = stshoppingtaskdata;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(stdailytaskdata);
		result = prime * result + TarsUtil.hashCode(stmaintaskdata);
		result = prime * result + TarsUtil.hashCode(sttimelimittaskdata);
		result = prime * result + TarsUtil.hashCode(stgrowtaskdata);
		result = prime * result + TarsUtil.hashCode(stguidetaskdata);
		result = prime * result + TarsUtil.hashCode(stshoppingtaskdata);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TDBTaskData)) {
			return false;
		}
		TDBTaskData other = (TDBTaskData) obj;
		return (
			TarsUtil.equals(stdailytaskdata, other.stdailytaskdata) &&
			TarsUtil.equals(stmaintaskdata, other.stmaintaskdata) &&
			TarsUtil.equals(sttimelimittaskdata, other.sttimelimittaskdata) &&
			TarsUtil.equals(stgrowtaskdata, other.stgrowtaskdata) &&
			TarsUtil.equals(stguidetaskdata, other.stguidetaskdata) &&
			TarsUtil.equals(stshoppingtaskdata, other.stshoppingtaskdata) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(stdailytaskdata, 0);
		_os.write(stmaintaskdata, 1);
		_os.write(sttimelimittaskdata, 2);
		_os.write(stgrowtaskdata, 3);
		if (null != stguidetaskdata) {
			_os.write(stguidetaskdata, 4);
		}
		if (null != stshoppingtaskdata) {
			_os.write(stshoppingtaskdata, 5);
		}
	}

	static TDBDailyTaskData cache_stdailytaskdata;
	static { 
		cache_stdailytaskdata = new TDBDailyTaskData();
	}
	static TDBMainTaskData cache_stmaintaskdata;
	static { 
		cache_stmaintaskdata = new TDBMainTaskData();
	}
	static TDBTimeLimitTaskData cache_sttimelimittaskdata;
	static { 
		cache_sttimelimittaskdata = new TDBTimeLimitTaskData();
	}
	static TDBGrowTaskData cache_stgrowtaskdata;
	static { 
		cache_stgrowtaskdata = new TDBGrowTaskData();
	}
	static TDBGuideTaskData cache_stguidetaskdata;
	static { 
		cache_stguidetaskdata = new TDBGuideTaskData();
	}
	static TDBShoppingTaskData cache_stshoppingtaskdata;
	static { 
		cache_stshoppingtaskdata = new TDBShoppingTaskData();
	}

	public void readFrom(TarsInputStream _is) {
		this.stdailytaskdata = (TDBDailyTaskData) _is.read(cache_stdailytaskdata, 0, true);
		this.stmaintaskdata = (TDBMainTaskData) _is.read(cache_stmaintaskdata, 1, true);
		this.sttimelimittaskdata = (TDBTimeLimitTaskData) _is.read(cache_sttimelimittaskdata, 2, true);
		this.stgrowtaskdata = (TDBGrowTaskData) _is.read(cache_stgrowtaskdata, 3, true);
		this.stguidetaskdata = (TDBGuideTaskData) _is.read(cache_stguidetaskdata, 4, false);
		this.stshoppingtaskdata = (TDBShoppingTaskData) _is.read(cache_stshoppingtaskdata, 5, false);
	}

}