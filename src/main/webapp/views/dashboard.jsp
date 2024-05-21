<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>JSP - Hello World</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <script src="${pageContext.request.contextPath}/resources/scripts/script.js"></script>
</head>
<body>
    <div class="mainContainer">
        <h1>Your Dashboard</h1>
        <p id="mainMessage" class="mainMessage">Insert Message</p>
        <br/>
        <a href="game-controller">Hello Servlet</a>
    </div>
</body>
</html>