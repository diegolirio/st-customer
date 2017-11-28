package com.diegolirio.st.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

@EnableCaching
@Configuration
public class SpringCacheConfig {

	@Bean 
	public CacheManager cacheManager() {
		CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder()
				.maximumSize(2000)
				.expireAfterAccess(30l, TimeUnit.DAYS);
		GuavaCacheManager gcm = new GuavaCacheManager();
		gcm.setCacheBuilder(builder);
		return gcm;
		//return new ConcurrentMapCacheManager();
	}
	
}
