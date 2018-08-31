package juc;

public class EqualTest {

	public static void main( String args[] ){

		int a = 0;
		int b = 0;
		System.out.println( a != ( a = 2 ) );
		
	}
}
