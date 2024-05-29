<%--
  Created by IntelliJ IDEA.
  User: kevinhu
  Date: 5/21/24
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Log In</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <script src="${pageContext.request.contextPath}/resources/scripts/script.js"></script>
</head>
<body>
    <div class="mainContainer">
        <h2>Add a User</h2>
        <div class="formContainer">
            <form action="${pageContext.request.contextPath}/userController" method="post">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name"><br>

                <input type="submit" value="submit">
            </form>
        </div>
    </div>
</body>
</html>
