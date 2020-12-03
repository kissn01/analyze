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
public class TDBBagInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public java.util.List<TDBBagResource> vecResource = null;
	@TarsStructProperty(order = 1, isRequire = false)
	public java.util.List<TDBBagTimerResource> vecTimerResource = null;

	public java.util.List<TDBBagResource> getVecResource() {
		return vecResource;
	}

	public void setVecResource(java.util.List<TDBBagResource> vecResource) {
		this.vecResource = vecResource;
	}

	public java.util.List<TDBBagTimerResource> getVecTimerResource() {
		return vecTimerResource;
	}

	public void setVecTimerResource(java.util.List<TDBBagTimerResource> vecTimerResource) {
		this.vecTimerResource = vecTimerResource;
	}

	public TDBBagInfo() {
	}

	public TDBBagInfo(java.util.List<TDBBagResource> vecResource, java.util.List<TDBBagTimerResource> vecTimerResource) {
		this.vecResource = vecResource;
		this.vecTimerResource = vecTimerResource;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(vecResource);
		result = prime * result + TarsUtil.hashCode(vecTimerResource);
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
		if (!(obj instanceof TDBBagInfo)) {
			return false;
		}
		TDBBagInfo other = (TDBBagInfo) obj;
		return (
			TarsUtil.equals(vecResource, other.vecResource) &&
			TarsUtil.equals(vecTimerResource, other.vecTimerResource) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != vecResource) {
			_os.write(vecResource, 0);
		}
		if (null != vecTimerResource) {
			_os.write(vecTimerResource, 1);
		}
	}

	static java.util.List<TDBBagResource> cache_vecResource;
	static { 
		cache_vecResource = new java.util.ArrayList<TDBBagResource>();
		TDBBagResource var_19 = new TDBBagResource();
		cache_vecResource.add(var_19);
	}
	static java.util.List<TDBBagTimerResource> cache_vecTimerResource;
	static { 
		cache_vecTimerResource = new java.util.ArrayList<TDBBagTimerResource>();
		TDBBagTimerResource var_20 = new TDBBagTimerResource();
		cache_vecTimerResource.add(var_20);
	}

	public void readFrom(TarsInputStream _is) {
		this.vecResource = (java.util.List<TDBBagResource>) _is.read(cache_vecResource, 0, false);
		this.vecTimerResource = (java.util.List<TDBBagTimerResource>) _is.read(cache_vecTimerResource, 1, false);
	}

}
