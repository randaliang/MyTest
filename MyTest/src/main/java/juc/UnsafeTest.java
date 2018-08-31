package juc;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

import sun.misc.Unsafe;

public class UnsafeTest {

	 private volatile int state;
	 private static final Unsafe unsafe = Unsafe.getUnsafe();
	 private static final long stateOffset;
	 static{
	      try {
			stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
			
		} catch (NoSuchFieldException e) {
			 throw new Error(e); 
		} catch (SecurityException e) {
			 throw new Error(e); 
		}
	 }
	 
	 
//	    static {
//	        try {
//	            stateOffset = unsafe.objectFieldOffset
//	                (UnsafeTest.class.getDeclaredField("state"));
//
//	        } catch (Exception ex) { throw new Error(ex); }
//	    }
	 
	   protected final boolean compareAndSetState(int expect, int update) {
	        // See below for intrinsics setup to support this
	        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
	        
	    }
	   
	   public void methods(){
//		   unsafe.compareAndSwapInt(arg0, arg1, arg2, arg3);
//		   unsafe.getAndSetInt(arg0, arg1, arg2);
	   }
}
