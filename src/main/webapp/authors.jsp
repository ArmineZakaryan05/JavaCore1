<%@ page import="java.util.List" %>
<%@ page import="org.example.authorbookee.model.Author" %>
<%@ page import="org.example.authorbookee.util.DateUtil" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/14/2024
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>authors</title>
</head>
<body>
<h2>Authors:</h2> <a href="/addAuthor">Add Author</a>
<% List<Author> authors = (List<Author>) request.getAttribute("authors"); %>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>phone</th>
        <th>dob</th>
        <th>gender</th>
        <th>action</th>
    </tr>

    <% for (Author author : authors) { %>
    <tr>
        <td><%=author.getId()%></td>
        <td><%=author.getName()%></td>
        <td><%=author.getSurname()%></td>
        <td><%=author.getPhone()%></td>
        <td><%= DateUtil.fromDateToString(author.getDateOfBirthday())%></td>
        <td><%=author.getGender().name()%></td>
        <td><a href="/deleteAuthor?id=<%=author.getId()%>">Delete</a> / <a href="/editAuthor?id=<%=author.getId()%>">Edit</a> </td>
    </tr>
    <% } %>
</table>
</body>
</html>
