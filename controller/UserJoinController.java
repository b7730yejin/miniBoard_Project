package miniProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import miniProject.entity.User;
import miniProject.service.UserService;


@WebServlet("/mini/user/join")
public class UserJoinController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/mini/join.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		if(username =="") {
			JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
			response.sendRedirect("/miniProject/mini/user/join");
		}else if(password=="") {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
			response.sendRedirect("/miniProject/mini/user/join");
		}
		else if(email=="") {
			JOptionPane.showMessageDialog(null, "이메일을 입력하세요");
			response.sendRedirect("/miniProject/mini/user/join");
		}
		else {
			User user = new User(username, password, email);
			
			UserService service = UserService.getInstance();
			service.join(user);
			response.sendRedirect("/miniProject/mini/user/login");
		}
	}
}
