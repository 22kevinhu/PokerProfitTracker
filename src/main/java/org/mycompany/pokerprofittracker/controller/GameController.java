package org.mycompany.pokerprofittracker.controller;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "GameController", value = "/game-controller")
public class GameController extends HttpServlet {
	private String message;

	public void init() {
		message = "Hello World!";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");

		// Hello
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>" + message + "</h1>");
		out.println("</body></html>");
	}

	public void destroy() {
	}
}