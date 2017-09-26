package service;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Person;

public class MainScrittura {

	public static void main(String[] args)
	{
		EntityManagerFactory emfactory =
				Persistence.createEntityManagerFactory("AntJPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		
		entitymanager.getTransaction().begin();
		
		Person p = new Person();
		p.setName("Gerardo");
		p.setSurname("Scaralli");
		p.setProfession("Maniscalco");
		p.setBirth(new Date(107,00,01));
				
		entitymanager.persist(p);
		entitymanager.getTransaction().commit();
		
		System.out.println("Mission accomplished!");
		
		entitymanager.close();
		emfactory.close();

	}

}

