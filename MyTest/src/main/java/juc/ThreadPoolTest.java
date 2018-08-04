package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	 static ExecutorService es = null;
	
	static{
		es = Executors.newFixedThreadPool(5);
	}
	
	
	public static void main( String args[] ){
		
		for( int i = 0; i < 20;i++ ){
			TestThread t = new TestThread(i);
			es.submit( t );
		}
		try {
			new Thread(){
				public void run(){
					try {
						sleep(3000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					es.shutdown();
					System.out.println("shut down!");
				}
			}.start();
			es.awaitTermination(20, TimeUnit.SECONDS);
			System.out.println("finish");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

class TestThread implements Runnable{

	private int i ;
	
	public TestThread(int i ){
		this.i = i;
	}
	
	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(1000L);
			System.out.println("线程finish--" + i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
