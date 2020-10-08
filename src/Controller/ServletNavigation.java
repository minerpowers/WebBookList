package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookEntity;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class ServletNavigation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNavigation() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HelperBookEntity dao = new HelperBookEntity();
		String action = request.getParameter("doThisToBook");
		String path = "/viewBookListServlet";
		if(action.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				BookEntity bookToDelete = dao.searchById(tempId);
				dao.deleteBook(bookToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Did not select an item");
			}
		} else if(action.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				BookEntity bookToEdit = dao.searchById(tempId);
				request.setAttribute("bookToEdit", bookToEdit);
				path ="/edit-book.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Did not select an item");
			}
			
		} else if(action.equals("add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
