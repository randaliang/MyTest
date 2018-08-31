package juc.reetrantlock;

import java.util.concurrent.CyclicBarrier;


public class ReenLockTest {

	 private static MyLock cyclicBarrier= new MyLock();;

	 static long i = 8000;
	    static class CyclicBarrierThread extends Thread{
	        public void run() {
	            System.out.println(Thread.currentThread().getName() + "到了");
	            //等待
	            try {
	            	i=i-1000;
	                cyclicBarrier.await(false,i);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public static void main(String[] args){
	    	ReenLockTest rlt = new ReenLockTest();
	        for(int i = 0 ; i < 5 ; i++){
	            new CyclicBarrierThread().start();
	        }
	    }
	
}
