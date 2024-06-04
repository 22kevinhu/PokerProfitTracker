<%--
  Created by IntelliJ IDEA.
  User: kevinhu
  Date: 5/21/24
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="org.mycompany.pokerprofittracker.dao.UserDAO" %>
<%@ page import="org.mycompany.pokerprofittracker.model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<head>
    <title>Add Game</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <script src="${pageContext.request.contextPath}/resources/scripts/script.js"></script>
</head>
<body>
    <div class="mainContainer">
        <h2>Log a Game</h2>
        <div class="formContainer">
            <form action="${pageContext.request.contextPath}/addGameController" method="post">
                <label for="ownerId">Who Are You?:</label>
                <select id="ownerId" name="ownerId" required>
                    <option value="">-- Select a User --</option>
                    <%
                        UserDAO userDAO = new UserDAO();
						List<User> userList = userDAO.getAllUsers();
						if (userList != null && !userList.isEmpty()) {
                            for (User user : userList) {
                    %>
                        <option value="<%=user.getUserId()%>"><%=user.getUserName()%></option>
                    <%
                            }
                        }
                    %>
                </select><br>

                <label for="profit">How much did you earn/lose?:</label>
                <input type="number" id="profit" name="profit" placeholder="$0.00" required><br>

                <label for="gamePlayed">What game did you play?:</label>
                <input type="text" id="gamePlayed" name="gamePlayed" placeholder="Poker/Blackjack/etc"><br>

                <input type="submit" value="submit">
            </form>
        </div>
</div>
</body>
</html>
