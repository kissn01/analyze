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
public class TWharfDbInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iuseship = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public short shwharflvl = (short)0;
	@TarsStructProperty(order = 2, isRequire = false)
	public long uendbacktime = 0L;
	@TarsStructProperty(order = 3, isRequire = false)
	public java.util.List<java.lang.Integer> vecshipid = null;
	@TarsStructProperty(order = 4, isRequire = false)
	public int ipropprice = 0;
	@TarsStructProperty(order = 5, isRequire = false)
	public byte cstatus = (byte)0;

	public int getIuseship() {
		return iuseship;
	}

	public void setIuseship(int iuseship) {
		this.iuseship = iuseship;
	}

	public short getShwharflvl() {
		return shwharflvl;
	}

	public void setShwharflvl(short shwharflvl) {
		this.shwharflvl = shwharflvl;
	}

	public long getUendbacktime() {
		return uendbacktime;
	}

	public void setUendbacktime(long uendbacktime) {
		this.uendbacktime = uendbacktime;
	}

	public java.util.List<java.lang.Integer> getVecshipid() {
		return vecshipid;
	}

	public void setVecshipid(java.util.List<java.lang.Integer> vecshipid) {
		this.vecshipid = vecshipid;
	}

	public int getIpropprice() {
		return ipropprice;
	}

	public void setIpropprice(int ipropprice) {
		this.ipropprice = ipropprice;
	}

	public byte getCstatus() {
		return cstatus;
	}

	public void setCstatus(byte cstatus) {
		this.cstatus = cstatus;
	}

	public TWharfDbInfo() {
	}

	public TWharfDbInfo(int iuseship, short shwharflvl, long uendbacktime, java.util.List<java.lang.Integer> vecshipid, int ipropprice, byte cstatus) {
		this.iuseship = iuseship;
		this.shwharflvl = shwharflvl;
		this.uendbacktime = uendbacktime;
		this.vecshipid = vecshipid;
		this.ipropprice = ipropprice;
		this.cstatus = cstatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iuseship);
		result = prime * result + TarsUtil.hashCode(shwharflvl);
		result = prime * result + TarsUtil.hashCode(uendbacktime);
		result = prime * result + TarsUtil.hashCode(vecshipid);
		result = prime * result + TarsUtil.hashCode(ipropprice);
		result = prime * result + TarsUtil.hashCode(cstatus);
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
		if (!(obj instanceof TWharfDbInfo)) {
			return false;
		}
		TWharfDbInfo other = (TWharfDbInfo) obj;
		return (
			TarsUtil.equals(iuseship, other.iuseship) &&
			TarsUtil.equals(shwharflvl, other.shwharflvl) &&
			TarsUtil.equals(uendbacktime, other.uendbacktime) &&
			TarsUtil.equals(vecshipid, other.vecshipid) &&
			TarsUtil.equals(ipropprice, other.ipropprice) &&
			TarsUtil.equals(cstatus, other.cstatus) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iuseship, 0);
		_os.write(shwharflvl, 1);
		_os.write(uendbacktime, 2);
		if (null != vecshipid) {
			_os.write(vecshipid, 3);
		}
		_os.write(ipropprice, 4);
		_os.write(cstatus, 5);
	}

	static java.util.List<java.lang.Integer> cache_vecshipid;
	static { 
		cache_vecshipid = new java.util.ArrayList<java.lang.Integer>();
		int var_97 = 0;
		cache_vecshipid.add(var_97);
	}

	public void readFrom(TarsInputStream _is) {
		this.iuseship = _is.read(iuseship, 0, false);
		this.shwharflvl = _is.read(shwharflvl, 1, false);
		this.uendbacktime = _is.read(uendbacktime, 2, false);
		this.vecshipid = (java.util.List<java.lang.Integer>) _is.read(cache_vecshipid, 3, false);
		this.ipropprice = _is.read(ipropprice, 4, false);
		this.cstatus = _is.read(cstatus, 5, false);
	}

}
