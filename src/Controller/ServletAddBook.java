package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookEntity;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBookServlet")
public class ServletAddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String isbn10 = request.getParameter("isbn10");
		BookEntity book = new BookEntity(title, firstName, lastName, isbn10);
		HelperBookEntity dao = new HelperBookEntity();
		// verify ISBN10 does not already  exist then add to data base
		if (!dao.checkIsbn(book.getIsbn10())) {
			dao.insertBook(book);
		}
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
