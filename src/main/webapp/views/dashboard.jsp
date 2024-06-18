<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dashboard</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css" v="1.0.1">
</head>
<body>
    <div class="mainContainer">
        <div class="mainMessage">
            <h1>Poker Profit Tracker</h1>
            <br><br>
        </div>
        <div class="options">
            <h2>What would you like to do?</h2>
            <ul>
                <a href="addUser.jsp" class="addUser">Add User</a>
                <a href="addGame.jsp" class="logGame">Log Game</a>
                <a href="updateGame.jsp" class="updateGame">Update Game</a>
            </ul>
        </div>
    </div>
</body>
</html>