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
public class TRoleEventInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public long ulasttrigtime = 0L;
	@TarsStructProperty(order = 1, isRequire = false)
	public short shonlinecomputetime = (short)0;
	@TarsStructProperty(order = 2, isRequire = false)
	public long utimerangetrigtime = 0L;
	@TarsStructProperty(order = 3, isRequire = false)
	public long ulastlogintrigtime = 0L;
	@TarsStructProperty(order = 4, isRequire = false)
	public short shlogintrigcount = (short)0;
	@TarsStructProperty(order = 5, isRequire = false)
	public int iaccumuonlinetime = 0;
	@TarsStructProperty(order = 6, isRequire = false)
	public long ulastcalculateonlinetime = 0L;
	@TarsStructProperty(order = 7, isRequire = false)
	public java.util.List<TTriggerOnlineTime> veconlinetrigtime = null;
	@TarsStructProperty(order = 8, isRequire = false)
	public java.util.List<TTriggerTimeRange> vectimerange = null;
	@TarsStructProperty(order = 9, isRequire = false)
	public TRoleCommEvent stcommevent = null;
	@TarsStructProperty(order = 10, isRequire = false)
	public TRoleStoryEvent ststoryevent = null;
	@TarsStructProperty(order = 11, isRequire = false)
	public TRoleSpecailEvent stspecailevent = null;

	public long getUlasttrigtime() {
		return ulasttrigtime;
	}

	public void setUlasttrigtime(long ulasttrigtime) {
		this.ulasttrigtime = ulasttrigtime;
	}

	public short getShonlinecomputetime() {
		return shonlinecomputetime;
	}

	public void setShonlinecomputetime(short shonlinecomputetime) {
		this.shonlinecomputetime = shonlinecomputetime;
	}

	public long getUtimerangetrigtime() {
		return utimerangetrigtime;
	}

	public void setUtimerangetrigtime(long utimerangetrigtime) {
		this.utimerangetrigtime = utimerangetrigtime;
	}

	public long getUlastlogintrigtime() {
		return ulastlogintrigtime;
	}

	public void setUlastlogintrigtime(long ulastlogintrigtime) {
		this.ulastlogintrigtime = ulastlogintrigtime;
	}

	public short getShlogintrigcount() {
		return shlogintrigcount;
	}

	public void setShlogintrigcount(short shlogintrigcount) {
		this.shlogintrigcount = shlogintrigcount;
	}

	public int getIaccumuonlinetime() {
		return iaccumuonlinetime;
	}

	public void setIaccumuonlinetime(int iaccumuonlinetime) {
		this.iaccumuonlinetime = iaccumuonlinetime;
	}

	public long getUlastcalculateonlinetime() {
		return ulastcalculateonlinetime;
	}

	public void setUlastcalculateonlinetime(long ulastcalculateonlinetime) {
		this.ulastcalculateonlinetime = ulastcalculateonlinetime;
	}

	public java.util.List<TTriggerOnlineTime> getVeconlinetrigtime() {
		return veconlinetrigtime;
	}

	public void setVeconlinetrigtime(java.util.List<TTriggerOnlineTime> veconlinetrigtime) {
		this.veconlinetrigtime = veconlinetrigtime;
	}

	public java.util.List<TTriggerTimeRange> getVectimerange() {
		return vectimerange;
	}

	public void setVectimerange(java.util.List<TTriggerTimeRange> vectimerange) {
		this.vectimerange = vectimerange;
	}

	public TRoleCommEvent getStcommevent() {
		return stcommevent;
	}

	public void setStcommevent(TRoleCommEvent stcommevent) {
		this.stcommevent = stcommevent;
	}

	public TRoleStoryEvent getStstoryevent() {
		return ststoryevent;
	}

	public void setStstoryevent(TRoleStoryEvent ststoryevent) {
		this.ststoryevent = ststoryevent;
	}

	public TRoleSpecailEvent getStspecailevent() {
		return stspecailevent;
	}

	public void setStspecailevent(TRoleSpecailEvent stspecailevent) {
		this.stspecailevent = stspecailevent;
	}

	public TRoleEventInfo() {
	}

	public TRoleEventInfo(long ulasttrigtime, short shonlinecomputetime, long utimerangetrigtime, long ulastlogintrigtime, short shlogintrigcount, int iaccumuonlinetime, long ulastcalculateonlinetime, java.util.List<TTriggerOnlineTime> veconlinetrigtime, java.util.List<TTriggerTimeRange> vectimerange, TRoleCommEvent stcommevent, TRoleStoryEvent ststoryevent, TRoleSpecailEvent stspecailevent) {
		this.ulasttrigtime = ulasttrigtime;
		this.shonlinecomputetime = shonlinecomputetime;
		this.utimerangetrigtime = utimerangetrigtime;
		this.ulastlogintrigtime = ulastlogintrigtime;
		this.shlogintrigcount = shlogintrigcount;
		this.iaccumuonlinetime = iaccumuonlinetime;
		this.ulastcalculateonlinetime = ulastcalculateonlinetime;
		this.veconlinetrigtime = veconlinetrigtime;
		this.vectimerange = vectimerange;
		this.stcommevent = stcommevent;
		this.ststoryevent = ststoryevent;
		this.stspecailevent = stspecailevent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(ulasttrigtime);
		result = prime * result + TarsUtil.hashCode(shonlinecomputetime);
		result = prime * result + TarsUtil.hashCode(utimerangetrigtime);
		result = prime * result + TarsUtil.hashCode(ulastlogintrigtime);
		result = prime * result + TarsUtil.hashCode(shlogintrigcount);
		result = prime * result + TarsUtil.hashCode(iaccumuonlinetime);
		result = prime * result + TarsUtil.hashCode(ulastcalculateonlinetime);
		result = prime * result + TarsUtil.hashCode(veconlinetrigtime);
		result = prime * result + TarsUtil.hashCode(vectimerange);
		result = prime * result + TarsUtil.hashCode(stcommevent);
		result = prime * result + TarsUtil.hashCode(ststoryevent);
		result = prime * result + TarsUtil.hashCode(stspecailevent);
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
		if (!(obj instanceof TRoleEventInfo)) {
			return false;
		}
		TRoleEventInfo other = (TRoleEventInfo) obj;
		return (
			TarsUtil.equals(ulasttrigtime, other.ulasttrigtime) &&
			TarsUtil.equals(shonlinecomputetime, other.shonlinecomputetime) &&
			TarsUtil.equals(utimerangetrigtime, other.utimerangetrigtime) &&
			TarsUtil.equals(ulastlogintrigtime, other.ulastlogintrigtime) &&
			TarsUtil.equals(shlogintrigcount, other.shlogintrigcount) &&
			TarsUtil.equals(iaccumuonlinetime, other.iaccumuonlinetime) &&
			TarsUtil.equals(ulastcalculateonlinetime, other.ulastcalculateonlinetime) &&
			TarsUtil.equals(veconlinetrigtime, other.veconlinetrigtime) &&
			TarsUtil.equals(vectimerange, other.vectimerange) &&
			TarsUtil.equals(stcommevent, other.stcommevent) &&
			TarsUtil.equals(ststoryevent, other.ststoryevent) &&
			TarsUtil.equals(stspecailevent, other.stspecailevent) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(ulasttrigtime, 0);
		_os.write(shonlinecomputetime, 1);
		_os.write(utimerangetrigtime, 2);
		_os.write(ulastlogintrigtime, 3);
		_os.write(shlogintrigcount, 4);
		_os.write(iaccumuonlinetime, 5);
		_os.write(ulastcalculateonlinetime, 6);
		if (null != veconlinetrigtime) {
			_os.write(veconlinetrigtime, 7);
		}
		if (null != vectimerange) {
			_os.write(vectimerange, 8);
		}
		if (null != stcommevent) {
			_os.write(stcommevent, 9);
		}
		if (null != ststoryevent) {
			_os.write(ststoryevent, 10);
		}
		if (null != stspecailevent) {
			_os.write(stspecailevent, 11);
		}
	}

	static java.util.List<TTriggerOnlineTime> cache_veconlinetrigtime;
	static { 
		cache_veconlinetrigtime = new java.util.ArrayList<TTriggerOnlineTime>();
		TTriggerOnlineTime var_61 = new TTriggerOnlineTime();
		cache_veconlinetrigtime.add(var_61);
	}
	static java.util.List<TTriggerTimeRange> cache_vectimerange;
	static { 
		cache_vectimerange = new java.util.ArrayList<TTriggerTimeRange>();
		TTriggerTimeRange var_62 = new TTriggerTimeRange();
		cache_vectimerange.add(var_62);
	}
	static TRoleCommEvent cache_stcommevent;
	static { 
		cache_stcommevent = new TRoleCommEvent();
	}
	static TRoleStoryEvent cache_ststoryevent;
	static { 
		cache_ststoryevent = new TRoleStoryEvent();
	}
	static TRoleSpecailEvent cache_stspecailevent;
	static { 
		cache_stspecailevent = new TRoleSpecailEvent();
	}

	public void readFrom(TarsInputStream _is) {
		this.ulasttrigtime = _is.read(ulasttrigtime, 0, false);
		this.shonlinecomputetime = _is.read(shonlinecomputetime, 1, false);
		this.utimerangetrigtime = _is.read(utimerangetrigtime, 2, false);
		this.ulastlogintrigtime = _is.read(ulastlogintrigtime, 3, false);
		this.shlogintrigcount = _is.read(shlogintrigcount, 4, false);
		this.iaccumuonlinetime = _is.read(iaccumuonlinetime, 5, false);
		this.ulastcalculateonlinetime = _is.read(ulastcalculateonlinetime, 6, false);
		this.veconlinetrigtime = (java.util.List<TTriggerOnlineTime>) _is.read(cache_veconlinetrigtime, 7, false);
		this.vectimerange = (java.util.List<TTriggerTimeRange>) _is.read(cache_vectimerange, 8, false);
		this.stcommevent = (TRoleCommEvent) _is.read(cache_stcommevent, 9, false);
		this.ststoryevent = (TRoleStoryEvent) _is.read(cache_ststoryevent, 10, false);
		this.stspecailevent = (TRoleSpecailEvent) _is.read(cache_stspecailevent, 11, false);
	}

}
