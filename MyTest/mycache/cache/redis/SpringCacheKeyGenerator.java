package cache.redis;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component //标记为组件
public class SpringCacheKeyGenerator implements KeyGenerator {

    private final static int NO_PARAM_KEY = 0;
    private String keyPrefix = "jf";// key前缀，用于区分不同项目的缓存，建议每个项目单独设置



    @Override
    public Object generate(Object target, Method method, Object... params) {
    	return "mykeygenerator";
    }



    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }
}
