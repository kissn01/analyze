// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.commdata;

public enum E_TASK_TARGET_SUB_TYPE {

	E_TASK_TARGET_SUB_INVAILD(0);

	private final int value;

	private E_TASK_TARGET_SUB_TYPE(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static E_TASK_TARGET_SUB_TYPE convert(int value) {
		for(E_TASK_TARGET_SUB_TYPE v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
