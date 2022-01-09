<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Student Form</title>
    </head>
    <body>
        <form:form action="processed" modelAttribute="student">
            First Name: <form:input path="firstName"/>
            <br><br>
            Last Name: <form:input path="lastName" />
            <br><br>
            Country:
            <form:select path="country">
                <form:option value="US" label="US"/>
                <form:option value="India" label="India"/>
                <form:option value="Germany" label="Germany"/>
                <form:option value="Japan" label="Japan"/>
            </form:select>
            <br><br>
            State:
            <form:select path="state">
                <form:options items="${student.stateData}"/>
            </form:select>
            <br><br>
            Favourite Language:
            Java <form:radiobutton path="favLang" value="Java" />
            C++ <form:radiobutton path="favLang" value="C++" />
            Python <form:radiobutton path="favLang" value="Python" />
            Ruby <form:radiobutton path="favLang" value="Ruby" />
            <br><br>
            Spring Knowledge:
            Spring Framework <form:checkbox path="skills" value="Spring Framework" />
            Spring MVC <form:checkbox path="skills" value="Spring MVC" />
            Spring Boot <form:checkbox path="skills" value="Spring Boot" />
            <br><br>
            <input type="submit" value="Submit" />
        </form:form>
    </body>
</html>