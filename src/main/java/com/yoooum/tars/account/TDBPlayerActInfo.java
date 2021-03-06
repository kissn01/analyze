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
public class TDBPlayerActInfo {

	@TarsStructProperty(order = 0, isRequire = true)
	public long lrefreshtime = 0L;

	public long getLrefreshtime() {
		return lrefreshtime;
	}

	public void setLrefreshtime(long lrefreshtime) {
		this.lrefreshtime = lrefreshtime;
	}

	public TDBPlayerActInfo() {
	}

	public TDBPlayerActInfo(long lrefreshtime) {
		this.lrefreshtime = lrefreshtime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(lrefreshtime);
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
		if (!(obj instanceof TDBPlayerActInfo)) {
			return false;
		}
		TDBPlayerActInfo other = (TDBPlayerActInfo) obj;
		return (
			TarsUtil.equals(lrefreshtime, other.lrefreshtime) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(lrefreshtime, 0);
	}


	public void readFrom(TarsInputStream _is) {
		this.lrefreshtime = _is.read(lrefreshtime, 0, true);
	}

}
