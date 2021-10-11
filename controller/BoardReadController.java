package miniProject.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniProject.entity.Board;
import miniProject.service.BoardService;


@WebServlet("/mini/board/read")
public class BoardReadController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardService service = BoardService.getInstance();
		int bno = Integer.parseInt(request.getParameter("bno"));
		service.veiwcount(bno);

		request.setAttribute("board", service.selectByBno(bno));
		RequestDispatcher rd = request.getRequestDispatcher("/mini/read.jsp");
		rd.forward(request, response);
	}
	
}
