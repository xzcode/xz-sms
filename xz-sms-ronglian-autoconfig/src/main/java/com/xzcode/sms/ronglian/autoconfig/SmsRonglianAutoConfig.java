package com.xzcode.sms.ronglian.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.xzcode.sms.ronglian.core.ISmsRonglianService;
import com.xzcode.sms.ronglian.core.config.RongLianSMSConfig;
import com.xzcode.sms.ronglian.core.impl.SmsRonglianService;

@Configuration
@ConditionalOnProperty(prefix = SmsRonglianAutoConfig.PROP_PREFIX, name="enabled", havingValue = "true")
@ConditionalOnMissingBean({ISmsRonglianService.class})
public class SmsRonglianAutoConfig {
	
	protected static final String PROP_PREFIX = "xz.sms.ronglian";

	@Bean
	public ISmsRonglianService smsRonglianService() {
		ISmsRonglianService smsRonglianService = new SmsRonglianService();
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		RongLianSMSConfig rongLianSMSConfig = rongLianSMSConfig();
		// 初始化服务器地址和端口
		restAPI.init(rongLianSMSConfig.getUrl(), rongLianSMSConfig.getPort());
		restAPI.setAccount(rongLianSMSConfig.getAccountSid(), rongLianSMSConfig.getAccountToken());
		restAPI.setAppId(rongLianSMSConfig.getAppId());
		smsRonglianService.setRestAPI(restAPI);
		return smsRonglianService;
	}
	
	@Bean
	@ConfigurationProperties(prefix = SmsRonglianAutoConfig.PROP_PREFIX)
	public RongLianSMSConfig rongLianSMSConfig() {
		return new RongLianSMSConfig();
	}

}
