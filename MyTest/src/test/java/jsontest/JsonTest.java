package jsontest;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import  net.sf.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hazelcast.com.eclipsesource.json.JsonObject;
import com.superhope.mvcconfig.CustomObjectMapper;

public class JsonTest {

	@Test
	public void test() {
		User u = new User();
		u.setbDate(new Date( System.currentTimeMillis() ));
		String s = JSONObject.fromObject(u).toString();
		System.out.println(s);
		
		CustomObjectMapper c = new CustomObjectMapper();
		try {
			s = c.writeValueAsString(u);
			System.out.println(s);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@Test
	public void test1() {
		User u = new User();
		u.setbDate(new Date( System.currentTimeMillis() ));
		
		CustomObjectMapper c = new CustomObjectMapper();
		try {
			String s = c.writeValueAsString(u);
			System.out.println(s);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
