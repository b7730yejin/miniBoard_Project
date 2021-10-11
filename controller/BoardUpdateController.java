package miniProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniProject.service.BoardService;


@WebServlet("/mini/board/update")
public class BoardUpdateController extends HttpServlet {
	
	private int bno;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardService service = BoardService.getInstance();
		
		bno = Integer.parseInt(request.getParameter("bno"));
		request.setAttribute("board", service.selectByBno(bno));
		
		RequestDispatcher rd = request.getRequestDispatcher("/mini/update.jsp");
		rd.forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		BoardService service = BoardService.getInstance();
		
		String username = (String) session.getAttribute("username");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		service.update(bno, username, title, content);
		request.setAttribute("username", username);
		response.sendRedirect("/miniProject/mini/board/read?bno=" + bno);
		PrintWriter out = response.getWriter();
		out.print(username);
	}
}
