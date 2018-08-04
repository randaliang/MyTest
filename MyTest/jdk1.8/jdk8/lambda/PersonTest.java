package jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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
		
		System.out.println("------------------------------------------------------------------------");
		
	    Function<String,String> function = (x) -> {System.out.print(x+": ");return "Function";};  
        System.out.println(function.apply("hello world"));  
          
        //Predicate<T> -T作为输入，返回的boolean值作为输出   
        Predicate<String> pre = (x) ->{System.out.print(x);return false;};  
        System.out.println(": "+pre.test("hello World"));  
          
        //Consumer<T> - T作为输入，执行某种动作但没有返回值   
        Consumer<String> con = (x) -> {System.out.println(x);};  
        con.accept("hello world");  
          
        //Supplier<T> - 没有任何输入，返回T   
        Supplier<String> supp = () -> {return "Supplier";};  
        System.out.println(supp.get());  
          
        //BinaryOperator<T> -两个T作为输入，返回一个T作为输出，对于“reduce”操作很有用   
        BinaryOperator<String> bina = (x,y) ->{System.out.print(x+" "+y);return "BinaryOperator";};  
        System.out.println("  "+bina.apply("hello ","world"));  

    	System.out.println("-optional-----------------------------------------------------------------------");
    	
    	Optional<Person> op = Optional.ofNullable(list.get(0));
    	op.ifPresent(System.out::println);
    	op.orElse(list.get(1));
    	op.orElseGet(Person::new);
    	String s = op.map(p->p.getLastName()).map(name->name.toUpperCase()).orElse(null);
    	System.out.println("-optional-----------------------------------------------------------------------" +s);
	}
}
