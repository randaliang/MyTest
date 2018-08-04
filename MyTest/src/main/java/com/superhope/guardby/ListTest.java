package com.superhope.guardby;

import java.util.ArrayList;
import java.util.List;

public class ListTest {


	public static void main( String args[] ){
		List<String> list = null;
		ListTest lt = new ListTest();
		lt.test(list);
		list.add("1");
		list.add("2");
		System.out.println(list.size());
		
	}
	    
	public void test( List<String>  list ){
		if( list == null ){
			list = new ArrayList<String>();
		}
		list.add("1");
		list.add("2");
	}
	

    private  class Pair<T> {
        final T reference;
        final int stamp;
        private Pair(T reference, int stamp) {
            this.reference = reference;
            this.stamp = stamp;
        }
    
    }

	   
}
