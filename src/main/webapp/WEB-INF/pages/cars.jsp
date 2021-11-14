<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cars">
    <h1>Welcome to the Cars page!</h1>
    <table class="table table-striped table-dark">
        <thead>
            <tr>
              <th scope="col">License plate</th>
              <th scope="col">Parking Spot</th>
              <th scope="col">Username</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="car" items="${cars}" varStatus="status">
                <tr>
                  <td> ${car.getLicensePlate()}</td>
                  <td>${car.getParkingSpot()}</td>
                  <td>${car.getUsername()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h5>Number of free parking spots: ${numberOfFreeParkingSpots}</h5>
</t:pageTemplate>
