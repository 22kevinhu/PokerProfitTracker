package org.mycompany.pokerprofittracker.controller;

import java.io.*;
import java.util.List;

import com.google.gson.Gson;
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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserDAO userDAO= new UserDAO();
		List<User> users = userDAO.getAllUsers();

		Gson gson = new Gson();
		String json = gson.toJson(users);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

}