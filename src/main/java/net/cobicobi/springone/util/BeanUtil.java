package net.cobicobi.springone.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtil implements BeanFactoryAware{

	private static BeanFactory beanFactory;
	
	public static BeanFactory getBeanFactory(){
		return beanFactory;
	}
	
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		BeanUtil.beanFactory = beanFactory;
	}
}
