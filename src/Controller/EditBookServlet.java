package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookEntity;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/editBookServlet")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookEntityHelper dao = new BookEntityHelper();
		String title = request.getParameter("title");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String isbn10 = request.getParameter("isbn10");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		BookEntity bookToEdit = dao.searchById(tempId);
		bookToEdit.setTitle(title);
		bookToEdit.setFirstName(firstName);
		bookToEdit.setLastName(lastName);
		bookToEdit.setIsbn10(isbn10);
		dao.updateBook(bookToEdit);
		getServletContext().getRequestDispatcher("/viewBookListServlet").forward(request, response);
		
	}

}
