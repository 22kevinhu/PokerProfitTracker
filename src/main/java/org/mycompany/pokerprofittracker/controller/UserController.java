package org.mycompany.pokerprofittracker.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mycompany.pokerprofittracker.dao.UserDAO;
import org.mycompany.pokerprofittracker.model.User;

import java.io.IOException;

@WebServlet(value = "/userController")
public class UserController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserDAO userDAO = new UserDAO();
		String username = request.getParameter("name");
		User user = new User(username);

		userDAO.addUser(user);
		response.sendRedirect("views/addUser.jsp");
		System.out.println("Successfully added user");
	}
}
