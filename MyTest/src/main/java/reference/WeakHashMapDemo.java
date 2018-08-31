package reference;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main( String args[] ){
		String a = new String("a");
		String b = new String("b");
		Map weakMap = new WeakHashMap();
		Map map = new HashMap();
		weakMap.put(a, "aaaa");
		weakMap.put(b, "bbb");
		map.put(a, "aaaa");
		map.put(b, "bbb");
		map.remove(a);
		a = null;
		b = null;
		System.gc();
		Iterator i = map.entrySet().iterator();
		while( i.hasNext() ){
			Map.Entry en = (Map.Entry)i.next();
			System.out.println("map" + en.getKey() + ":" + en.getValue() );
		}
		

		Iterator j = weakMap.entrySet().iterator();
		while( j.hasNext() ){
			Map.Entry en = (Map.Entry)j.next();
			System.out.println("weakmap" + en.getKey() + ":" + en.getValue() );
		}
	}
	
}
