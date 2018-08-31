package treemap;


public class TreeMapTest {
	
	public static void main( String args[] ){
	
		TreeMap<Long, Long> tm = new TreeMap<Long, Long>();
		Long four = new Long(4);
		Long three = new Long(3);
		Long two = new Long(2);
		Long one = new Long(1);
		

		tm.put(four,four);

		tm.put(three,three);

		tm.put(two,two);
		
		tm.put(one,one);
	}
	
}
