package Controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.BookReader;

public class HelperBookReader {
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("BookList");
	/**
	 * insertBookReader - add a reader to the database
	 * @param r
	 */
	public void insertBookReader(BookReader r) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * findBookReader
	 * @param lookUpName
	 * @return foundReader
	 */
	public BookReader findBookReader(String lookUpName) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookReader> query = em.createQuery("select r from BookReader r where r.name = :nameEntered", BookReader.class);
		query.setParameter("nameEntered", lookUpName);
		query.setMaxResults(1);
		BookReader foundReader;
		try {
			foundReader = query.getSingleResult();
		} catch (NoResultException ex) {
			foundReader = new BookReader(lookUpName);
		}
		em.close();
		return foundReader;
	}
	public boolean booleanBookReader(String lookUpName) {
		boolean foundReader = true;
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookReader> query = em.createQuery("select r from BookReader r where r.name = :nameEntered", BookReader.class);
		query.setParameter("nameEntered", lookUpName);
		if (!query.getResultList().isEmpty()) {
			foundReader = false;
		}
		em.close();
		return foundReader;
	}
	/**
	 * showAllReaders
	 * @return allReaders
	 */
	public List<BookReader> showAllReaders(){
		EntityManager em = emFactory.createEntityManager();
		TypedQuery<BookReader> query = em.createQuery("select r from BookReader r", BookReader.class);
		List<BookReader> allReaders = query.getResultList();
		return allReaders;
	}
}
