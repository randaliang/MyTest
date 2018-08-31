package reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftRefTest {

	public static void main( String args[] ){
		String str = "123";
		SoftReference<String> softRef = new SoftReference<String>( str );
		str = null;
		System.gc();
		System.out.println( softRef.get() );
		String abc = new String( "abc" );
		WeakReference<String> wRef = new WeakReference<String>(abc);
		abc = null;
		System.gc();
		System.out.println(wRef.get());
	}
}
