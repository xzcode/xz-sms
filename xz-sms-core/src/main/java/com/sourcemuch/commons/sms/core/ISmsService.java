package com.sourcemuch.commons.sms.core;

import java.util.Map;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

public interface ISmsService {
	/**
	 * 发送信息
	 */
	Map<String, Object> sendSMS(String mobile,String templateCode,String[] smsParameter);

	void setRestAPI(CCPRestSmsSDK restAPI);
}
