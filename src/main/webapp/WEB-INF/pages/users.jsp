<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cars">
    <h1>Welcome to the Users page!</h1>
    <table class="table table-striped table-dark">
        <thead>
            <tr>
              <th scope="col">Name</th>
              <th scope="col">Email</th>
              <th scope="col">Position</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}" varStatus="status">
                <tr>
                  <td>${user.getUsername()}</td>
                  <td>${user.getEmail()}</td>
                  <td>${user.getPosition()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</t:pageTemplate>
