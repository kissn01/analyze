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
public class TProtagProfileData {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iid = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public java.util.List<java.lang.Short> vecprofile = null;

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public java.util.List<java.lang.Short> getVecprofile() {
		return vecprofile;
	}

	public void setVecprofile(java.util.List<java.lang.Short> vecprofile) {
		this.vecprofile = vecprofile;
	}

	public TProtagProfileData() {
	}

	public TProtagProfileData(int iid, java.util.List<java.lang.Short> vecprofile) {
		this.iid = iid;
		this.vecprofile = vecprofile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iid);
		result = prime * result + TarsUtil.hashCode(vecprofile);
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
		if (!(obj instanceof TProtagProfileData)) {
			return false;
		}
		TProtagProfileData other = (TProtagProfileData) obj;
		return (
			TarsUtil.equals(iid, other.iid) &&
			TarsUtil.equals(vecprofile, other.vecprofile) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iid, 0);
		if (null != vecprofile) {
			_os.write(vecprofile, 1);
		}
	}

	static java.util.List<java.lang.Short> cache_vecprofile;
	static { 
		cache_vecprofile = new java.util.ArrayList<java.lang.Short>();
		short var_19 = (short)0;
		cache_vecprofile.add(var_19);
	}

	public void readFrom(TarsInputStream _is) {
		this.iid = _is.read(iid, 0, false);
		this.vecprofile = (java.util.List<java.lang.Short>) _is.read(cache_vecprofile, 1, false);
	}

}
