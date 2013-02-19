package com.itz.bus.info;

import jisp.base.AbstractInfo;
import jisp.base.DealerInfo;

public class UserInfo extends DealerInfo{
	
	private String userCode;

	/**
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
