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
public class TMailList {

	@TarsStructProperty(order = 0, isRequire = false)
	public java.util.List<TMailItem> vecMailItem = null;

	public java.util.List<TMailItem> getVecMailItem() {
		return vecMailItem;
	}

	public void setVecMailItem(java.util.List<TMailItem> vecMailItem) {
		this.vecMailItem = vecMailItem;
	}

	public TMailList() {
	}

	public TMailList(java.util.List<TMailItem> vecMailItem) {
		this.vecMailItem = vecMailItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(vecMailItem);
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
		if (!(obj instanceof TMailList)) {
			return false;
		}
		TMailList other = (TMailList) obj;
		return (
			TarsUtil.equals(vecMailItem, other.vecMailItem) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != vecMailItem) {
			_os.write(vecMailItem, 0);
		}
	}

	static java.util.List<TMailItem> cache_vecMailItem;
	static { 
		cache_vecMailItem = new java.util.ArrayList<TMailItem>();
		TMailItem var_48 = new TMailItem();
		cache_vecMailItem.add(var_48);
	}

	public void readFrom(TarsInputStream _is) {
		this.vecMailItem = (java.util.List<TMailItem>) _is.read(cache_vecMailItem, 0, false);
	}

}
