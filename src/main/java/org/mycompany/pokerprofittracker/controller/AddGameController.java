package org.mycompany.pokerprofittracker.controller;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mycompany.pokerprofittracker.dao.GameDAO;
import org.mycompany.pokerprofittracker.model.Game;

@WebServlet(value = "/addGameController")
public class AddGameController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		GameDAO gameDAO = new GameDAO();
		int ownerId = Integer.parseInt(request.getParameter("ownerId"));
		double profit = Double.parseDouble(request.getParameter("profit"));
		String gamePlayed = request.getParameter("gamePlayed");
		Game game = new Game(ownerId, profit, gamePlayed);

		gameDAO.addGame(game);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/dashboard.jsp");
		System.out.println("Successfully added game");
	}

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		UserDAO userDAO= new UserDAO();
//		List<User> users = userDAO.getAllUsers();
//
//		request.setAttribute("users", users);
//		request.getRequestDispatcher("addGame.jsp").forward(request, response);
//	}

}