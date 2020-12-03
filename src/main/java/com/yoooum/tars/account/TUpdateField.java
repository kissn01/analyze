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
public class TUpdateField {

	@TarsStructProperty(order = 0, isRequire = true)
	public String sFieldName = "";
	@TarsStructProperty(order = 1, isRequire = true)
	public String sFieldValue = "";

	public String getSFieldName() {
		return sFieldName;
	}

	public void setSFieldName(String sFieldName) {
		this.sFieldName = sFieldName;
	}

	public String getSFieldValue() {
		return sFieldValue;
	}

	public void setSFieldValue(String sFieldValue) {
		this.sFieldValue = sFieldValue;
	}

	public TUpdateField() {
	}

	public TUpdateField(String sFieldName, String sFieldValue) {
		this.sFieldName = sFieldName;
		this.sFieldValue = sFieldValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(sFieldName);
		result = prime * result + TarsUtil.hashCode(sFieldValue);
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
		if (!(obj instanceof TUpdateField)) {
			return false;
		}
		TUpdateField other = (TUpdateField) obj;
		return (
			TarsUtil.equals(sFieldName, other.sFieldName) &&
			TarsUtil.equals(sFieldValue, other.sFieldValue) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(sFieldName, 0);
		_os.write(sFieldValue, 1);
	}


	public void readFrom(TarsInputStream _is) {
		this.sFieldName = _is.readString(0, true);
		this.sFieldValue = _is.readString(1, true);
	}

}