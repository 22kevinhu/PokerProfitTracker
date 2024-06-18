<%--
  Created by IntelliJ IDEA.
  User: kevinhu
  Date: 6/4/24
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.mycompany.pokerprofittracker.dao.GameDAO" %>
<%@ page import="org.mycompany.pokerprofittracker.model.Game" %>
<html>
<head>
    <title>Update Game</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
    <div class="mainContainer">
        <h2>Update a Game</h2>
        <div class="formContainer">
            <form action="${pageContext.request.contextPath}/updateGameController" method="post">
                <label for="gameId">Which game would you like to update?</label>
                <select id="gameId" name="gameId" required>
                    <option value="">-- Select a Game --</option>
                    <%
                        GameDAO gameDAO = new GameDAO();
						List<Game> gameList = gameDAO.getAllGames();
						if (gameList != null && !gameList.isEmpty()) {
							for (Game game : gameList) {
                    %>
                    <option value="<%=game.getGameId()%>"><%=game.getGameId()%></option>
                    <%
                            }
                        }
                    %>
                </select>

                <br>
                <label for="profit">Profit:</label>
                <input id="profit" name="profit" placeholder="$0.00" required>

                <input type="submit" value="submit">
            </form>
        </div>
    </div>
</body>
</html>
