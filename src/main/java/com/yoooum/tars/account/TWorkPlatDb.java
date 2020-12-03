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
public class TWorkPlatDb {

	@TarsStructProperty(order = 0, isRequire = false)
	public java.util.List<TSubWorkPlatDb> vsubplatdata = null;

	public java.util.List<TSubWorkPlatDb> getVsubplatdata() {
		return vsubplatdata;
	}

	public void setVsubplatdata(java.util.List<TSubWorkPlatDb> vsubplatdata) {
		this.vsubplatdata = vsubplatdata;
	}

	public TWorkPlatDb() {
	}

	public TWorkPlatDb(java.util.List<TSubWorkPlatDb> vsubplatdata) {
		this.vsubplatdata = vsubplatdata;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(vsubplatdata);
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
		if (!(obj instanceof TWorkPlatDb)) {
			return false;
		}
		TWorkPlatDb other = (TWorkPlatDb) obj;
		return (
			TarsUtil.equals(vsubplatdata, other.vsubplatdata) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != vsubplatdata) {
			_os.write(vsubplatdata, 0);
		}
	}

	static java.util.List<TSubWorkPlatDb> cache_vsubplatdata;
	static { 
		cache_vsubplatdata = new java.util.ArrayList<TSubWorkPlatDb>();
		TSubWorkPlatDb var_79 = new TSubWorkPlatDb();
		cache_vsubplatdata.add(var_79);
	}

	public void readFrom(TarsInputStream _is) {
		this.vsubplatdata = (java.util.List<TSubWorkPlatDb>) _is.read(cache_vsubplatdata, 0, false);
	}

}