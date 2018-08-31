package juc.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAllTest {

	public static void main( String args[] ){
		ExecutorService es = Executors.newFixedThreadPool(5);
		List<Ta> list = new ArrayList<Ta>();
		for( int i = 0; i < 10; i++ ){
			list.add(new Ta());
		}
		try {
			es.invokeAll(list);
			es.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("333");
	}
}

class Ta implements Callable<Boolean>{

	@Override
	public Boolean call() throws Exception {
		System.out.println("begin");
		Thread.currentThread().sleep(2000L);
		System.out.println("end");
		return Boolean.TRUE;
	}
	
}
