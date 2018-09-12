package guava;

import com.google.common.base.Joiner;

public class ForTest {

	public static void main( String args[] ){
		
		String array[] = {"1","2","3","4"};
		String s = Joiner.on(",").skipNulls().join(array);
		System.out.println(s);
	}
	
}
