package org.mycompany.pokerprofittracker.controller;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mycompany.pokerprofittracker.dao.GameDAO;
import org.mycompany.pokerprofittracker.dao.UserDAO;
import org.mycompany.pokerprofittracker.model.Game;
import org.mycompany.pokerprofittracker.model.User;

@WebServlet(value = "/gameController")
public class GameController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		GameDAO gameDAO = new GameDAO();
//		Game game = new Game(request.getParameter(""));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		GameDAO gameDAO = new GameDAO();
		List<User> users = gameDAO.getAllUsers();
		request.setAttribute("users", users);
		try {
			request.getRequestDispatcher("/views/addGame.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}