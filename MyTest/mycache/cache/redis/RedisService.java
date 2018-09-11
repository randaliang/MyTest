package cache.redis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cache.didispace.domain.User;

@Service
@CacheConfig(cacheNames = {"RedisService"})
public class RedisService  {

	private Map<String,String> map = new HashMap();
	
	@Cacheable( key = "'gap_borm_object'+#objectCode")
	public String getObjectValue(String objectCode){
		return map.get(objectCode);
	}
	
	@Cacheable( keyGenerator = "springCacheKeyGenerator")
	public String getMykeyObjectValue(String objectCode){
		return map.get(objectCode);
	}
	
	@Cacheable( key = "'p0'+#p0")
	public String getPkeyObjectValue(String objectCode){
		return map.get(objectCode);
	}
	
	@CachePut(key = "'gap_borm_object'+#objectCode")
	public void setObjectCacheValue( String objectCode, String value ){
		map.put(objectCode, value);
	}
	
	
	public void setObjectValue( String objectCode, String value ){
		map.put(objectCode, value);
	}

	
	@CacheEvict(allEntries=true)
	public void clear(){
		map.clear();
	}
}
