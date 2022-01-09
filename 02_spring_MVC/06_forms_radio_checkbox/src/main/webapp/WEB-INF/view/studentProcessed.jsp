<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Student Confirmation</title>
    </head>
    <body>
        <h2>Congratulations</h2>
        <hr>
        <h3>${student.lastName} ${student.firstName}</h3> 
        <hr>
        <br> <br>
        <h3>${student.state}, ${student.country}</h3>
        <h3>Favourite Language: ${student.favLang}</h3>
        <h3>Skills:</h3>
        <ul>
            <c:forEach var="temp" items="${student.skills}">
                <li> ${temp} </li>
            </c:forEach>
        </ul>
        your candidature has been recorded.
    </body>
</html>