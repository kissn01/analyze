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
public class TTriggerOnlineTime {

	@TarsStructProperty(order = 0, isRequire = false)
	public short shruleid = (short)0;
	@TarsStructProperty(order = 1, isRequire = false)
	public short shonlinetime = (short)0;

	public short getShruleid() {
		return shruleid;
	}

	public void setShruleid(short shruleid) {
		this.shruleid = shruleid;
	}

	public short getShonlinetime() {
		return shonlinetime;
	}

	public void setShonlinetime(short shonlinetime) {
		this.shonlinetime = shonlinetime;
	}

	public TTriggerOnlineTime() {
	}

	public TTriggerOnlineTime(short shruleid, short shonlinetime) {
		this.shruleid = shruleid;
		this.shonlinetime = shonlinetime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(shruleid);
		result = prime * result + TarsUtil.hashCode(shonlinetime);
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
		if (!(obj instanceof TTriggerOnlineTime)) {
			return false;
		}
		TTriggerOnlineTime other = (TTriggerOnlineTime) obj;
		return (
			TarsUtil.equals(shruleid, other.shruleid) &&
			TarsUtil.equals(shonlinetime, other.shonlinetime) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(shruleid, 0);
		_os.write(shonlinetime, 1);
	}


	public void readFrom(TarsInputStream _is) {
		this.shruleid = _is.read(shruleid, 0, false);
		this.shonlinetime = _is.read(shonlinetime, 1, false);
	}

}
