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


import az.eh.lang.business.NoteOperation;
import az.eh.lang.business.SentenceOperation;
import az.eh.lang.business.UserOperation;
import az.eh.lang.business.WordOperation;
import az.eh.lang.dto.NoteDto;
import az.eh.lang.dto.SentenceDto;
import az.eh.lang.dto.UserDto;
import az.eh.lang.dto.WordDto;


/*
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
*/


@WebServlet("/")
public class DictionaryServlet extends HttpServlet {
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
			/*Word*/
			case "/wordList":
				wordList(request,response);
			break;
			case "/wordOpenPage":
				dispatcher = request.getRequestDispatcher("wordNew.jsp");
				dispatcher.forward(request,response);
			break;
			case "/wordInsert":
				wordInsert(request,response);
				wordList(request,response);
			break;		
			case "/wordOpenUpdatePage":
				WordDto wordDto = WordOperation.select(Integer.parseInt(request.getParameter("id")));
				dispatcher = request.getRequestDispatcher("wordUpdate.jsp");
				request.setAttribute("word", wordDto);
				dispatcher.forward(request, response);
			break;
			case "/wordUpdate":
				wordUpdate(request,response);
				wordList(request,response);
			break;
			case "/wordDelete":
				WordOperation.delete(Integer.parseInt(request.getParameter("id")));
				wordList(request,response);
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
			/*BEGIN NOTE*/
			case "/noteList":
				noteList(request,response);
			break;
			case "/noteOpenPage":
				dispatcher = request.getRequestDispatcher("noteNew.jsp");
				dispatcher.forward(request, response);
			break;			
			case "/noteInsert":
				noteInsert(request,response);
				noteList(request,response);
			break;
			case "/noteOpenUpdatePage":
				NoteDto noteDto = NoteOperation.select(Integer.parseInt(request.getParameter("id")));
				dispatcher = request.getRequestDispatcher("noteUpdate.jsp");
				request.setAttribute("note", noteDto);
				dispatcher.forward(request, response);
			break;			
			case "/noteUpdate":
				noteUpdate(request,response);
				noteList(request,response);
			break;	
			case "/noteDelete":
				NoteOperation.delete(Integer.parseInt(request.getParameter("id")));
				noteList(request,response);
			break;			
			/*END NOTE*/
			/*Menu*/
			case "/menu":
				menu(request,response);
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
	/*Login Begin*/
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
	/*Login End*/
	/*User Begin*/
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
	/*User End*/
	/*Word Begin*/
	private void wordList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<WordDto> listWords = WordOperation.getAllWordList();
		request.setAttribute("listWords", listWords);
		RequestDispatcher dispatcher = request.getRequestDispatcher("wordList.jsp");
		dispatcher.forward(request, response);
	}
	private void wordInsert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		WordDto wordDto = new WordDto();
		wordDto.setWordEng(request.getParameter("wordEng"));
		wordDto.setSpeaksEng(request.getParameter("speakEng"));
		wordDto.setWordGer(request.getParameter("wordGer"));
		wordDto.setSpeaksGer(request.getParameter("speakGer"));
		wordDto.setWordRus(request.getParameter("wordRus"));
		wordDto.setSpeaksRus(request.getParameter("speakRus"));
		wordDto.setTranslateAz(request.getParameter("translateAz"));
		wordDto.setTranslateTr(request.getParameter("translateTr"));
		WordOperation.insert(wordDto);
	}
	private void wordUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		WordDto wordDto = new WordDto();
		wordDto.setId(Integer.parseInt(request.getParameter("id")));
		wordDto.setWordEng(request.getParameter("wordEng"));
		wordDto.setSpeaksEng(request.getParameter("speakEng"));
		wordDto.setWordGer(request.getParameter("wordGer"));
		wordDto.setSpeaksGer(request.getParameter("speakGer"));
		wordDto.setWordRus(request.getParameter("wordRus"));
		wordDto.setSpeaksRus(request.getParameter("speakRus"));
		wordDto.setTranslateAz(request.getParameter("translateAz"));
		wordDto.setTranslateTr(request.getParameter("translateTr"));
		WordOperation.update(wordDto);
	}
	/*Word End*/
	/*Sentence Begin*/
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
	/*Sentence End*/
	/*Note Begin*/
	private void noteList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<NoteDto> listNotes = NoteOperation.getAllNoteList();
		request.setAttribute("listNotes", listNotes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("noteList.jsp");
		dispatcher.forward(request, response);
	}
	private void noteInsert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		NoteDto noteDto = new NoteDto();
		noteDto.setLang(request.getParameter("pLang"));
		noteDto.setNote(request.getParameter("pNote"));
		NoteOperation.insert(noteDto);
	}
	private void noteUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		NoteDto noteDto = new NoteDto();
		noteDto.setId(Integer.parseInt(request.getParameter("id")));
		noteDto.setLang(request.getParameter("pLang"));
		noteDto.setNote(request.getParameter("pNote"));
		NoteOperation.update(noteDto);
	}	
	/*Note End*/
	
	@Override
	public void destroy() {
		System.out.println("Server Stop");
	}

}
