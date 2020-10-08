package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reader")
public class BookReader {
	/**
	 * variables id, name
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reader_id")
	private int id;
	@Column(name="reader_name")
	private String name;
	/**
	 * default constructor no arguments
	 */
	public BookReader() {
		super();
	}
	/**
	 * constructor with all variable arguments
	 * @param id
	 * @param name
	 */
	public BookReader(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * constructor with only name argument
	 * @param name
	 */
	public BookReader(String name) {
		super();
		this.name = name;
	}
	/**
	 * getId
	 * @return id
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
	 * getName
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * setName
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
