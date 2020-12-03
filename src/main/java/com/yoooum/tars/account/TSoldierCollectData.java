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
public class TSoldierCollectData {

	@TarsStructProperty(order = 0, isRequire = false)
	public short nAwardProgress = (short)0;
	@TarsStructProperty(order = 1, isRequire = false)
	public short nStatus = (short)0;

	public short getNAwardProgress() {
		return nAwardProgress;
	}

	public void setNAwardProgress(short nAwardProgress) {
		this.nAwardProgress = nAwardProgress;
	}

	public short getNStatus() {
		return nStatus;
	}

	public void setNStatus(short nStatus) {
		this.nStatus = nStatus;
	}

	public TSoldierCollectData() {
	}

	public TSoldierCollectData(short nAwardProgress, short nStatus) {
		this.nAwardProgress = nAwardProgress;
		this.nStatus = nStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(nAwardProgress);
		result = prime * result + TarsUtil.hashCode(nStatus);
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
		if (!(obj instanceof TSoldierCollectData)) {
			return false;
		}
		TSoldierCollectData other = (TSoldierCollectData) obj;
		return (
			TarsUtil.equals(nAwardProgress, other.nAwardProgress) &&
			TarsUtil.equals(nStatus, other.nStatus) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(nAwardProgress, 0);
		_os.write(nStatus, 1);
	}


	public void readFrom(TarsInputStream _is) {
		this.nAwardProgress = _is.read(nAwardProgress, 0, false);
		this.nStatus = _is.read(nStatus, 1, false);
	}

}
