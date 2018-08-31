package juc.reetrantlock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {
	final ReentrantLock lock = new ReentrantLock(false);
 final Condition trip = lock.newCondition();
	
	 
    public int await(boolean timed, long nanos) {
         
            lock.lock();
            try {
            	System.out.println("begin"+nanos);
            	Random r = new Random();
            	trip.await();
            	Thread.currentThread().sleep(nanos);
				System.out.println("end"+nanos);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            lock.unlock();
            return 0;
        }
	
}
