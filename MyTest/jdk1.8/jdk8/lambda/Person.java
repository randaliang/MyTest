package jdk8.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Person {


	@Getter
	@Setter
	private String firstName;
	@Getter
	@Setter
	private String lastName;
	@Getter
	@Setter
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
