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
public class TCatEventData {

	@TarsStructProperty(order = 0, isRequire = false)
	public short ieventid = (short)0;
	@TarsStructProperty(order = 1, isRequire = false)
	public short ushcatid = (short)0;
	@TarsStructProperty(order = 2, isRequire = false)
	public long uendtime = 0L;

	public short getIeventid() {
		return ieventid;
	}

	public void setIeventid(short ieventid) {
		this.ieventid = ieventid;
	}

	public short getUshcatid() {
		return ushcatid;
	}

	public void setUshcatid(short ushcatid) {
		this.ushcatid = ushcatid;
	}

	public long getUendtime() {
		return uendtime;
	}

	public void setUendtime(long uendtime) {
		this.uendtime = uendtime;
	}

	public TCatEventData() {
	}

	public TCatEventData(short ieventid, short ushcatid, long uendtime) {
		this.ieventid = ieventid;
		this.ushcatid = ushcatid;
		this.uendtime = uendtime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(ieventid);
		result = prime * result + TarsUtil.hashCode(ushcatid);
		result = prime * result + TarsUtil.hashCode(uendtime);
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
		if (!(obj instanceof TCatEventData)) {
			return false;
		}
		TCatEventData other = (TCatEventData) obj;
		return (
			TarsUtil.equals(ieventid, other.ieventid) &&
			TarsUtil.equals(ushcatid, other.ushcatid) &&
			TarsUtil.equals(uendtime, other.uendtime) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(ieventid, 0);
		_os.write(ushcatid, 1);
		_os.write(uendtime, 2);
	}


	public void readFrom(TarsInputStream _is) {
		this.ieventid = _is.read(ieventid, 0, false);
		this.ushcatid = _is.read(ushcatid, 1, false);
		this.uendtime = _is.read(uendtime, 2, false);
	}

}