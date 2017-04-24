package com.study.ehcache._01config;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class ConfigByProgramming {

	public static void main(String[] args) {
		
		CacheManager cacheManager = CacheManagerBuilder
				.newCacheManagerBuilder()
				.withCache(
						// cache alias
						"preConfigured",
						// cache configuration
						CacheConfigurationBuilder.newCacheConfigurationBuilder(
								Long.class, String.class,
								ResourcePoolsBuilder.heap(10)))
				// 返回cacheManager实例
				.build();
		
		// 在使用cacheManager之前需要初始化
		cacheManager.init();

		// 检索cache对象
		Cache<Long, String> preConfigured = cacheManager.getCache(
				"preConfigured", Long.class, String.class);
		System.out.println(preConfigured);
		
		// 创建一个新的cache对象
		Cache<Long, String> myCache = cacheManager
				.createCache("myCache", CacheConfigurationBuilder
						.newCacheConfigurationBuilder(Long.class, String.class,
								ResourcePoolsBuilder.heap(10)));

		myCache.put(1L, "da one!");
		
		String value = myCache.get(1L);
		System.out.println(value);
		
		cacheManager.removeCache("preConfigured");

		cacheManager.close();
	}
}
