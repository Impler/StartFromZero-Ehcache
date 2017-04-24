package com.study.ehcache._01config;

import java.net.URL;

import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.ehcache.xml.exceptions.XmlConfigurationException;

public class ConfigByXml {

	public static void main(String[] args) {
		try {
			URL url = ConfigByXml.class.getResource("/01config/ehcache.xml");
			XmlConfiguration configuration = new XmlConfiguration(url);
			CacheManagerBuilder.newCacheManager(configuration);
		} catch (XmlConfigurationException e) {
			e.printStackTrace();
		}
	}
}
