package interfacetest;

public class InterfaceTest {

	public static void main( String args[] ){
		System.out.println(Test.i);
		Test t = ()->{ System.out.print("333"); };
		t.print();
		t.test2();
	}
}

interface Test{
	int i = 88;
	
	void test2();
	
	default void print(){
		System.out.println(i);
	}
}