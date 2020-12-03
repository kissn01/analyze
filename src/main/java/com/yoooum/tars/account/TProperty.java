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
public class TProperty {

	@TarsStructProperty(order = 0, isRequire = false)
	public String sPropName = "";
	@TarsStructProperty(order = 1, isRequire = false)
	public float iPropValue = 0F;
	@TarsStructProperty(order = 2, isRequire = false)
	public int oper = 0;

	public String getSPropName() {
		return sPropName;
	}

	public void setSPropName(String sPropName) {
		this.sPropName = sPropName;
	}

	public float getIPropValue() {
		return iPropValue;
	}

	public void setIPropValue(float iPropValue) {
		this.iPropValue = iPropValue;
	}

	public int getOper() {
		return oper;
	}

	public void setOper(int oper) {
		this.oper = oper;
	}

	public TProperty() {
	}

	public TProperty(String sPropName, float iPropValue, int oper) {
		this.sPropName = sPropName;
		this.iPropValue = iPropValue;
		this.oper = oper;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(sPropName);
		result = prime * result + TarsUtil.hashCode(iPropValue);
		result = prime * result + TarsUtil.hashCode(oper);
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
		if (!(obj instanceof TProperty)) {
			return false;
		}
		TProperty other = (TProperty) obj;
		return (
			TarsUtil.equals(sPropName, other.sPropName) &&
			TarsUtil.equals(iPropValue, other.iPropValue) &&
			TarsUtil.equals(oper, other.oper) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != sPropName) {
			_os.write(sPropName, 0);
		}
		_os.write(iPropValue, 1);
		_os.write(oper, 2);
	}


	public void readFrom(TarsInputStream _is) {
		this.sPropName = _is.readString(0, false);
		this.iPropValue = _is.read(iPropValue, 1, false);
		this.oper = _is.read(oper, 2, false);
	}

}
