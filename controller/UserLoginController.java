package miniProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniProject.entity.User;
import miniProject.service.UserService;


@WebServlet("/mini/user/login")
public class UserLoginController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/mini/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = new User(username, password, email);

		UserService service = UserService.getInstance();
		if(service.login(user)==true) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("/miniProject/mini/board/list");
		} else {
			response.sendRedirect("/miniProject/mini/user/login");
		}
		
	}

}
