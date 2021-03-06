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
public class TDBBagTimerResource {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iResID = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public long uTime = 0L;

	public int getIResID() {
		return iResID;
	}

	public void setIResID(int iResID) {
		this.iResID = iResID;
	}

	public long getUTime() {
		return uTime;
	}

	public void setUTime(long uTime) {
		this.uTime = uTime;
	}

	public TDBBagTimerResource() {
	}

	public TDBBagTimerResource(int iResID, long uTime) {
		this.iResID = iResID;
		this.uTime = uTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iResID);
		result = prime * result + TarsUtil.hashCode(uTime);
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
		if (!(obj instanceof TDBBagTimerResource)) {
			return false;
		}
		TDBBagTimerResource other = (TDBBagTimerResource) obj;
		return (
			TarsUtil.equals(iResID, other.iResID) &&
			TarsUtil.equals(uTime, other.uTime) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iResID, 0);
		_os.write(uTime, 1);
	}


	public void readFrom(TarsInputStream _is) {
		this.iResID = _is.read(iResID, 0, false);
		this.uTime = _is.read(uTime, 1, false);
	}

}
