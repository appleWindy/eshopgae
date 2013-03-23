package com.enation.framework.cache;

import java.util.logging.Logger;



/**
 * 缓存代理抽象类
 * @author kingapex
 * <p>2009-12-16 下午05:19:50</p>
 * @version 1.0
 * @param <T>
 */
public abstract class AbstractCacheProxy<T> {
	protected final Logger logger = Logger.getLogger(AbstractCacheProxy.class.getName());

	protected ICache<T> cache;

	public AbstractCacheProxy(String cacheName) {
		cache = CacheFactory.getCache(cacheName);
	}
	
	
}
