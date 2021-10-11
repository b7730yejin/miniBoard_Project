package miniProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniProject.entity.Board;
import miniProject.service.BoardService;


@WebServlet("/mini/board/list")
public class BoardListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		List<Board> list = service.selectAll();
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/mini/list.jsp");
		rd.forward(request, response);	
	}
	
}
