package com.xzcode.sms.ronglian.core.impl;

import java.util.Map;

import javax.annotation.Resource;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.xzcode.sms.ronglian.core.ISmsRonglianService;
import com.xzcode.sms.ronglian.core.config.RongLianSMSConfig;


public class SmsRonglianService implements ISmsRonglianService{
	
	@Resource
	private RongLianSMSConfig rongLianSMSConfig;
	
	private CCPRestSmsSDK restAPI;
	
	@Override
	public Map<String, Object> sendSMS(String mobile, String templateCode, String[] smsParameter) {
		
		Map<String, Object> result = restAPI.sendTemplateSMS(mobile, templateCode,smsParameter);
		return result;
	}
	
	@Override
	public void setRestAPI(CCPRestSmsSDK restAPI) {
		this.restAPI = restAPI;
	}
	
	public CCPRestSmsSDK getRestAPI() {
		return restAPI;
	}

}
