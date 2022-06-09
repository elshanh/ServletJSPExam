package az.eh.lang.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import az.eh.lang.business.DictionaryOperation;
import az.eh.lang.business.UserOperation;
import az.eh.lang.dto.DictionaryDto;
import az.eh.lang.webdto.DictionaryWebDto;


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
		String inRequest = request.getServletPath();
		
        String user = request.getParameter("pUsr");
        String pass = request.getParameter("pPsw");
		
        
        System.out.println(user);
        System.out.println(pass);
        
        try {
        	switch (inRequest) {
			case "/login":
				loginControl(request,response);
			break;
			case "/user":
				userList(request,response);
			break;
			case "/dictionary":
				dictionatyList(request,response);
			break;
			case "/newWord":
				newWord(request,response);
			break;
			case "/insertNewWord":
				insertNewWord(request,response);
			break;			
			case "/sentence":
				userList(request,response);
			break;
			case "/note":
				userList(request,response);
			break;			
			default:
				login(request,response);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}        
	}	
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	private void loginControl(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	    int control = UserOperation.loginControl(request.getParameter("pUsr"), request.getParameter("pPsw"));
	    
	    if (control == 1) {
	    	menu(request,response);
	    }
	}	
	private void menu(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		dispatcher.forward(request, response);
	}
	private void userList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
		dispatcher.forward(request, response);
	}
	private void dictionatyList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<DictionaryDto> listDictionary = DictionaryOperation.getAllWordList();
		request.setAttribute("listDictionary", listDictionary);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("dictionary.jsp");
		dispatcher.forward(request, response);
	}
	private void newWord(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("newWordInsertUpdate.jsp");
		dispatcher.forward(request, response);
	}
	private void insertNewWord(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		DictionaryWebDto dictionaryWebDto = new DictionaryWebDto();
		dictionaryWebDto.setWordEng(request.getParameter("wordEng"));
		dictionaryWebDto.setSpeaksEng(request.getParameter("speakEng"));
		dictionaryWebDto.setWordGer(request.getParameter("wordGer"));
		dictionaryWebDto.setSpeaksGer(request.getParameter("speakGer"));
		dictionaryWebDto.setWordRus(request.getParameter("wordRus"));
		dictionaryWebDto.setSpeaksRus(request.getParameter("speakRus"));
		dictionaryWebDto.setTranslateAz(request.getParameter("translateAz"));
		dictionaryWebDto.setTranslateTr(request.getParameter("translateTr"));
		DictionaryOperation.insert(dictionaryWebDto);
		
		/*UserDTO newUser = new UserDTO(name, email, country);
		userDAO.insertUser(newUser);*/
		response.sendRedirect("list");
	}	
	private void sentenceList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("sentence.jsp");
		dispatcher.forward(request, response);
	}
	private void noteList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("note.jsp");
		dispatcher.forward(request, response);
	}	
	
	@Override
	public void destroy() {
		System.out.println("Server Stop");
	}

}
