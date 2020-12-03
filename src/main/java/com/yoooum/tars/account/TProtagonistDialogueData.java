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
public class TProtagonistDialogueData {

	@TarsStructProperty(order = 0, isRequire = false)
	public short iid = (short)0;
	@TarsStructProperty(order = 1, isRequire = false)
	public byte creward = (byte)0;

	public short getIid() {
		return iid;
	}

	public void setIid(short iid) {
		this.iid = iid;
	}

	public byte getCreward() {
		return creward;
	}

	public void setCreward(byte creward) {
		this.creward = creward;
	}

	public TProtagonistDialogueData() {
	}

	public TProtagonistDialogueData(short iid, byte creward) {
		this.iid = iid;
		this.creward = creward;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iid);
		result = prime * result + TarsUtil.hashCode(creward);
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
		if (!(obj instanceof TProtagonistDialogueData)) {
			return false;
		}
		TProtagonistDialogueData other = (TProtagonistDialogueData) obj;
		return (
			TarsUtil.equals(iid, other.iid) &&
			TarsUtil.equals(creward, other.creward) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iid, 0);
		_os.write(creward, 1);
	}


	public void readFrom(TarsInputStream _is) {
		this.iid = _is.read(iid, 0, false);
		this.creward = _is.read(creward, 1, false);
	}

}
