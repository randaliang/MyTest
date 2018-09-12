package cache.redis;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class}) 
public class SpringCacheTest {


	@Resource 
	private RedisService rs;
	@Test
	public void test() {
		rs.setObjectValue("111", "###");
		rs.setObjectValue("222", "###");
		rs.setObjectValue("333", "###");
		rs.getObjectValue("222");
		rs.getObjectValue("333");
		rs.getPkeyObjectValue("111");
		String s = rs.getObjectValue("111");
		String s1 = rs.getObjectValue("111");
		assertEquals(s, s1);
		rs.setObjectCacheValue("111", "222");
		assertEquals(rs.getObjectValue("111"), "222");
		
		
	}
	
	@Test
	public void generatortKeys() {
		rs.setObjectValue("111", "222");
		String s =rs.getObjectValue("111");
		s = rs.getMykeyObjectValue("111");
		System.out.println(s);
	}

}
