package test;

import java.util.ArrayList;

import entities.Person;

public class Test {

	public static void main(String[] args) {
		
		Person p = new Person();
		p.setName("Pino").setAge(19).setProfession("Engineer");
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("arare");
		hobbies.add("baciare");
		hobbies.add("cercare");
		
//		p.setHobbies(hobbies);
//		System.out.println(p.toJSON());

	}

}
