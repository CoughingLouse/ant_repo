package entities;

import java.util.ArrayList;

public class Person {
	
	private String name;
	private int age;
	private String profession;
	private ArrayList<String> hobbies;
	
	public Person(){}
	
	public Person(String name, int age, String profession, ArrayList<String> hobbies) {
		this.name = name;
		this.age = age;
		this.profession = profession;
		this.hobbies = hobbies;
	}
	
	public String getName() {
		return name;
	}
	public Person setName(String name) {
		this.name = name;
		return this;
	}
	public int getAge() {
		return age;
	}
	public Person setAge(int age) {
		this.age = age;
		return this;
	}
	public String getProfession() {
		return profession;
	}
	public Person setProfession(String profession) {
		this.profession = profession;
		return this;
	}
	public ArrayList<String> getHobbies() {
		return hobbies;
	}
	public Person setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
		return this;
	}
	
}
