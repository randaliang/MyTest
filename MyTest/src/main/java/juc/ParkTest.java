package juc;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {

	public static void main( String args[] ){
		ParkTest p = new ParkTest();
		System.out.println("begin");
		PThread pt = new PThread( p );
		pt.start();
		LockSupport.unpark(pt);
		System.out.println("end");
		
	}
}

class PThread extends Thread{
	Object blocker;
	public PThread( Object blocker ){
		this.blocker = blocker;
	}
	public void run(){
		System.out.println("PThread park");
		LockSupport.park( blocker );
		System.out.println("unpark park");
	}
}
