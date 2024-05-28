<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dashboard</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <script src="${pageContext.request.contextPath}/resources/scripts/script.js"></script>
</head>
<body>
    <div class="mainContainer">
        <div class="mainMessage">
            <h1>Poker Profit Tracker</h1>
            <p id="mainMessage" class="mainMessage">Insert Message</p>
            <br><br>
        </div>
        <div class="options">
            <h2>What would you like to do?</h2>
            <ul>
                <a href="addUser.jsp" class="addUser">Add User</a>
                <a href="addGame.jsp" class="addGame">Add Game</a>
                <a href="game-controller" class="modifyGame">Modify Games</a>
            </ul>
        </div>
        <div class="leaderboard">
            <h3>Leaderboard</h3>
            <ul>
                1. Kevin (Total Spent: $100, Total Profit: -$50)
                2. Payton
                etc
            </ul>
        </div>
    </div>
</body>
</html>