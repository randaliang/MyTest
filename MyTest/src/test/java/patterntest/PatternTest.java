package patterntest;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatternTest {

	@Test
	public void test() {
		String pattern = "\\d+\\.xls";
		assertTrue("123456.xls".matches(pattern));
		assertFalse("123456a.xls".matches(pattern));
		assertFalse("中国dd".matches(pattern));
		assertFalse("add".matches(pattern));
		assertFalse("1.xls33".matches(pattern));
	}

}
