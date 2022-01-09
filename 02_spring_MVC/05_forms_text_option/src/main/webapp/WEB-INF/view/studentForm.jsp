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
            <input type="submit" value="Submit" />
        </form:form>
    </body>
</html>