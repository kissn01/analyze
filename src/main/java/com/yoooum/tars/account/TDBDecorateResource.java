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
public class TDBDecorateResource {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iresid = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public int icount = 0;
	@TarsStructProperty(order = 2, isRequire = false)
	public int ileftcount = 0;

	public int getIresid() {
		return iresid;
	}

	public void setIresid(int iresid) {
		this.iresid = iresid;
	}

	public int getIcount() {
		return icount;
	}

	public void setIcount(int icount) {
		this.icount = icount;
	}

	public int getIleftcount() {
		return ileftcount;
	}

	public void setIleftcount(int ileftcount) {
		this.ileftcount = ileftcount;
	}

	public TDBDecorateResource() {
	}

	public TDBDecorateResource(int iresid, int icount, int ileftcount) {
		this.iresid = iresid;
		this.icount = icount;
		this.ileftcount = ileftcount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iresid);
		result = prime * result + TarsUtil.hashCode(icount);
		result = prime * result + TarsUtil.hashCode(ileftcount);
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
		if (!(obj instanceof TDBDecorateResource)) {
			return false;
		}
		TDBDecorateResource other = (TDBDecorateResource) obj;
		return (
			TarsUtil.equals(iresid, other.iresid) &&
			TarsUtil.equals(icount, other.icount) &&
			TarsUtil.equals(ileftcount, other.ileftcount) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iresid, 0);
		_os.write(icount, 1);
		_os.write(ileftcount, 2);
	}


	public void readFrom(TarsInputStream _is) {
		this.iresid = _is.read(iresid, 0, false);
		this.icount = _is.read(icount, 1, false);
		this.ileftcount = _is.read(ileftcount, 2, false);
	}

}