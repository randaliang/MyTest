package juc.writereadlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

	public static void main( String args[] ){
		ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(true);
		rwl.writeLock();
	}
	
}
