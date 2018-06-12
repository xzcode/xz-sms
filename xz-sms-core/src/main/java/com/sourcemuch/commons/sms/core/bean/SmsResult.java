package com.sourcemuch.commons.sms.core.bean;

/**
 * 容联信息返回数据
 * @author wulizhou
 *
 */
public class SmsResult {
	
	public final static String STATUS_CODE = "statusCode";
	
	public class CodeStatus{
		// 成功
		public final static String SUCCESS = "000000";
		// 发送失败
		public final static String FAILD = "000001";
		// 手机格式不符合
		public final static String FAILD_NUMBER = "000002";
		// 超过最大发送次数
		public final static String MORE_MAX_THAN_SEND = "160040";
	}

}
