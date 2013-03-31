package com.enation.framework.cache;

import java.io.Serializable;
import java.util.Collections;

import net.sf.jsr107cache.*;
//import net.sf.ehcache.CacheException;
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Element;

 
/**
 * Ehcache缓存实现
 * @author kingapex
 *
 */
public class EhCacheImpl  implements ICache{

	private Cache cache;

	/**
	 * 
	 */
	public EhCacheImpl(String name){
		System.out.println("EhCacheImpl_EhCacheImpl_s:"+name);
        try {
        	
        	System.out.println("EhCacheImpl_EhCacheImpl_1");
            CacheManager manager = CacheManager.getInstance();
            System.out.println("EhCacheImpl_EhCacheImpl_2");
            cache = manager.getCache(name);
            System.out.println("EhCacheImpl_EhCacheImpl_3");
            
            if (cache == null) {
            	System.out.println("EhCacheImpl_EhCacheImpl_4");
                manager.registerCache(name,  CacheManager.getInstance().getCacheFactory().createCache(Collections.emptyMap()));
                System.out.println("EhCacheImpl_EhCacheImpl_5");
                cache = manager.getCache(name);
                System.out.println("EhCacheImpl_EhCacheImpl_6");
            }
        } catch (CacheException e) {
        	System.out.println(e.toString());
        	e.printStackTrace();
        }
        if(cache == null){
        	System.out.println("Cache is null:"+name);
        }
        System.out.println("EhCacheImpl_EhCacheImpl_7");
	}


    /**
     * Gets a value of an element which matches the given key.
     * @param key the key of the element to return.
     * @return The value placed into the cache with an earlier put, or null if not found or expired
     * @throws CacheException
     */
    public Object get(Object key){
    	
    	Object obj = null;
    	if (key!= null && cache.containsKey(key)) {
        	obj = cache.get(key);
    	}
        return obj;
    }


    /**
     * Puts an object into the cache.
     * @param key a {@link Serializable} key
     * @param value a {@link Serializable} value
     * @throws CacheException if the parameters are not {@link Serializable}, the {@link CacheManager}
     * is shutdown or another {@link Exception} occurs.
     */
    public void put(Object key, Object value){
        try {
        	cache.put((Serializable)key, (Serializable)value);
//            Element element = new Element((Serializable) key, (Serializable) value);            
//            cache.put(element);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes the element which matches the key.
     * <p>
     * If no element matches, nothing is removed and no Exception is thrown.
     * @param key the key of the element to remove
     * @throws CacheException
     */
    public void remove(Object key){
        try {
            cache.remove((Serializable) key);
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
        	e.printStackTrace();
        }
    }

    /**
     * Remove all elements in the cache, but leave the cache
     * in a useable state.
     * @throws CacheException
     */
    public void clear(){
        try {
        	//cache.remove(arg0)
            //cache.removeAll();
        	cache.clear();
        } catch (IllegalStateException e) {
        	e.printStackTrace();
        } 
    }

    public static void main(String[] args){
    	EhCacheImpl cache = new EhCacheImpl("queryCache");
//    	cache.put("test","fjdkafjsdkajd");
    	System.out.println(cache.get("test"));
	}
	
}
