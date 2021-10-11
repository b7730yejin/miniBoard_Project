package miniProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniProject.entity.Board;
import miniProject.service.BoardService;


@WebServlet("/mini/board/delete")
public class BoardDeleteController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			BoardService service = BoardService.getInstance();
			service.delete(username);
		
			response.sendRedirect("/miniProject/mini/board/list");
	}
	
}
