package jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonTest {
	static List<Person> list = Arrays.asList(
			new Person("Yixing","zhao",25),
			new Person("Yanggui","Li",30),
			new Person("Chao","Ma",29)
			);
	
	public static void main( String args[]){
		list.stream().filter(p->p.getLastName().length()>1).
			forEach(p->System.out.println(p.getLastName()));
		
		list.stream().filter(p->p.getLastName().length()>1).
		forEach(System.out::println);
		
		list.stream().map(Person::toJson);
		String json = list.stream().map(p->{
			return p.getFirstName() + " " +p.getLastName();
		}).collect(Collectors.joining(", ", "[", "]"));  
		System.out.println(json);
		
				
//		String json = Arrays.asList(list).stream().map(Person::toJson).collect(Collectors.joining(", ", "[", "]"));  
//		                System.out.println(json);  
		  
	}
}
