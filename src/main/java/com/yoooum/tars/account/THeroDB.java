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
public class THeroDB {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iID = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public int iExp = 0;
	@TarsStructProperty(order = 2, isRequire = false)
	public short nLvl = (short)0;
	@TarsStructProperty(order = 3, isRequire = false)
	public int iSkinId = 0;
	@TarsStructProperty(order = 4, isRequire = false)
	public java.util.List<java.lang.Integer> vecSkinList = null;
	@TarsStructProperty(order = 5, isRequire = false)
	public int iProficiency = 0;
	@TarsStructProperty(order = 6, isRequire = false)
	public java.util.List<java.lang.Integer> vecLevelUpSkill = null;
	@TarsStructProperty(order = 8, isRequire = false)
	public String sRoomId = "";
	@TarsStructProperty(order = 13, isRequire = false)
	public int iHP = 0;
	@TarsStructProperty(order = 14, isRequire = false)
	public int iMaxHP = 0;
	@TarsStructProperty(order = 15, isRequire = false)
	public boolean bLock = false;

	public int getIID() {
		return iID;
	}

	public void setIID(int iID) {
		this.iID = iID;
	}

	public int getIExp() {
		return iExp;
	}

	public void setIExp(int iExp) {
		this.iExp = iExp;
	}

	public short getNLvl() {
		return nLvl;
	}

	public void setNLvl(short nLvl) {
		this.nLvl = nLvl;
	}

	public int getISkinId() {
		return iSkinId;
	}

	public void setISkinId(int iSkinId) {
		this.iSkinId = iSkinId;
	}

	public java.util.List<java.lang.Integer> getVecSkinList() {
		return vecSkinList;
	}

	public void setVecSkinList(java.util.List<java.lang.Integer> vecSkinList) {
		this.vecSkinList = vecSkinList;
	}

	public int getIProficiency() {
		return iProficiency;
	}

	public void setIProficiency(int iProficiency) {
		this.iProficiency = iProficiency;
	}

	public java.util.List<java.lang.Integer> getVecLevelUpSkill() {
		return vecLevelUpSkill;
	}

	public void setVecLevelUpSkill(java.util.List<java.lang.Integer> vecLevelUpSkill) {
		this.vecLevelUpSkill = vecLevelUpSkill;
	}

	public String getSRoomId() {
		return sRoomId;
	}

	public void setSRoomId(String sRoomId) {
		this.sRoomId = sRoomId;
	}

	public int getIHP() {
		return iHP;
	}

	public void setIHP(int iHP) {
		this.iHP = iHP;
	}

	public int getIMaxHP() {
		return iMaxHP;
	}

	public void setIMaxHP(int iMaxHP) {
		this.iMaxHP = iMaxHP;
	}

	public boolean getBLock() {
		return bLock;
	}

	public void setBLock(boolean bLock) {
		this.bLock = bLock;
	}

	public THeroDB() {
	}

	public THeroDB(int iID, int iExp, short nLvl, int iSkinId, java.util.List<java.lang.Integer> vecSkinList, int iProficiency, java.util.List<java.lang.Integer> vecLevelUpSkill, String sRoomId, int iHP, int iMaxHP, boolean bLock) {
		this.iID = iID;
		this.iExp = iExp;
		this.nLvl = nLvl;
		this.iSkinId = iSkinId;
		this.vecSkinList = vecSkinList;
		this.iProficiency = iProficiency;
		this.vecLevelUpSkill = vecLevelUpSkill;
		this.sRoomId = sRoomId;
		this.iHP = iHP;
		this.iMaxHP = iMaxHP;
		this.bLock = bLock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iID);
		result = prime * result + TarsUtil.hashCode(iExp);
		result = prime * result + TarsUtil.hashCode(nLvl);
		result = prime * result + TarsUtil.hashCode(iSkinId);
		result = prime * result + TarsUtil.hashCode(vecSkinList);
		result = prime * result + TarsUtil.hashCode(iProficiency);
		result = prime * result + TarsUtil.hashCode(vecLevelUpSkill);
		result = prime * result + TarsUtil.hashCode(sRoomId);
		result = prime * result + TarsUtil.hashCode(iHP);
		result = prime * result + TarsUtil.hashCode(iMaxHP);
		result = prime * result + TarsUtil.hashCode(bLock);
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
		if (!(obj instanceof THeroDB)) {
			return false;
		}
		THeroDB other = (THeroDB) obj;
		return (
			TarsUtil.equals(iID, other.iID) &&
			TarsUtil.equals(iExp, other.iExp) &&
			TarsUtil.equals(nLvl, other.nLvl) &&
			TarsUtil.equals(iSkinId, other.iSkinId) &&
			TarsUtil.equals(vecSkinList, other.vecSkinList) &&
			TarsUtil.equals(iProficiency, other.iProficiency) &&
			TarsUtil.equals(vecLevelUpSkill, other.vecLevelUpSkill) &&
			TarsUtil.equals(sRoomId, other.sRoomId) &&
			TarsUtil.equals(iHP, other.iHP) &&
			TarsUtil.equals(iMaxHP, other.iMaxHP) &&
			TarsUtil.equals(bLock, other.bLock) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iID, 0);
		_os.write(iExp, 1);
		_os.write(nLvl, 2);
		_os.write(iSkinId, 3);
		if (null != vecSkinList) {
			_os.write(vecSkinList, 4);
		}
		_os.write(iProficiency, 5);
		if (null != vecLevelUpSkill) {
			_os.write(vecLevelUpSkill, 6);
		}
		if (null != sRoomId) {
			_os.write(sRoomId, 8);
		}
		_os.write(iHP, 13);
		_os.write(iMaxHP, 14);
		_os.write(bLock, 15);
	}

	static java.util.List<java.lang.Integer> cache_vecSkinList;
	static { 
		cache_vecSkinList = new java.util.ArrayList<java.lang.Integer>();
		int var_32 = 0;
		cache_vecSkinList.add(var_32);
	}
	static java.util.List<java.lang.Integer> cache_vecLevelUpSkill;
	static { 
		cache_vecLevelUpSkill = new java.util.ArrayList<java.lang.Integer>();
		int var_33 = 0;
		cache_vecLevelUpSkill.add(var_33);
	}

	public void readFrom(TarsInputStream _is) {
		this.iID = _is.read(iID, 0, false);
		this.iExp = _is.read(iExp, 1, false);
		this.nLvl = _is.read(nLvl, 2, false);
		this.iSkinId = _is.read(iSkinId, 3, false);
		this.vecSkinList = (java.util.List<java.lang.Integer>) _is.read(cache_vecSkinList, 4, false);
		this.iProficiency = _is.read(iProficiency, 5, false);
		this.vecLevelUpSkill = (java.util.List<java.lang.Integer>) _is.read(cache_vecLevelUpSkill, 6, false);
		this.sRoomId = _is.readString(8, false);
		this.iHP = _is.read(iHP, 13, false);
		this.iMaxHP = _is.read(iMaxHP, 14, false);
		this.bLock = _is.read(bLock, 15, false);
	}

}
