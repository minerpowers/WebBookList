package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookList;

/**
 * Servlet implementation class servletListNavigation
 * author: 	Ben Miner
 * course:	CIS 171 Java II
 * date:	October 2020
 * project:	WebBookLists
 * file:	servletListNavigation
 * objective:
 * 		process form information from book-list-by-reader.jsp
 */
@WebServlet("/servletListNavigation")
public class servletListNavigation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListNavigation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HelperBookList hbList = new HelperBookList();
		String action = request.getParameter("doThisToBookList");
		String path = "/servletViewAllBookLists";
		if(action==null) {
			getServletContext().getRequestDispatcher(path).forward(request, response);
		} else if (action.equals("delete")) {
			try {
				Integer deleteId = Integer.parseInt(request.getParameter("id"));
				BookList deleteList = hbList.searchById(deleteId);
				hbList.deleteBookList(deleteList);
			} catch(NumberFormatException e){
				System.out.println("Forgot to click a button");
				path = "/servletViewAllBookLists";
			}
		} else if (action.equals("edit")) {
			try {
				Integer idToEdit = Integer.parseInt(request.getParameter("id"));
				BookList listToEdit = hbList.searchById(idToEdit);
				request.setAttribute("listToEdit", listToEdit);
				HelperBookEntity hbEntity = new HelperBookEntity();
				request.setAttribute("allBooks", hbEntity.showAllBooks());
				if(hbEntity.showAllBooks().isEmpty()) {
					request.setAttribute("allBooks", " ");
				}
				path ="/edit-book-list.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Did not select a list");
			}
		} else if(action.equals("add")) {
			HelperBookEntity hbe = new HelperBookEntity();
			request.setAttribute("allBooks", hbe.showAllBooks());
			if(hbe.showAllBooks().isEmpty()) {
				request.setAttribute("allBooks", "");
			}
			path = "/new-book-list.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
