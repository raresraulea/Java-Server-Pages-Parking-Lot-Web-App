<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cars">
    <h1>Welcome to the Cars page!</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Cars">
        <button style="margin-bottom: 10px" class="btn btn-primary btn-lg" type="button">
            <a style="color:white; text-decoration: none;" href="${pageContext.request.contextPath}/AddCar">
                Add Car
            </a>
        </button>
        <button class="btn btn-danger" type="submit">Delete Cars</button>
        <c:forEach var="car" items="${cars}" varStatus="status">
            <div class="row"> 
                <div class="col-md-1">
                    <input type="checkbox" name="car_ids" value="${car.getId()}">
                </div>
                <div class="col-md-3">${car.getLicensePlate()}</div>
                <div class="col-md-3">${car.getParkingSpot()}</div>
                <div class="col-md-3">${car.getUsername()}s</div>
                <div class="col-md-2">
                    <a href="${pageContext.request.contextPath}/EditCar?id=${car.id}" class="btn btn-secondary" role="button">Edit Car</a>
                </div>
            </div>
        </c:forEach>
    </form>

    <h5>Number of free parking spots: ${numberOfFreeParkingSpots}</h5>
</t:pageTemplate>
