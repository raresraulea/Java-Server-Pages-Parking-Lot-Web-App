<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Cars">
    <h1>Welcome to the Cars page!</h1>
    <div class="row">
        <div class="col-xs-12 col-md-4">
            Car 1
        </div>
        <div class="col-xs-12 col-md-4">
            Spot 1
        </div>
        <div class="col-xs-12 col-md-4">
            User 1
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12 col-md-4">
            Car 2
        </div>
        <div class="col-xs-12 col-md-4">
            Spot 2
        </div>
        <div class="col-xs-12 col-md-4">
            User 2
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12 col-md-4">
            Car 3
        </div>
        <div class="col-xs-12 col-md-4">
            Spot 3
        </div>
        <div class="col-xs-12 col-md-4">
            User 3
        </div>
    </div>
    
    <h5>Number of free parking spots: ${numberOfFreeParkingSpots}</h5>
</t:pageTemplate>
