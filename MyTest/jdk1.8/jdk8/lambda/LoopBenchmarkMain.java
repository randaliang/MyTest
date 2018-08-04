package jdk8.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;



public class LoopBenchmarkMain {
	final int size = 100000;
	List<Integer> integers = null;

	public static void main(String[] args) {
		LoopBenchmarkMain benchmark = new LoopBenchmarkMain();
		benchmark.setup();
		long begin = 0;
		long end = 0;
		
		
	
		begin = System.currentTimeMillis();
		System.out.println("iterator: " + benchmark.iteratorMaxInteger());
		end = System.currentTimeMillis();
		System.out.println("cost===" + (end-begin));

		begin = System.currentTimeMillis();
		System.out.println(":: max is: " + benchmark.forEachLoopMaxInteger());
		end = System.currentTimeMillis();
		System.out.println("cost===" + (end-begin));
		
		begin = System.currentTimeMillis();
		System.out.println("wrapper max is: " + benchmark.forEachLambdaMaxInteger());
		end = System.currentTimeMillis();
		System.out.println("cost===" + (end-begin));
		
		begin = System.currentTimeMillis();
		System.out.println("for max is: " + benchmark.forMaxInteger());
		end = System.currentTimeMillis();
		System.out.println("cost===" + (end-begin));
		
		
		begin = System.currentTimeMillis();
		System.out.println("parallelStreamMaxInteger max is: " + benchmark.parallelStreamMaxInteger());
		end = System.currentTimeMillis();
		System.out.println("cost===" + (end-begin));
		
		
		begin = System.currentTimeMillis();
		System.out.println("common stream max is: " + benchmark.streamMaxInteger());
		end = System.currentTimeMillis();
		System.out.println("cost===" + (end-begin));

		begin = System.currentTimeMillis();
		System.out.println("lamda compare max is: " + benchmark.lambdaMaxInteger());
		end = System.currentTimeMillis();
		System.out.println("cost===" + (end-begin));
		
		
		
	}
	
	public void setup() {
		integers = new ArrayList<Integer>(size);
		populate(integers);
	}

	public void populate(List<Integer> list) {
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			list.add(Integer.valueOf(random.nextInt(1000000)));
		}
	}

	//16
	public int iteratorMaxInteger() {
		int max = Integer.MIN_VALUE;
		for (Iterator<Integer> it = integers.iterator(); it.hasNext(); ) {
			max = Integer.max(max, it.next());
		}
		return max;
	}

	public int forEachLoopMaxInteger() {
		int max = Integer.MIN_VALUE;
		for (Integer n : integers) {
			max = Integer.max(max, n);
		}
		return max;
	}
	

	public int forEachLambdaMaxInteger() {
		final Wrapper wrapper = new Wrapper();
		wrapper.inner = Integer.MIN_VALUE;
		
		integers.forEach(i -> wrapper.inner = Integer.max(i.intValue(), wrapper.inner));
		return wrapper.inner;
	}
	
	public static class Wrapper {
		public int inner; 
	}
	

	public int forMaxInteger() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			max = Integer.max(max, integers.get(i).intValue());
		}
		return max;
	}

	public int forMax2Integer() {
		int max = Integer.MIN_VALUE;
		List<Integer> integersLocal = integers;
		for (int i = 0; i < size; i++) {
			max = Integer.max(max, integersLocal.get(i).intValue());
		}
		return max;
	}


	public int parallelStreamMaxInteger() {
		return integers.parallelStream().mapToInt(Integer::intValue).reduce(Integer.MIN_VALUE, Integer::max);
	}

	//0
	public int streamMaxInteger() {
		return integers.stream().mapToInt(Integer::intValue).reduce(Integer.MIN_VALUE, Integer::max);
	}

	public int lambdaMaxInteger() {
		return integers.stream().mapToInt(Integer::intValue).reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
	}
}