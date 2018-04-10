package jdk8.func;

import java.util.function.Function;

public class FuncTest {

	public static void main( String args[] ){
		Function<Integer, String> fun = x -> String.valueOf(x);
		System.out.println( fun.apply(1));
		Function<String, Integer> f1 = (t) -> Integer.valueOf(t) * 10;  
		System.out.println(f1.apply("3"));  
		System.out.println(Function.identity().apply("3"));  
		System.out.println(f1.andThen((r) -> String.valueOf(r) + ".....").apply("4"));  
		System.out.println(f1.compose((String r) -> r.substring(1)).apply("a5"));  
	}
	
	
}
