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
public class TDBGrowTaskGiftInfo {

	@TarsStructProperty(order = 0, isRequire = true)
	public int ilevel = 0;

	public int getIlevel() {
		return ilevel;
	}

	public void setIlevel(int ilevel) {
		this.ilevel = ilevel;
	}

	public TDBGrowTaskGiftInfo() {
	}

	public TDBGrowTaskGiftInfo(int ilevel) {
		this.ilevel = ilevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(ilevel);
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
		if (!(obj instanceof TDBGrowTaskGiftInfo)) {
			return false;
		}
		TDBGrowTaskGiftInfo other = (TDBGrowTaskGiftInfo) obj;
		return (
			TarsUtil.equals(ilevel, other.ilevel) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(ilevel, 0);
	}


	public void readFrom(TarsInputStream _is) {
		this.ilevel = _is.read(ilevel, 0, true);
	}

}
