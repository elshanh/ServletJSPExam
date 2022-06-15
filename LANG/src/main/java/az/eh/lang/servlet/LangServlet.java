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
import az.eh.lang.business.SentenceOperation;
import az.eh.lang.business.UserOperation;
import az.eh.lang.dto.DictionaryDto;
import az.eh.lang.dto.SentenceDto;
import az.eh.lang.dto.UserDto;
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
		RequestDispatcher dispatcher = null;
        try {
        	switch (inRequest) {
        	/*User*/
			case "/login":
				loginControl(request,response);
			break;
			case "/userList":
				userList(request,response);
			break;
			case "/userOpenPage":
				dispatcher = request.getRequestDispatcher("userNew.jsp");
				dispatcher.forward(request, response);
			break;			
			case "/userInsert":
				userInsert(request,response);
				userList(request,response);
			break;
			case "/userOpenUpdatePage":
				UserDto userDto = UserOperation.select(Integer.parseInt(request.getParameter("id")));
				dispatcher = request.getRequestDispatcher("userUpdate.jsp");
				request.setAttribute("user", userDto);
				dispatcher.forward(request, response);
			break;			
			case "/userUpdate":
				userUpdate(request,response);
				userList(request,response);
			break;	
			case "/userDelete":
				UserOperation.delete(Integer.parseInt(request.getParameter("id")));
				userList(request,response);
			break;
			/*Sentence*/
			case "/sentenceList":
				sentenceList(request,response);
			break;
			case "/sentenceOpenPage":
				dispatcher = request.getRequestDispatcher("sentenceNew.jsp");
				dispatcher.forward(request, response);
			break;			
			case "/sentenceInsert":
				sentenceInsert(request,response);
				sentenceList(request,response);
			break;
			case "/sentenceOpenUpdatePage":
				SentenceDto sentenceDto = SentenceOperation.select(Integer.parseInt(request.getParameter("id")));
				dispatcher = request.getRequestDispatcher("sentenceUpdate.jsp");
				request.setAttribute("sentence", sentenceDto);
				dispatcher.forward(request, response);
			break;			
			case "/sentenceUpdate":
				sentenceUpdate(request,response);
				sentenceList(request,response);
			break;	
			case "/sentenceDelete":
				SentenceOperation.delete(Integer.parseInt(request.getParameter("id")));
				sentenceList(request,response);
			break;
			/*Dictionary*/
			case "/dictionaryList":
				dictionatyList(request,response);
			break;
			case "/menu":
				menu(request,response);
			break;
			case "/newWord":
				dispatcher = request.getRequestDispatcher("newWordInsertUpdate.jsp");
				dispatcher.forward(request, response);
			break;
			case "/insertNewWord":
				insertNewWord(request,response);
			break;
			case "/update":
				updateNewWordInsert(request,response);
				dictionatyList(request,response);
			break;			
			case "/sentence":
				userList(request,response);
			break;
			case "/note":
				userList(request,response);
			break;
			case "/edit":
				int id = Integer.parseInt(request.getParameter("id"));				
				updateNewWord(request,response);
			break;
			case "/delete":
				DictionaryOperation.delete(Integer.parseInt(request.getParameter("id")));
				dictionatyList(request,response);
			break;			
			default:
				dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}        
	}
	/*1 Begin*/
	private void loginControl(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int control = 0;
		try {
	    	control = UserOperation.loginControl(request.getParameter("pUsr"), request.getParameter("pPsw"));	
		} catch (Exception e) {
			control = 0;
		}
	    if (control == 0) {
            request.setAttribute("errorMessage", "Invalid username or password"); 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward( request, response);
	    }	    
	    if (control == 1) {
	    	menu(request,response);
	    }
	    if (control == 2) {
	    	menuUser(request,response);
	    }
	}	
	private void menu(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		dispatcher.forward(request, response);
	}
	private void menuUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("menuUser.jsp");
		dispatcher.forward(request, response);
	}
	/*1 End*/
	/*2 Begin*/
	private void userList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<UserDto> listUsers = UserOperation.getAllUsersList();
		request.setAttribute("listUsers", listUsers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
		dispatcher.forward(request, response);
	}
	private void userInsert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		UserDto userDto = new UserDto();
		userDto.setName(request.getParameter("pName"));
		userDto.setSurname(request.getParameter("pSurname"));
		userDto.setUsername(request.getParameter("pUsername"));
		userDto.setPassword(request.getParameter("pPassword"));
		UserOperation.insert(userDto);
	}
	private void userUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		UserDto userDto = new UserDto();
		userDto.setId(Integer.parseInt(request.getParameter("id")));
		userDto.setName(request.getParameter("pName"));
		userDto.setSurname(request.getParameter("pSurname"));
		userDto.setUsername(request.getParameter("pUsername"));
		userDto.setPassword(request.getParameter("pPassword"));
		UserOperation.update(userDto);
	}	
	/*2 End*/
	/*3 Begin*/
	private void sentenceList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<SentenceDto> listSentence = SentenceOperation.getAllSentenceList();
		request.setAttribute("listSentence", listSentence);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sentenceList.jsp");
		dispatcher.forward(request, response);
	}
	private void sentenceInsert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		SentenceDto sentenceDto = new SentenceDto();
		sentenceDto.setSentence(request.getParameter("pSentence"));
		sentenceDto.setLang(request.getParameter("pLang"));
		sentenceDto.setTranlateAz(request.getParameter("pTranslateAz"));
		sentenceDto.setTranlateTr(request.getParameter("pTranslateTr"));
		SentenceOperation.insert(sentenceDto);
	}
	private void sentenceUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		SentenceDto sentenceDto = new SentenceDto();
		sentenceDto.setId(Integer.parseInt(request.getParameter("id")));
		sentenceDto.setSentence(request.getParameter("pSentence"));
		sentenceDto.setLang(request.getParameter("pLang"));
		sentenceDto.setTranlateAz(request.getParameter("pTranslateAz"));
		sentenceDto.setTranlateTr(request.getParameter("pTranslateTr"));
		SentenceOperation.update(sentenceDto);
	}	
	/*3 End*/	
	private void dictionatyList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<DictionaryDto> listDictionary = DictionaryOperation.getAllWordList();
		request.setAttribute("listDictionary", listDictionary);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dictionary.jsp");
		dispatcher.forward(request, response);
	}
	private void updateNewWord(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		DictionaryDto dictionaryDto = DictionaryOperation.getWordById(Integer.parseInt(request.getParameter("id")));
		RequestDispatcher dispatcher = request.getRequestDispatcher("newWordInsertUpdate.jsp");
		request.setAttribute("dic", dictionaryDto);
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
		
		response.sendRedirect("list");
	}
	private void updateNewWordInsert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		DictionaryDto dictionaryDto = new DictionaryDto();
		dictionaryDto.setId(Integer.parseInt(request.getParameter("id")));
		dictionaryDto.setWordEng(request.getParameter("wordEng"));
		dictionaryDto.setSpeaksEng(request.getParameter("speakEng"));
		dictionaryDto.setWordGer(request.getParameter("wordGer"));
		dictionaryDto.setSpeaksGer(request.getParameter("speakGer"));
		dictionaryDto.setWordRus(request.getParameter("wordRus"));
		dictionaryDto.setSpeaksRus(request.getParameter("speakRus"));
		dictionaryDto.setTranslateAz(request.getParameter("translateAz"));
		dictionaryDto.setTranslateTr(request.getParameter("translateTr"));
		DictionaryOperation.update(dictionaryDto);
	}	
	/*
	private void sentenceList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("sentence.jsp");
		dispatcher.forward(request, response);
	}*/
	private void noteList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("note.jsp");
		dispatcher.forward(request, response);
	}	
	
	@Override
	public void destroy() {
		System.out.println("Server Stop");
	}

}
