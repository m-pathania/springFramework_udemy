<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

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
        <h3>${student.country}</h3>
        your candidature has been recorded.
    </body>
</html>