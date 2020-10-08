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
 * Servlet implementation class ServletEditBookList
 * author: 	Ben Miner
 * course:	CIS 171 Java II
 * date:	October 2020
 * project:	WebBookLists
 * file:	ServletEditBookList.java
 * objective:
 * 		process form information from edit-book-list.jsp
 */
@WebServlet("/servletEditBookList")
public class ServletEditBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditBookList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * Entity Helper instances
		 */
		HelperBookEntity hbEntity = new HelperBookEntity();
		HelperBookList hbList = new HelperBookList();
		HelperBookReader hbReader = new HelperBookReader();
		/**
		 * find the BookList
		 */
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		BookList listToUpdate = hbList.searchById(tempId);
		/**
		 * create strings from input
		 */
		String newListName = request.getParameter("listName");
		String readerName = request.getParameter("bookReader");
		BookReader newReader = hbReader.findBookReader(readerName);
		try {
			String[] selectedBooks = request.getParameterValues("allBooksToAdd");
			List<BookEntity> selectedBooksInList = new ArrayList<BookEntity>();
			for (int i=0; i<selectedBooks.length;i++) {
				BookEntity b = hbEntity.searchById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInList.add(b);
			}
			listToUpdate.setListOfBooks(selectedBooksInList);
		} catch(NullPointerException e) {
			List<BookEntity> selectedBooksInList = new ArrayList<BookEntity>();
			listToUpdate.setListOfBooks(selectedBooksInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setBookReader(newReader);
		hbList.updateBookList(listToUpdate);
		getServletContext().getRequestDispatcher("/servletViewAllBookLists").forward(request, response);
	}

}
