<%--
  Created by IntelliJ IDEA.
  User: kevinhu
  Date: 5/21/24
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h2>Add a User</h2>
        <div class="formContainer">
            <form action="${pageContext.request.contextPath}/gameController" method="post">
                <label for="ownerId">Who Are You?:</label>
                <select id="ownerId" name="ownerId">
                    <c:forEach var="user" items="${users}">
                        <option value="${user.userId}">${user.userName}</option>
                    </c:forEach>
                </select><br>

                <label for="profit">How much did you earn/lose?:</label>
                <input type="number" id="profit" name="profit"><br>

                <input type="submit" value="submit">
            </form>
        </div>
</div>
</body>
</html>
