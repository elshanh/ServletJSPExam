package az.eh.lang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class LangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(){
		System.out.println("Server Start");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String action = request.getServletPath();
		
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
		
        
        System.out.println(user);
        System.out.println(pass);
/*
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/login":
				loginControl(request, response);
				break;				
			case "/list":
				listUser(request, response);
				break;				
			default:
				login(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}*/
	}	
	
	@Override
	public void destroy() {
		System.out.println("Server Stop");
	}

}
