<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.folder.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Sign up!
    </div>
    <form method="post" action="/signUp">

        <label for="first_name">First name
            <input class="input-field" type="text" id="first_name" name="name">
        </label>

        <label for="last_name">Last name
            <input class="input-field" type="text" id="last_name" name="name">
        </label>

        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>

        <input type="submit" value="sign up">

    </form>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Already registered!
    </div>
    <table>

        <tr>
            <th>User id</th>
            <th>First name</th>
            <th>Last name</th>
        </tr>

        <c:forEach items="${usersFromOurPostgreSQL}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getFirst_name()}</td>
                <td>${user.getLast_name()}</td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>

