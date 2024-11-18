<%@ page import="java.util.List" %>
<%@ page import="org.example.authorbookee.model.Author" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/15/2024
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<%List<Author> authors = (List<Author>) request.getAttribute("authors");%>
<h1>Add Book</h1>
<a href="/books">Books Page</a> |<a href="index.jsp">Main</a><br>


<form action="/addBook" method="post">
    Title:<input type="text" name="title"><br>
    Price:<input type="number" name="price"><br>
    Quantity:<input type="number" name="quantity"><br>
    Author:<select name="author_id">
    <% for (Author author : authors) {%>
    <option value="<%=author.getId()%>"><%= author.getName() + " " + author.getSurname()%>
    </option>
    <% }%>
</select><br>
    <input type="submit" value="ADD">


</form>

</body>
</html>
