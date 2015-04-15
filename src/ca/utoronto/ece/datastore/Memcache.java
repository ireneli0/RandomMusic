package ca.utoronto.ece.datastore;

import java.util.Collections;

import javax.cache.Cache;
import javax.cache.CacheException;
import javax.cache.CacheFactory;
import javax.cache.CacheManager;

public class Memcache {
	
	private Cache cache = null;
	public Memcache(){
		try{
			CacheFactory cacheFactory = CacheManager.getInstance().getCacheFactory();
			cache = cacheFactory.createCache(Collections.emptyMap());
		}catch (CacheException e){
			e.printStackTrace();
		}
	}
	public static Cache getCache(){
		Cache cache= null;
		try{
			CacheFactory cacheFactory = CacheManager.getInstance().getCacheFactory();
			cache = cacheFactory.createCache(Collections.emptyMap());
		}catch (CacheException e){
			e.printStackTrace();
		}
		return cache;
	}
	
}
