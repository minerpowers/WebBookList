package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookEntity;
import Model.BookList;
import Model.BookReader;

/**
 * Servlet implementation class servletCreateNewList
 * author: 	Ben Miner
 * course:	CIS 171 Java II
 * date:	October 2020
 * project:	WebBookLists
 * file:	servletCreateNewList
 * objective:
 * 		process form information from new-book-list.jsp
 */
@WebServlet("/servletCreateNewList")
public class servletCreateNewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCreateNewList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * Model Helpers
		 */
		HelperBookEntity hbEntity = new HelperBookEntity();
		HelperBookReader hbReader = new HelperBookReader();
		HelperBookList hbList = new HelperBookList();
		/**
		 * create strings from input
		 */
		String listName = request.getParameter("listName");
		String bookReaderName = request.getParameter("bookReader");
		String[] selectedBooks = request.getParameterValues("allBooksToAdd");
		List<BookEntity> addSelectedBooks = new ArrayList<BookEntity>();
		if(selectedBooks != null && selectedBooks.length>0) {
			for(int i=0; i<selectedBooks.length; i++) {
				BookEntity b = hbEntity.searchById(Integer.parseInt(selectedBooks[i]));
				addSelectedBooks.add(b);
			}
		}
		/**
		 * check if BookReader already exists if not add newReader 
		 */
		BookReader newReader = hbReader.findBookReader(bookReaderName);
		BookList bl = new BookList(listName, newReader);
		bl.setListOfBooks(addSelectedBooks);
		hbList.insertNewBookList(bl);
		
		getServletContext().getRequestDispatcher("/servletViewAllBookLists").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
