package Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="book_list")
public class BookList {
	/**
	 * variables
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="list_id")
	private int id;
	@Column(name="list_created")
	@Temporal(TemporalType.DATE)
	private Date created;
	@Column(name="list_name")
	private String listName;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="reader_id")
	private BookReader bookReader;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="books_on_list",
			joinColumns= {@JoinColumn(name="list_id", referencedColumnName="list_id")},
			inverseJoinColumns= {@JoinColumn(name="book_id", referencedColumnName="id", unique=true)})
	private List<BookEntity> listOfBooks;
	/**
	 * default constructor no arguments
	 */
	public BookList() {
		super();
	}
	/**
	 * Constructor with all variable arguments
	 * @param id
	 * @param listName
	 * @param bookReader
	 * @param listOfBooks
	 */
	public BookList(int id, String listName, BookReader bookReader, List<BookEntity> listOfBooks) {
		super();
		this.id = id;
		this.created = new Date();
		this.listName = listName;
		this.bookReader = bookReader;
		this.listOfBooks = listOfBooks;
	}
	/**
	 * Constructor with arguments listed
	 * @param listName
	 * @param bookReader
	 * @param listOfBooks
	 */
	public BookList(String listName, BookReader bookReader, List<BookEntity> listOfBooks) {
		super();
		this.created = new Date();
		this.listName = listName;
		this.bookReader = bookReader;
		this.listOfBooks = listOfBooks;
	}
	/**
	 * Constructor with arguments listed
	 * @param listName
	 * @param bookReader
	 */
	public BookList(String listName, BookReader bookReader) {
		super();
		this.created =new Date();
		this.listName = listName;
		this.bookReader = bookReader;
	}
	/**
	 * getId
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * setId
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * getCreated
	 * @return
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * setCreated
	 * @param created
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public BookReader getBookReader() {
		return bookReader;
	}
	public void setBookReader(BookReader bookReader) {
		this.bookReader = bookReader;
	}
	public List<BookEntity> getListOfBooks() {
		return listOfBooks;
	}
	public void setListOfBooks(List<BookEntity> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}
	
	
}
