package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.BookList;

public class HelperBookList {
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("BookList");
	/**
	 * insertNewBookList - add new book_list to database
	 * @param bl
	 */
	public void insertNewBookList(BookList bl) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(bl);
		//em.persist(bl);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * updateBookList - update book_list in database
	 * @param toEdit
	 */
	public void updateBookList(BookList toEdit) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * deleteBookList - remove book_list from database
	 * @param toDelete
	 */
	public void deleteBookList(BookList toDelete) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookList> query = em.createQuery("select b from BookList b where b.id = :selectedId", BookList.class);
		query.setParameter("selectedId", toDelete.getId());
		query.setMaxResults(1);
		BookList result = query.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * searchById - find BookList using id
	 * @param idToFind
	 * @return found
	 */
	public BookList searchById(int idToFind) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		BookList found = em.find(BookList.class, idToFind);
		em.close();
		return found;
	}
	/**
	 * getAllBookLists
	 * @return allBookLists
	 */
	public List<BookList> getAllBookLists(){
		EntityManager em = emFactory.createEntityManager();
		TypedQuery<BookList> query = em.createQuery("select bl from BookList bl", BookList.class);
		List<BookList> allBookLists = query.getResultList();
		return allBookLists;
	}
	
	
	
	
}
