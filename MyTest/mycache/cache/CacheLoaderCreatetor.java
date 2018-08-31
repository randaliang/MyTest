package cache;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheLoaderCreatetor {

	public static CacheLoader<String, Employee> createNUllCacheLoader(){
		return new CacheLoader<String, Employee>(){

			@Override
			public Employee load(String key) throws Exception {
				return new Employee(key,null,null);
			}
			
		};
	}
	
	
	public static CacheLoader<String, Employee> createCacheLoader(){
		return new CacheLoader<String, Employee>(){

			@Override
			public Employee load(String key) throws Exception {
				return new Employee(key,null,null);
			}
			
		};
	}
}
