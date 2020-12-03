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
public class TNaturalSlotHistoryInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public short nDrawRound = 1;
	@TarsStructProperty(order = 1, isRequire = false)
	public short nDrawTimes = 0;

	public short getNDrawRound() {
		return nDrawRound;
	}

	public void setNDrawRound(short nDrawRound) {
		this.nDrawRound = nDrawRound;
	}

	public short getNDrawTimes() {
		return nDrawTimes;
	}

	public void setNDrawTimes(short nDrawTimes) {
		this.nDrawTimes = nDrawTimes;
	}

	public TNaturalSlotHistoryInfo() {
	}

	public TNaturalSlotHistoryInfo(short nDrawRound, short nDrawTimes) {
		this.nDrawRound = nDrawRound;
		this.nDrawTimes = nDrawTimes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(nDrawRound);
		result = prime * result + TarsUtil.hashCode(nDrawTimes);
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
		if (!(obj instanceof TNaturalSlotHistoryInfo)) {
			return false;
		}
		TNaturalSlotHistoryInfo other = (TNaturalSlotHistoryInfo) obj;
		return (
			TarsUtil.equals(nDrawRound, other.nDrawRound) &&
			TarsUtil.equals(nDrawTimes, other.nDrawTimes) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(nDrawRound, 0);
		_os.write(nDrawTimes, 1);
	}


	public void readFrom(TarsInputStream _is) {
		this.nDrawRound = _is.read(nDrawRound, 0, false);
		this.nDrawTimes = _is.read(nDrawTimes, 1, false);
	}

}
