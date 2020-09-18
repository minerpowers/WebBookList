/********************************
 * author: 	Ben Miner
 * class:	CIS 171 Java II
 * date:	September 2020
 * project:	BookList
 * class:	BookEntity
 ********************************/

package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class BookEntity {
	/****************************
	 * 	variables
	 ****************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="isbn10")
	private String isbn10;
	@Column(name="title")
	private String title;
	@Column(name="author_Fname")
	private String firstName;
	@Column(name="author_Lname")
	private String lastName;
	/****************************
	 * 	constructor no-arg
	 ****************************/
	public BookEntity() {
	}
	/****************************
	 * 	constructor w/-arg
	 ****************************/
	public BookEntity(String title, String firstName, String lastName, String isbn10) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isbn10 = isbn10;
	}
	/****************************
	 * setters & getters: title
	 ****************************/
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	/****************************
	 * setters & getters: firstName
	 ****************************/
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/****************************
	 * setters & getters: lastName
	 ****************************/
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/****************************
	 * setters & getters: isbn10
	 ****************************/
	public String getIsbn10() {
		return isbn10;
	}
	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}
	/****************************
	 * print
	 ****************************/
	public String print() {
		return "\""+this.title+"\" by "+this.firstName+" "+this.lastName+" isbn: "+this.isbn10;
	}
}
