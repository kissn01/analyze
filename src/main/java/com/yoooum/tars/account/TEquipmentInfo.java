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
public class TEquipmentInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public java.util.List<java.util.Map<java.lang.Integer, TEquipmentItemDb>> vRoleEquipGrid = null;
	@TarsStructProperty(order = 1, isRequire = false)
	public java.util.Map<java.lang.Integer, java.util.List<TEquipmentItemDb>> mEquipStore = null;

	public java.util.List<java.util.Map<java.lang.Integer, TEquipmentItemDb>> getVRoleEquipGrid() {
		return vRoleEquipGrid;
	}

	public void setVRoleEquipGrid(java.util.List<java.util.Map<java.lang.Integer, TEquipmentItemDb>> vRoleEquipGrid) {
		this.vRoleEquipGrid = vRoleEquipGrid;
	}

	public java.util.Map<java.lang.Integer, java.util.List<TEquipmentItemDb>> getMEquipStore() {
		return mEquipStore;
	}

	public void setMEquipStore(java.util.Map<java.lang.Integer, java.util.List<TEquipmentItemDb>> mEquipStore) {
		this.mEquipStore = mEquipStore;
	}

	public TEquipmentInfo() {
	}

	public TEquipmentInfo(java.util.List<java.util.Map<java.lang.Integer, TEquipmentItemDb>> vRoleEquipGrid, java.util.Map<java.lang.Integer, java.util.List<TEquipmentItemDb>> mEquipStore) {
		this.vRoleEquipGrid = vRoleEquipGrid;
		this.mEquipStore = mEquipStore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(vRoleEquipGrid);
		result = prime * result + TarsUtil.hashCode(mEquipStore);
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
		if (!(obj instanceof TEquipmentInfo)) {
			return false;
		}
		TEquipmentInfo other = (TEquipmentInfo) obj;
		return (
			TarsUtil.equals(vRoleEquipGrid, other.vRoleEquipGrid) &&
			TarsUtil.equals(mEquipStore, other.mEquipStore) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != vRoleEquipGrid) {
			_os.write(vRoleEquipGrid, 0);
		}
		if (null != mEquipStore) {
			_os.write(mEquipStore, 1);
		}
	}

	static java.util.List<java.util.Map<java.lang.Integer, TEquipmentItemDb>> cache_vRoleEquipGrid;
	static { 
		cache_vRoleEquipGrid = new java.util.ArrayList<java.util.Map<java.lang.Integer, TEquipmentItemDb>>();
		java.util.Map<java.lang.Integer, TEquipmentItemDb> var_22 = new java.util.HashMap<java.lang.Integer, TEquipmentItemDb>();
		int var_23 = 0;
		TEquipmentItemDb var_24 = new TEquipmentItemDb();
		var_22.put(var_23 ,var_24);
		cache_vRoleEquipGrid.add(var_22);
	}
	static java.util.Map<java.lang.Integer, java.util.List<TEquipmentItemDb>> cache_mEquipStore;
	static { 
		cache_mEquipStore = new java.util.HashMap<java.lang.Integer, java.util.List<TEquipmentItemDb>>();
		int var_25 = 0;
		java.util.List<TEquipmentItemDb> var_26 = new java.util.ArrayList<TEquipmentItemDb>();
		TEquipmentItemDb var_27 = new TEquipmentItemDb();
		var_26.add(var_27);
		cache_mEquipStore.put(var_25 ,var_26);
	}

	public void readFrom(TarsInputStream _is) {
		this.vRoleEquipGrid = (java.util.List<java.util.Map<java.lang.Integer, TEquipmentItemDb>>) _is.read(cache_vRoleEquipGrid, 0, false);
		this.mEquipStore = (java.util.Map<java.lang.Integer, java.util.List<TEquipmentItemDb>>) _is.read(cache_mEquipStore, 1, false);
	}

}
