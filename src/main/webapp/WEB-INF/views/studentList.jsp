<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h2>List of Students</h2>

    <ul>
        <c:forEach var="student" items="${students}">
            <li>${student}</li>
        </c:forEach>
    </ul>

    <a href="/">Back to Home</a>
</body>
</html>
