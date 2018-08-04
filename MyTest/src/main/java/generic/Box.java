package generic;

public class Box<T> {

	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	
	public static void main( String args[] ){
		Box<Integer> b0 = new Box<Integer>();
		Box<String> b1 = new Box<String>();
		
	}
	
}
