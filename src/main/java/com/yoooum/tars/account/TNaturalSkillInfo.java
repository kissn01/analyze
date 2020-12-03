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
public class TNaturalSkillInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public java.util.List<TNaturalItemInfo> vecNatural = null;
	@TarsStructProperty(order = 3, isRequire = false)
	public int iTotalDrawTimes = 0;
	@TarsStructProperty(order = 4, isRequire = false)
	public int iShopTotalDrawTimes = 0;

	public java.util.List<TNaturalItemInfo> getVecNatural() {
		return vecNatural;
	}

	public void setVecNatural(java.util.List<TNaturalItemInfo> vecNatural) {
		this.vecNatural = vecNatural;
	}

	public int getITotalDrawTimes() {
		return iTotalDrawTimes;
	}

	public void setITotalDrawTimes(int iTotalDrawTimes) {
		this.iTotalDrawTimes = iTotalDrawTimes;
	}

	public int getIShopTotalDrawTimes() {
		return iShopTotalDrawTimes;
	}

	public void setIShopTotalDrawTimes(int iShopTotalDrawTimes) {
		this.iShopTotalDrawTimes = iShopTotalDrawTimes;
	}

	public TNaturalSkillInfo() {
	}

	public TNaturalSkillInfo(java.util.List<TNaturalItemInfo> vecNatural, int iTotalDrawTimes, int iShopTotalDrawTimes) {
		this.vecNatural = vecNatural;
		this.iTotalDrawTimes = iTotalDrawTimes;
		this.iShopTotalDrawTimes = iShopTotalDrawTimes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(vecNatural);
		result = prime * result + TarsUtil.hashCode(iTotalDrawTimes);
		result = prime * result + TarsUtil.hashCode(iShopTotalDrawTimes);
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
		if (!(obj instanceof TNaturalSkillInfo)) {
			return false;
		}
		TNaturalSkillInfo other = (TNaturalSkillInfo) obj;
		return (
			TarsUtil.equals(vecNatural, other.vecNatural) &&
			TarsUtil.equals(iTotalDrawTimes, other.iTotalDrawTimes) &&
			TarsUtil.equals(iShopTotalDrawTimes, other.iShopTotalDrawTimes) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != vecNatural) {
			_os.write(vecNatural, 0);
		}
		_os.write(iTotalDrawTimes, 3);
		_os.write(iShopTotalDrawTimes, 4);
	}

	static java.util.List<TNaturalItemInfo> cache_vecNatural;
	static { 
		cache_vecNatural = new java.util.ArrayList<TNaturalItemInfo>();
		TNaturalItemInfo var_28 = new TNaturalItemInfo();
		cache_vecNatural.add(var_28);
	}

	public void readFrom(TarsInputStream _is) {
		this.vecNatural = (java.util.List<TNaturalItemInfo>) _is.read(cache_vecNatural, 0, false);
		this.iTotalDrawTimes = _is.read(iTotalDrawTimes, 3, false);
		this.iShopTotalDrawTimes = _is.read(iShopTotalDrawTimes, 4, false);
	}

}