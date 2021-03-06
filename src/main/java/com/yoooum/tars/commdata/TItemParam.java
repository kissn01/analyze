// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.commdata;

import com.qq.tars.protocol.util.*;
import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.*;
import com.qq.tars.protocol.tars.annotation.*;

@TarsStruct
public class TItemParam {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iItemID = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public long uItemCount = 0L;
	@TarsStructProperty(order = 2, isRequire = false)
	public long uItemTime = 0L;
	@TarsStructProperty(order = 3, isRequire = false)
	public int iItemType = 0;

	public int getIItemID() {
		return iItemID;
	}

	public void setIItemID(int iItemID) {
		this.iItemID = iItemID;
	}

	public long getUItemCount() {
		return uItemCount;
	}

	public void setUItemCount(long uItemCount) {
		this.uItemCount = uItemCount;
	}

	public long getUItemTime() {
		return uItemTime;
	}

	public void setUItemTime(long uItemTime) {
		this.uItemTime = uItemTime;
	}

	public int getIItemType() {
		return iItemType;
	}

	public void setIItemType(int iItemType) {
		this.iItemType = iItemType;
	}

	public TItemParam() {
	}

	public TItemParam(int iItemID, long uItemCount, long uItemTime, int iItemType) {
		this.iItemID = iItemID;
		this.uItemCount = uItemCount;
		this.uItemTime = uItemTime;
		this.iItemType = iItemType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iItemID);
		result = prime * result + TarsUtil.hashCode(uItemCount);
		result = prime * result + TarsUtil.hashCode(uItemTime);
		result = prime * result + TarsUtil.hashCode(iItemType);
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
		if (!(obj instanceof TItemParam)) {
			return false;
		}
		TItemParam other = (TItemParam) obj;
		return (
			TarsUtil.equals(iItemID, other.iItemID) &&
			TarsUtil.equals(uItemCount, other.uItemCount) &&
			TarsUtil.equals(uItemTime, other.uItemTime) &&
			TarsUtil.equals(iItemType, other.iItemType) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iItemID, 0);
		_os.write(uItemCount, 1);
		_os.write(uItemTime, 2);
		_os.write(iItemType, 3);
	}


	public void readFrom(TarsInputStream _is) {
		this.iItemID = _is.read(iItemID, 0, false);
		this.uItemCount = _is.read(uItemCount, 1, false);
		this.uItemTime = _is.read(uItemTime, 2, false);
		this.iItemType = _is.read(iItemType, 3, false);
	}

}
