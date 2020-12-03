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
public class TCatPropDialogueData {

	@TarsStructProperty(order = 0, isRequire = false)
	public int idialogueid = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public long ulastplaytime = 0;
	@TarsStructProperty(order = 2, isRequire = false)
	public short ushfreecount = (short)0;
	@TarsStructProperty(order = 3, isRequire = false)
	public short ushpaycount = (short)0;
	@TarsStructProperty(order = 4, isRequire = false)
	public int ilastattrvalue = 0;
	@TarsStructProperty(order = 5, isRequire = false)
	public short iattrtype = 0;
	@TarsStructProperty(order = 6, isRequire = false)
	public boolean bpasscheckpoint = false;

	public int getIdialogueid() {
		return idialogueid;
	}

	public void setIdialogueid(int idialogueid) {
		this.idialogueid = idialogueid;
	}

	public long getUlastplaytime() {
		return ulastplaytime;
	}

	public void setUlastplaytime(long ulastplaytime) {
		this.ulastplaytime = ulastplaytime;
	}

	public short getUshfreecount() {
		return ushfreecount;
	}

	public void setUshfreecount(short ushfreecount) {
		this.ushfreecount = ushfreecount;
	}

	public short getUshpaycount() {
		return ushpaycount;
	}

	public void setUshpaycount(short ushpaycount) {
		this.ushpaycount = ushpaycount;
	}

	public int getIlastattrvalue() {
		return ilastattrvalue;
	}

	public void setIlastattrvalue(int ilastattrvalue) {
		this.ilastattrvalue = ilastattrvalue;
	}

	public short getIattrtype() {
		return iattrtype;
	}

	public void setIattrtype(short iattrtype) {
		this.iattrtype = iattrtype;
	}

	public boolean getBpasscheckpoint() {
		return bpasscheckpoint;
	}

	public void setBpasscheckpoint(boolean bpasscheckpoint) {
		this.bpasscheckpoint = bpasscheckpoint;
	}

	public TCatPropDialogueData() {
	}

	public TCatPropDialogueData(int idialogueid, long ulastplaytime, short ushfreecount, short ushpaycount, int ilastattrvalue, short iattrtype, boolean bpasscheckpoint) {
		this.idialogueid = idialogueid;
		this.ulastplaytime = ulastplaytime;
		this.ushfreecount = ushfreecount;
		this.ushpaycount = ushpaycount;
		this.ilastattrvalue = ilastattrvalue;
		this.iattrtype = iattrtype;
		this.bpasscheckpoint = bpasscheckpoint;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(idialogueid);
		result = prime * result + TarsUtil.hashCode(ulastplaytime);
		result = prime * result + TarsUtil.hashCode(ushfreecount);
		result = prime * result + TarsUtil.hashCode(ushpaycount);
		result = prime * result + TarsUtil.hashCode(ilastattrvalue);
		result = prime * result + TarsUtil.hashCode(iattrtype);
		result = prime * result + TarsUtil.hashCode(bpasscheckpoint);
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
		if (!(obj instanceof TCatPropDialogueData)) {
			return false;
		}
		TCatPropDialogueData other = (TCatPropDialogueData) obj;
		return (
			TarsUtil.equals(idialogueid, other.idialogueid) &&
			TarsUtil.equals(ulastplaytime, other.ulastplaytime) &&
			TarsUtil.equals(ushfreecount, other.ushfreecount) &&
			TarsUtil.equals(ushpaycount, other.ushpaycount) &&
			TarsUtil.equals(ilastattrvalue, other.ilastattrvalue) &&
			TarsUtil.equals(iattrtype, other.iattrtype) &&
			TarsUtil.equals(bpasscheckpoint, other.bpasscheckpoint) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(idialogueid, 0);
		_os.write(ulastplaytime, 1);
		_os.write(ushfreecount, 2);
		_os.write(ushpaycount, 3);
		_os.write(ilastattrvalue, 4);
		_os.write(iattrtype, 5);
		_os.write(bpasscheckpoint, 6);
	}


	public void readFrom(TarsInputStream _is) {
		this.idialogueid = _is.read(idialogueid, 0, false);
		this.ulastplaytime = _is.read(ulastplaytime, 1, false);
		this.ushfreecount = _is.read(ushfreecount, 2, false);
		this.ushpaycount = _is.read(ushpaycount, 3, false);
		this.ilastattrvalue = _is.read(ilastattrvalue, 4, false);
		this.iattrtype = _is.read(iattrtype, 5, false);
		this.bpasscheckpoint = _is.read(bpasscheckpoint, 6, false);
	}

}
