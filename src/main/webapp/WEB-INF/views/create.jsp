<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>
    <body>
        <h2>Create book entry</h2>
        <form:form action="/app/create/submit" modelAttribute="book" method="POST">
            <form:input type="text" path="name" placeholder="Book name"/>
            <br>
            <br>
            <form:input type="number" path="stock"  placeholder="Book stock"/>
            <br>
            <br>
            <form:input type="text" path="section" placeholder="Book section"/>
            <button type="submit">Submit</button>
        </form:form>
    </body>
</html>
