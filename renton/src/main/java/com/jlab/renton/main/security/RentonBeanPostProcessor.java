package com.jlab.renton.main.security;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

@Component
public class RentonBeanPostProcessor implements BeanPostProcessor {

	@Resource(name = "filterInvocationSecurityMetadataSource")
	private FilterInvocationSecurityMetadataSource metadataSource;
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof FilterInvocationSecurityMetadataSource) {
			return metadataSource;
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
