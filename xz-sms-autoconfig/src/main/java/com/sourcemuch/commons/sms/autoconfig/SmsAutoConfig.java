package com.sourcemuch.commons.sms.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.sourcemuch.commons.sms.core.ISmsService;
import com.sourcemuch.commons.sms.core.config.RongLianSMSConfig;
import com.sourcemuch.commons.sms.core.impl.SmsService;

@Configuration
@ConditionalOnProperty(prefix = "sourcemuch.commons.sms", name="enabled", havingValue = "true")
@ConditionalOnMissingBean({ISmsService.class})
public class SmsAutoConfig {
	

	@Bean
	public ISmsService smsService() {
		ISmsService smsService = new SmsService();
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		RongLianSMSConfig rongLianSMSConfig = rongLianSMSConfig();
		// 初始化服务器地址和端口
		restAPI.init(rongLianSMSConfig.getUrl(), rongLianSMSConfig.getPort());
		restAPI.setAccount(rongLianSMSConfig.getAccountSid(), rongLianSMSConfig.getAccountToken());
		restAPI.setAppId(rongLianSMSConfig.getAppId());
		smsService.setRestAPI(restAPI);
		return smsService;
	}
	
	@Bean
	@ConfigurationProperties(prefix = "sourcemuch.commons.sms")
	public RongLianSMSConfig rongLianSMSConfig() {
		return new RongLianSMSConfig();
	}

}
