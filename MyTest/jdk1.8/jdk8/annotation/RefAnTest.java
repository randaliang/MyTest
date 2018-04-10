/**
 * 
 */
package jdk8.annotation;

import java.lang.reflect.AnnotatedType;

import org.junit.Test;

/**
 * @author randaliang
 *
 */
public class RefAnTest {
	@Test
	public void test(){
		AnnotatedType[] a = Apple.class.getAnnotatedInterfaces();
		System.out.println( "annotation size" + a.length );
	}
	
}
