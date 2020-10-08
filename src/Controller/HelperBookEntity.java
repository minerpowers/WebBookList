/********************************
 * author: 	Ben Miner
 * class:	CIS 171 Java II
 * date:	September 2020
 * project:	BookList
 * class:	BookEntityHelper
 ********************************/

package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.BookEntity;
public class HelperBookEntity {
	/****************************
	 * 	declare an entityManagerFactory
	 ****************************/
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookList");
	/****************************
	 * 	searchByTitle
	 * 	arguments: String title
	 *  return:	List of BookEntity
	 ****************************/
	public BookEntity searchById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		BookEntity found = em.find(BookEntity.class, id);
		em.close();
		return found;
	}
	/****************************
	 * 	searchByTitle
	 * 	arguments: String title
	 *  return:	List of BookEntity
	 ****************************/
	public List<BookEntity> searchByTitle(String tilte) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		TypedQuery<BookEntity> typedQuery = em.createQuery("select b from BookEntity b where b.title =:selectedTitle", BookEntity.class); 
		typedQuery.setParameter("selectedTitle", tilte);
		List<BookEntity> foundItems = typedQuery.getResultList(); 
		em.close();
		return foundItems;
	}
	/****************************
	 * 	searchByLastName
	 * 	arguments: String lastName
	 * return:	List of BookEntity
	 ****************************/
	public List<BookEntity> searchByLastName(String lastName) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		TypedQuery<BookEntity> typedQuery = em.createQuery("select b from BookEntity b where b.lastName =:selectedLastName", BookEntity.class); 
		typedQuery.setParameter("selectedLastName", lastName);
		List<BookEntity> foundItems = typedQuery.getResultList(); 
		em.close();
		return foundItems;
	}
	/****************************
	 * 	checkIsbn
	 * 	arguments: String isbn
	 *  return: Boolean exists
	 ****************************/
	public boolean checkIsbn(String isbn) {
		boolean exists = false;
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		TypedQuery<BookEntity> query = em.createQuery("select b from BookEntity b where b.isbn10 = :selectedISBN", BookEntity.class); 
		query.setParameter("selectedISBN", isbn);
		if(!query.getResultList().isEmpty()) {
			exists = true;
		}
		em.close();
		return exists;
	}
	/****************************
	 * 	findIsbn
	 * 	arguments: String isbn
	 *  return: BookEntity book
	 ****************************/
	public BookEntity findIsbn(String isbn) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		TypedQuery<BookEntity> query = em.createQuery("select b from BookEntity b where b.isbn10 = :selectedISBN", BookEntity.class); 
		query.setParameter("selectedISBN", isbn);
		BookEntity book = query.getSingleResult();
		em.close();
		return book;
	}
	/****************************
	 * 	updateBook
	 * 	arguments: BookEntity toEdit
	 ****************************/
	public void updateBook(BookEntity toEdit) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		em.merge(toEdit); 
		em.getTransaction().commit(); 
		em.close();
	}
	/****************************
	 * 	deleteBook
	 * 	arguments: BookEntity toDelete
	 ****************************/
	public void deleteBook(BookEntity toDelete) {
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
		TypedQuery<BookEntity> query = em.createQuery("select b from BookEntity b where b.isbn10 = :selectedISBN", BookEntity.class);
		query.setParameter("selectedISBN", toDelete.getIsbn10());
		query.setMaxResults(1);
		BookEntity result = query.getSingleResult(); 
		em.remove(result);
		em.getTransaction().commit(); 
		em.close();
		}
	/****************************
	 * 	insertBook
	 * 	arguments: BookEntity toAdd
	 ****************************/
	public void insertBook(BookEntity toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	/****************************
	 * 	showAllBooks
	 *  arguments: none
	 *  return: List of BookEntity
	 ****************************/
	public List<BookEntity> showAllBooks() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<BookEntity> query = em.createQuery("SELECT i FROM BookEntity i", BookEntity.class);
		List<BookEntity> allBooks = query.getResultList();
		em.close();
		return allBooks;
	}
	/****************************
	 * 	cleanUp
	 ****************************/
	public void cleanUp(){ 
		emfactory.close();
	}
}
