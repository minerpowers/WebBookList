package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAddtoBookList
 * author: 	Ben Miner
 * course:	CIS 171 Java II
 * date:	October 2020
 * project:	WebBookLists
 * file:	ServletAddtoBookList
 * objective:
 * 		create a list of books using HelperBookEntity then setAttrribute "allBooks"
 * 		dispatch to new-book-list.jsp
 */
@WebServlet("/servletAddtoBookList")
public class ServletAddtoBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddtoBookList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HelperBookEntity hbe = new HelperBookEntity();
		request.setAttribute("allBooks", hbe.showAllBooks());
		if(hbe.showAllBooks().isEmpty()) {
			request.setAttribute("allBooks", "");
		}
		getServletContext().getRequestDispatcher("/new-book-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
