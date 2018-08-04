package jdk8.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Person {

	@Getter
	private String firstName;
	@Getter
	private String lastName;
	@Getter
	private int age;

	public String toJson() {
		return "{" + "firstName:\"" + firstName + "\"," + "lastName:\"" + lastName + "\"," + "age:" + age + "}";
	}
	
	public Person(){
	}
	
	 public String toString() {
		 return toJson();
	 }
}
