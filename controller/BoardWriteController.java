package miniProject.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniProject.entity.Board;
import miniProject.service.BoardService;


@WebServlet("/mini/board/write")
public class BoardWriteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("username")==null) {
			response.sendRedirect("/miniProject/mini/user/login");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/mini/write.jsp");
			rd.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		BoardService service = BoardService.getInstance();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = (String) session.getAttribute("username");
		String writeDate = service.getWriteDate();
		
		Board board = new Board(0, title, writer, content, -1, writeDate , 0);
		int bno = service.write(board);
		response.sendRedirect("/miniProject/mini/board/read?bno=" + bno);
		
	}
}
