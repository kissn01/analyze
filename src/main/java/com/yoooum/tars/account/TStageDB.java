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
public class TStageDB {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iID = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public long lBeginTM = 0L;
	@TarsStructProperty(order = 2, isRequire = false)
	public int iBattelTimes = 0;
	@TarsStructProperty(order = 3, isRequire = false)
	public int eGameResult = 0;
	@TarsStructProperty(order = 4, isRequire = false)
	public int iReviveCount = 0;
	@TarsStructProperty(order = 5, isRequire = false)
	public double dScore = 0D;
	@TarsStructProperty(order = 6, isRequire = false)
	public int iEventID = 0;
	@TarsStructProperty(order = 7, isRequire = false)
	public int iChooseOption = 0;
	@TarsStructProperty(order = 8, isRequire = false)
	public int iEventState = 0;
	@TarsStructProperty(order = 9, isRequire = false)
	public int iEventType = 0;
	@TarsStructProperty(order = 10, isRequire = false)
	public java.util.Map<java.lang.Integer, java.util.List<com.yoooum.tars.commdata.TItemParam>> mDropList = null;
	@TarsStructProperty(order = 11, isRequire = false)
	public int iDropCheckTime = 0;
	@TarsStructProperty(order = 12, isRequire = false)
	public java.util.List<java.lang.Integer> vecLearnSkill = null;
	@TarsStructProperty(order = 13, isRequire = false)
	public java.util.List<java.lang.Integer> vecBuff = null;
	@TarsStructProperty(order = 14, isRequire = false)
	public java.util.List<TProperty> vecProperties = null;
	@TarsStructProperty(order = 15, isRequire = false)
	public java.util.List<com.yoooum.tars.commdata.TItemParam> vecEventDropList = null;

	public int getIID() {
		return iID;
	}

	public void setIID(int iID) {
		this.iID = iID;
	}

	public long getLBeginTM() {
		return lBeginTM;
	}

	public void setLBeginTM(long lBeginTM) {
		this.lBeginTM = lBeginTM;
	}

	public int getIBattelTimes() {
		return iBattelTimes;
	}

	public void setIBattelTimes(int iBattelTimes) {
		this.iBattelTimes = iBattelTimes;
	}

	public int getEGameResult() {
		return eGameResult;
	}

	public void setEGameResult(int eGameResult) {
		this.eGameResult = eGameResult;
	}

	public int getIReviveCount() {
		return iReviveCount;
	}

	public void setIReviveCount(int iReviveCount) {
		this.iReviveCount = iReviveCount;
	}

	public double getDScore() {
		return dScore;
	}

	public void setDScore(double dScore) {
		this.dScore = dScore;
	}

	public int getIEventID() {
		return iEventID;
	}

	public void setIEventID(int iEventID) {
		this.iEventID = iEventID;
	}

	public int getIChooseOption() {
		return iChooseOption;
	}

	public void setIChooseOption(int iChooseOption) {
		this.iChooseOption = iChooseOption;
	}

	public int getIEventState() {
		return iEventState;
	}

	public void setIEventState(int iEventState) {
		this.iEventState = iEventState;
	}

	public int getIEventType() {
		return iEventType;
	}

	public void setIEventType(int iEventType) {
		this.iEventType = iEventType;
	}

	public java.util.Map<java.lang.Integer, java.util.List<com.yoooum.tars.commdata.TItemParam>> getMDropList() {
		return mDropList;
	}

	public void setMDropList(java.util.Map<java.lang.Integer, java.util.List<com.yoooum.tars.commdata.TItemParam>> mDropList) {
		this.mDropList = mDropList;
	}

	public int getIDropCheckTime() {
		return iDropCheckTime;
	}

	public void setIDropCheckTime(int iDropCheckTime) {
		this.iDropCheckTime = iDropCheckTime;
	}

	public java.util.List<java.lang.Integer> getVecLearnSkill() {
		return vecLearnSkill;
	}

	public void setVecLearnSkill(java.util.List<java.lang.Integer> vecLearnSkill) {
		this.vecLearnSkill = vecLearnSkill;
	}

	public java.util.List<java.lang.Integer> getVecBuff() {
		return vecBuff;
	}

