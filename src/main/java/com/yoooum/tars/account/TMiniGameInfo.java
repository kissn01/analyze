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
public class TMiniGameInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public java.util.List<TStoryGameDb> vstorygamedb = null;

	public java.util.List<TStoryGameDb> getVstorygamedb() {
		return vstorygamedb;
	}

	public void setVstorygamedb(java.util.List<TStoryGameDb> vstorygamedb) {
		this.vstorygamedb = vstorygamedb;
	}

	public TMiniGameInfo() {
	}

	public TMiniGameInfo(java.util.List<TStoryGameDb> vstorygamedb) {
		this.vstorygamedb = vstorygamedb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(vstorygamedb);
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
		if (!(obj instanceof TMiniGameInfo)) {
			return false;
		}
		TMiniGameInfo other = (TMiniGameInfo) obj;
		return (
			TarsUtil.equals(vstorygamedb, other.vstorygamedb) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != vstorygamedb) {
			_os.write(vstorygamedb, 0);
		}
	}

	static java.util.List<TStoryGameDb> cache_vstorygamedb;
	static { 
		cache_vstorygamedb = new java.util.ArrayList<TStoryGameDb>();
		TStoryGameDb var_51 = new TStoryGameDb();
		cache_vstorygamedb.add(var_51);
	}

	public void readFrom(TarsInputStream _is) {
		this.vstorygamedb = (java.util.List<TStoryGameDb>) _is.read(cache_vstorygamedb, 0, false);
	}

}
