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
public class TStoryGameData {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iid = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public byte cstatus = (byte)0;
	@TarsStructProperty(order = 2, isRequire = false)
	public java.util.List<java.lang.Integer> vecparam = null;

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public byte getCstatus() {
		return cstatus;
	}

	public void setCstatus(byte cstatus) {
		this.cstatus = cstatus;
	}

	public java.util.List<java.lang.Integer> getVecparam() {
		return vecparam;
	}

	public void setVecparam(java.util.List<java.lang.Integer> vecparam) {
		this.vecparam = vecparam;
	}

	public TStoryGameData() {
	}

	public TStoryGameData(int iid, byte cstatus, java.util.List<java.lang.Integer> vecparam) {
		this.iid = iid;
		this.cstatus = cstatus;
		this.vecparam = vecparam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iid);
		result = prime * result + TarsUtil.hashCode(cstatus);
		result = prime * result + TarsUtil.hashCode(vecparam);
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
		if (!(obj instanceof TStoryGameData)) {
			return false;
		}
		TStoryGameData other = (TStoryGameData) obj;
		return (
			TarsUtil.equals(iid, other.iid) &&
			TarsUtil.equals(cstatus, other.cstatus) &&
			TarsUtil.equals(vecparam, other.vecparam) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iid, 0);
		_os.write(cstatus, 1);
		if (null != vecparam) {
			_os.write(vecparam, 2);
		}
	}

	static java.util.List<java.lang.Integer> cache_vecparam;
	static { 
		cache_vecparam = new java.util.ArrayList<java.lang.Integer>();
		int var_49 = 0;
		cache_vecparam.add(var_49);
	}

	public void readFrom(TarsInputStream _is) {
		this.iid = _is.read(iid, 0, false);
		this.cstatus = _is.read(cstatus, 1, false);
		this.vecparam = (java.util.List<java.lang.Integer>) _is.read(cache_vecparam, 2, false);
	}

}