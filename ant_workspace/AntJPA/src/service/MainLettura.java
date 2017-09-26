package service;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Person;

public class MainLettura {

	public static void main(String[] args)
	{
		EntityManagerFactory emfactory =
				Persistence.createEntityManagerFactory("AntJPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		
//		Person p = entitymanager.find(Person.class, 1);
//		System.out.println(p.toString());
		
		// prova all entities list
		List<Person> listPersons = entitymanager.createQuery(
	            "SELECT p FROM Person p").getResultList();
		
		// List<Person> listPersons2 = entityman)
		
		for(Person pers:listPersons)
		{
			System.out.println(pers.toString());
		}
		

	}

}
