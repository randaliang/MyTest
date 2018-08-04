package generic;

public class Method {
	
	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
	    int count = 0;
	    for (T e : anArray)
	        if (e.compareTo(elem) > 0)
	            ++count;
	    return count;
	}
	
	public static <A extends Comparable<A>> int countGreaterThan1(A[] anArray, A elem) {
	    int count = 0;
	    for (A e : anArray)
	        if (e.compareTo(elem) > 0)
	            ++count;
	    return count;
	}
}
