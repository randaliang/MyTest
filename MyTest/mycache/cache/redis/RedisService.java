package cache.redis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cache.didispace.domain.User;

@Service
@CacheConfig(cacheNames = {"RedisService"})
public class RedisService  {

	private Map<String,String> map = new HashMap();
	
	@Cacheable(key = "#root.methodName+#objectCode")
	public String loadBankByBankId(String objectCode){
		return objectCode;
	}
	

}
