<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit Car">
    <h1>Edit car</h1>
    <div class="container">
  <main>
    <div class="row g-5">
      <div class="col-md-7 col-lg-8">
          <form class="needs-validation" method="POST" action="${pageContext.request.contextPath}/EditCar">
          <div class="row g-3">
            
            <div class="col-12">
              <label for="address" class="form-label">License plate</label>
              <input type="text" class="form-control" id="license_plate" name="license_plate" placeholder="Enter your license plate..." required>
              <div class="invalid-feedback">
                Please enter the license plate.
              </div>
            </div>

            <div class="col-12">
              <label for="address" class="form-label">Parking Spot</label>
              <input type="text" class="form-control" id="parking_spot" name="parking_spot"  placeholder="Enter the parking spot..." required>
              <div class="invalid-feedback">
                Please enter the parking spot.
              </div> 
            </div>

            <div class="col-md-5">
              <label for="country" class="form-label">Owner</label>
              <select class="form-select" id="owner_id" name="owner_id" required>
                <option value="">Choose...</option>
                <c:forEach var="user" items="${users}" varStatus="status">
                    <option value="${user.id}">${car.getUsername() eq user.getUsername() ? 'selected' : ''}+${user.getUsername()}</option>
                </c:forEach>
              </select>
              <div class="invalid-feedback">
                Please select an owner.
              </div>
            </div>
          </div>

          <hr class="my-4">
          <input type="hidden" name="car_id" value="${car.getId()}">
          <button class="w-100 btn btn-primary btn-lg" type="submit">Save</button>
        </form>
      </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017–2021 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>
    
<script>// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })
})()</script>
</t:pageTemplate>
