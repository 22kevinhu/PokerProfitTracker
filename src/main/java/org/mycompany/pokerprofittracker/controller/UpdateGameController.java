package org.mycompany.pokerprofittracker.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mycompany.pokerprofittracker.dao.GameDAO;

import java.io.IOException;

@WebServlet(value = "/updateGameController")
public class UpdateGameController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		GameDAO gameDAO = new GameDAO();
		int gameId = Integer.parseInt(request.getParameter("gameId"));
		double profit = Double.parseDouble(request.getParameter("profit"));

		gameDAO.updateGame(gameId, profit);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/dashboard.jsp");
		System.out.println("Successfully updated game");
	}
}
