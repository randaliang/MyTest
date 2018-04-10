package jdk8.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

public class Lambda {

	public static void main( String args[] ){
//		//Java 8��ʽ��
		new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

		items.forEach((k,v)->{
		    System.out.println("Item : " + k + " Count : " + v);
		    if("E".equals(k)){
		        System.out.println("Hello E");
		    }
		});

		// Java 8֮��
		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		//features.forEach(n -> System.out.println(n));
		 
		// ʹ��Java 8�ķ������ø����㣬����������::˫ð�Ų�������ʾ��
		// ��������C++����������������
		features.forEach(System.out::println);
		
	}
	
	public void sort(){
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		names.forEach((action)->System.out.println(action));
		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});
	}
	public void sort8(){
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
	}
	
	public void sort8Sen(){
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (a, b) -> b.compareTo(a));
	}
	
	public void buttonTest(){
		// Java 8֮ǰ��
		JButton show =  new JButton("Show");
//		show.addMouseListener((e) -> {
//		    System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
//		});
		show.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    System.out.println("Event handling without lambda expression is boring");
		    }
		});
	
		// Java 8��ʽ��
		show.addActionListener((e) -> {
		    System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
		});
	}
	
	public void compare(){
//		List<String> list = new ArrayList<String>();
//		Collections.sort(list, c);
	}
}

class LT{
	
}

