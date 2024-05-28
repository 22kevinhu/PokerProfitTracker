package org.mycompany.pokerprofittracker.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mycompany.pokerprofittracker.dao.UserDAO;
import org.mycompany.pokerprofittracker.model.User;

import java.io.IOException;

@WebServlet("/userController")
public class UserController extends HttpServlet {
	private UserDAO userDAO = new UserDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");

		User user = new User(username);
		user.setUserName(username);

		userDAO.addUser(user);
	}
}