	public void setVecBuff(java.util.List<java.lang.Integer> vecBuff) {
		this.vecBuff = vecBuff;
	}

	public java.util.List<TProperty> getVecProperties() {
		return vecProperties;
	}

	public void setVecProperties(java.util.List<TProperty> vecProperties) {
		this.vecProperties = vecProperties;
	}

	public java.util.List<com.yoooum.tars.commdata.TItemParam> getVecEventDropList() {
		return vecEventDropList;
	}

	public void setVecEventDropList(java.util.List<com.yoooum.tars.commdata.TItemParam> vecEventDropList) {
		this.vecEventDropList = vecEventDropList;
	}

	public TStageDB() {
	}

	public TStageDB(int iID, long lBeginTM, int iBattelTimes, int eGameResult, int iReviveCount, double dScore, int iEventID, int iChooseOption, int iEventState, int iEventType, java.util.Map<java.lang.Integer, java.util.List<com.yoooum.tars.commdata.TItemParam>> mDropList, int iDropCheckTime, java.util.List<java.lang.Integer> vecLearnSkill, java.util.List<java.lang.Integer> vecBuff, java.util.List<TProperty> vecProperties, java.util.List<com.yoooum.tars.commdata.TItemParam> vecEventDropList) {
		this.iID = iID;
		this.lBeginTM = lBeginTM;
		this.iBattelTimes = iBattelTimes;
		this.eGameResult = eGameResult;
		this.iReviveCount = iReviveCount;
		this.dScore = dScore;
		this.iEventID = iEventID;
		this.iChooseOption = iChooseOption;
		this.iEventState = iEventState;
		this.iEventType = iEventType;
		this.mDropList = mDropList;
		this.iDropCheckTime = iDropCheckTime;
		this.vecLearnSkill = vecLearnSkill;
		this.vecBuff = vecBuff;
		this.vecProperties = vecProperties;
		this.vecEventDropList = vecEventDropList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iID);
		result = prime * result + TarsUtil.hashCode(lBeginTM);
		result = prime * result + TarsUtil.hashCode(iBattelTimes);
		result = prime * result + TarsUtil.hashCode(eGameResult);
		result = prime * result + TarsUtil.hashCode(iReviveCount);
		result = prime * result + TarsUtil.hashCode(dScore);
		result = prime * result + TarsUtil.hashCode(iEventID);
		result = prime * result + TarsUtil.hashCode(iChooseOption);
		result = prime * result + TarsUtil.hashCode(iEventState);
		result = prime * result + TarsUtil.hashCode(iEventType);
		result = prime * result + TarsUtil.hashCode(mDropList);
		result = prime * result + TarsUtil.hashCode(iDropCheckTime);
		result = prime * result + TarsUtil.hashCode(vecLearnSkill);
		result = prime * result + TarsUtil.hashCode(vecBuff);
		result = prime * result + TarsUtil.hashCode(vecProperties);
		result = prime * result + TarsUtil.hashCode(vecEventDropList);
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
		if (!(obj instanceof TStageDB)) {
			return false;
		}
		TStageDB other = (TStageDB) obj;
		return (
			TarsUtil.equals(iID, other.iID) &&
			TarsUtil.equals(lBeginTM, other.lBeginTM) &&
			TarsUtil.equals(iBattelTimes, other.iBattelTimes) &&
			TarsUtil.equals(eGameResult, other.eGameResult) &&
			TarsUtil.equals(iReviveCount, other.iReviveCount) &&
			TarsUtil.equals(dScore, other.dScore) &&
			TarsUtil.equals(iEventID, other.iEventID) &&
			TarsUtil.equals(iChooseOption, other.iChooseOption) &&
			TarsUtil.equals(iEventState, other.iEventState) &&
			TarsUtil.equals(iEventType, other.iEventType) &&
			TarsUtil.equals(mDropList, other.mDropList) &&
			TarsUtil.equals(iDropCheckTime, other.iDropCheckTime) &&
			TarsUtil.equals(vecLearnSkill, other.vecLearnSkill) &&
			TarsUtil.equals(vecBuff, other.vecBuff) &&
			TarsUtil.equals(vecProperties, other.vecProperties) &&
			TarsUtil.equals(vecEventDropList, other.vecEventDropList) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iID, 0);
		_os.write(lBeginTM, 1);
		_os.write(iBattelTimes, 2);
		_os.write(eGameResult, 3);
		_os.write(iReviveCount, 4);
		_os.write(dScore, 5);
		_os.write(iEventID, 6);
		_os.write(iChooseOption, 7);
		_os.write(iEventState, 8);
		_os.write(iEventType, 9);
		if (null != mDropList) {
			_os.write(mDropList, 10);
		}
		_os.write(iDropCheckTime, 11);
		if (null != vecLearnSkill) {
			_os.write(vecLearnSkill, 12);
		}
		if (null != vecBuff) {
			_os.write(vecBuff, 13);
		}
		if (null != vecProperties) {
			_os.write(vecProperties, 14);
		}
		if (null != vecEventDropList) {
			_os.write(vecEventDropList, 15);
		}
	}

	static java.util.Map<java.lang.Integer, java.util.List<com.yoooum.tars.commdata.TItemParam>> cache_mDropList;
	static { 
		cache_mDropList = new java.util.HashMap<java.lang.Integer, java.util.List<com.yoooum.tars.commdata.TItemParam>>();
		int var_35 = 0;
		java.util.List<com.yoooum.tars.commdata.TItemParam> var_36 = new java.util.ArrayList<com.yoooum.tars.commdata.TItemParam>();
		com.yoooum.tars.commdata.TItemParam var_37 = new com.yoooum.tars.commdata.TItemParam();
		var_36.add(var_37);
		cache_mDropList.put(var_35 ,var_36);
	}
	static java.util.List<java.lang.Integer> cache_vecLearnSkill;
	static { 
		cache_vecLearnSkill = new java.util.ArrayList<java.lang.Integer>();
		int var_38 = 0;
		cache_vecLearnSkill.add(var_38);
	}
	static java.util.List<java.lang.Integer> cache_vecBuff;
	static { 
		cache_vecBuff = new java.util.ArrayList<java.lang.Integer>();
		int var_39 = 0;
		cache_vecBuff.add(var_39);
	}
	static java.util.List<TProperty> cache_vecProperties;
	static { 
		cache_vecProperties = new java.util.ArrayList<TProperty>();
		TProperty var_40 = new TProperty();
		cache_vecProperties.add(var_40);
	}
	static java.util.List<com.yoooum.tars.commdata.TItemParam> cache_vecEventDropList;
	static { 
		cache_vecEventDropList = new java.util.ArrayList<com.yoooum.tars.commdata.TItemParam>();
		com.yoooum.tars.commdata.TItemParam var_41 = new com.yoooum.tars.commdata.TItemParam();
		cache_vecEventDropList.add(var_41);
	}

	public void readFrom(TarsInputStream _is) {
		this.iID = _is.read(iID, 0, false);
		this.lBeginTM = _is.read(lBeginTM, 1, false);
		this.iBattelTimes = _is.read(iBattelTimes, 2, false);
		this.eGameResult = _is.read(eGameResult, 3, false);
		this.iReviveCount = _is.read(iReviveCount, 4, false);
		this.dScore = _is.read(dScore, 5, false);
		this.iEventID = _is.read(iEventID, 6, false);
		this.iChooseOption = _is.read(iChooseOption, 7, false);
		this.iEventState = _is.read(iEventState, 8, false);
		this.iEventType = _is.read(iEventType, 9, false);
		this.mDropList = (java.util.Map<java.lang.Integer, java.util.List<com.yoooum.tars.commdata.TItemParam>>) _is.read(cache_mDropList, 10, false);
		this.iDropCheckTime = _is.read(iDropCheckTime, 11, false);
		this.vecLearnSkill = (java.util.List<java.lang.Integer>) _is.read(cache_vecLearnSkill, 12, false);
		this.vecBuff = (java.util.List<java.lang.Integer>) _is.read(cache_vecBuff, 13, false);
		this.vecProperties = (java.util.List<TProperty>) _is.read(cache_vecProperties, 14, false);
		this.vecEventDropList = (java.util.List<com.yoooum.tars.commdata.TItemParam>) _is.read(cache_vecEventDropList, 15, false);
	}

}