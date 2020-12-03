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
public class TEquipmentItemDb {

	@TarsStructProperty(order = 0, isRequire = false)
	public String sUniqID = "";
	@TarsStructProperty(order = 1, isRequire = false)
	public int iEquipID = 0;
	@TarsStructProperty(order = 2, isRequire = false)
	public int iLevel = 0;
	@TarsStructProperty(order = 3, isRequire = false)
	public boolean bEvaluation = false;
	@TarsStructProperty(order = 4, isRequire = false)
	public java.util.List<TProperty> vecExternalProperties = null;
	@TarsStructProperty(order = 6, isRequire = false)
	public int iPos = 0;
	@TarsStructProperty(order = 7, isRequire = false)
	public boolean bNew = true;

	public String getSUniqID() {
		return sUniqID;
	}

	public void setSUniqID(String sUniqID) {
		this.sUniqID = sUniqID;
	}

	public int getIEquipID() {
		return iEquipID;
	}

	public void setIEquipID(int iEquipID) {
		this.iEquipID = iEquipID;
	}

	public int getILevel() {
		return iLevel;
	}

	public void setILevel(int iLevel) {
		this.iLevel = iLevel;
	}

	public boolean getBEvaluation() {
		return bEvaluation;
	}

	public void setBEvaluation(boolean bEvaluation) {
		this.bEvaluation = bEvaluation;
	}

	public java.util.List<TProperty> getVecExternalProperties() {
		return vecExternalProperties;
	}

	public void setVecExternalProperties(java.util.List<TProperty> vecExternalProperties) {
		this.vecExternalProperties = vecExternalProperties;
	}

	public int getIPos() {
		return iPos;
	}

	public void setIPos(int iPos) {
		this.iPos = iPos;
	}

	public boolean getBNew() {
		return bNew;
	}

	public void setBNew(boolean bNew) {
		this.bNew = bNew;
	}

	public TEquipmentItemDb() {
	}

	public TEquipmentItemDb(String sUniqID, int iEquipID, int iLevel, boolean bEvaluation, java.util.List<TProperty> vecExternalProperties, int iPos, boolean bNew) {
		this.sUniqID = sUniqID;
		this.iEquipID = iEquipID;
		this.iLevel = iLevel;
		this.bEvaluation = bEvaluation;
		this.vecExternalProperties = vecExternalProperties;
		this.iPos = iPos;
		this.bNew = bNew;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(sUniqID);
		result = prime * result + TarsUtil.hashCode(iEquipID);
		result = prime * result + TarsUtil.hashCode(iLevel);
		result = prime * result + TarsUtil.hashCode(bEvaluation);
		result = prime * result + TarsUtil.hashCode(vecExternalProperties);
		result = prime * result + TarsUtil.hashCode(iPos);
		result = prime * result + TarsUtil.hashCode(bNew);
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
		if (!(obj instanceof TEquipmentItemDb)) {
			return false;
		}
		TEquipmentItemDb other = (TEquipmentItemDb) obj;
		return (
			TarsUtil.equals(sUniqID, other.sUniqID) &&
			TarsUtil.equals(iEquipID, other.iEquipID) &&
			TarsUtil.equals(iLevel, other.iLevel) &&
			TarsUtil.equals(bEvaluation, other.bEvaluation) &&
			TarsUtil.equals(vecExternalProperties, other.vecExternalProperties) &&
			TarsUtil.equals(iPos, other.iPos) &&
			TarsUtil.equals(bNew, other.bNew) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != sUniqID) {
			_os.write(sUniqID, 0);
		}
		_os.write(iEquipID, 1);
		_os.write(iLevel, 2);
		_os.write(bEvaluation, 3);
		if (null != vecExternalProperties) {
			_os.write(vecExternalProperties, 4);
		}
		_os.write(iPos, 6);
		_os.write(bNew, 7);
	}

	static java.util.List<TProperty> cache_vecExternalProperties;
	static { 
		cache_vecExternalProperties = new java.util.ArrayList<TProperty>();
		TProperty var_21 = new TProperty();
		cache_vecExternalProperties.add(var_21);
	}

	public void readFrom(TarsInputStream _is) {
		this.sUniqID = _is.readString(0, false);
		this.iEquipID = _is.read(iEquipID, 1, false);
		this.iLevel = _is.read(iLevel, 2, false);
		this.bEvaluation = _is.read(bEvaluation, 3, false);
		this.vecExternalProperties = (java.util.List<TProperty>) _is.read(cache_vecExternalProperties, 4, false);
		this.iPos = _is.read(iPos, 6, false);
		this.bNew = _is.read(bNew, 7, false);
	}

}