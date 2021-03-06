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
public class TEightDiagramsItem {

	@TarsStructProperty(order = 0, isRequire = false)
	public int itaskid = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public short ntasklvl = 1;
	@TarsStructProperty(order = 2, isRequire = true)
	public short ntaskstate = (short)0;

	public int getItaskid() {
		return itaskid;
	}

	public void setItaskid(int itaskid) {
		this.itaskid = itaskid;
	}

	public short getNtasklvl() {
		return ntasklvl;
	}

	public void setNtasklvl(short ntasklvl) {
		this.ntasklvl = ntasklvl;
	}

	public short getNtaskstate() {
		return ntaskstate;
	}

	public void setNtaskstate(short ntaskstate) {
		this.ntaskstate = ntaskstate;
	}

	public TEightDiagramsItem() {
	}

	public TEightDiagramsItem(int itaskid, short ntasklvl, short ntaskstate) {
		this.itaskid = itaskid;
		this.ntasklvl = ntasklvl;
		this.ntaskstate = ntaskstate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(itaskid);
		result = prime * result + TarsUtil.hashCode(ntasklvl);
		result = prime * result + TarsUtil.hashCode(ntaskstate);
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
		if (!(obj instanceof TEightDiagramsItem)) {
			return false;
		}
		TEightDiagramsItem other = (TEightDiagramsItem) obj;
		return (
			TarsUtil.equals(itaskid, other.itaskid) &&
			TarsUtil.equals(ntasklvl, other.ntasklvl) &&
			TarsUtil.equals(ntaskstate, other.ntaskstate) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(itaskid, 0);
		_os.write(ntasklvl, 1);
		_os.write(ntaskstate, 2);
	}


	public void readFrom(TarsInputStream _is) {
		this.itaskid = _is.read(itaskid, 0, false);
		this.ntasklvl = _is.read(ntasklvl, 1, false);
		this.ntaskstate = _is.read(ntaskstate, 2, true);
	}

}
