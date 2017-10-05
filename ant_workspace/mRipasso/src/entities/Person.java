package entities;

import java.util.ArrayList;

public class Person {
	
	private int id;
	private String name;
	private int age;
	private String profession;
	private ArrayList<Hobby> hobbies;
	
	public Person(){}
	
	public Person(String name, int age, String profession, ArrayList<Hobby> hobbies) {
		this.name = name;
		this.age = age;
		this.profession = profession;
		this.hobbies = hobbies;
	}
	
	public Person(int id, String name, int age, String profession, ArrayList<Hobby> hobbies) {
		this.id = id;
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
	public int getId() {
		return id;
	}
	public Person setId(int id) {
		this.id = id;
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
	public ArrayList<Hobby> getHobbies() {
		return hobbies;
	}
	public Person setHobbies(ArrayList<Hobby> hobbies) {
		this.hobbies = hobbies;
		return this;
	}
	/*
	public String toJSON() // quando ancora hobbies era un ArrayList<String>
	{
		String s = "{";
		s += "'name':'" + this.name + "',";
		s += "'age':" + this.age + ",";
		s += "'profession':'" + this.profession + "',";
		s += "'hobbies':{";
		
		for(String h:this.hobbies)
			s += "'" + h + "',";
		
		s = s.substring(0,s.length()-1) + "}}";
		s = s.replaceAll("'", "\""); // cambia apostrofo in backslash escapato
		
		return s;
	}
	*/
	
	public String toJSON()
	{
		String s = "{";
		s += "'id':" + this.id + ",";
		s += "'name':'" + this.name + "',";
		s += "'age':" + this.age + ",";
		s += "'profession':'" + this.profession + "',";
		s += "'hobbies':[";
		
		for(Hobby h:this.hobbies)
			s += h.toJSON() + ",";
		
		if(hobbies.size() > 0)
			s = s.substring(0,s.length()-1);
		
		s += "]}";
		s = s.replace("'", "\""); // cambia apostrofo in backslash escapato
		
		return s;
	}
	
}
