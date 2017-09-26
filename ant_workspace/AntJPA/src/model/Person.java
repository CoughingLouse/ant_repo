package model;

import java.io.Serializable;
import javax.persistence.*;

import sun.text.normalizer.Replaceable;

import java.util.Date;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date birth;

	private String name;

	private String profession;

	private String surname;

	public Person() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String toString()
	{
		String birthdate = getBirth().getDay() + "-" +
						getBirth().getMonth() + "-" +
						getBirth().getYear();
		String s = 
				"=======================\n" +
				"[name]\n[surname]\n[profession]\n[birth]\n" +
				"=======================";
		return s.replace("[name]", getName())
				.replace("[surname]", getSurname())
				.replace("[profession]",getProfession())
				.replace("[birth]", birthdate);
	}

}