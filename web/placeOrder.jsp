<%@ page isELIgnored="false" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Web Cafe</title>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="./resources/css/userheaderfooter.css">
  <link rel="stylesheet" type="text/css" href="./resources/css/placeorder.css">
</head>

<body ng-app="myApp">
  <header ng-include="'./userheader.html'" class="fixed-top"></header>



  <main class="container">
    <form id="order-form" class="">
      <div id="before-order" class="container fixed-top d-flex justify-content-center">
        <button id="before-order-btn" type="submit" class="btn btn-outline-secondary">Place Order</button>
      </div>
        <c:forEach items="${products}" var="product">
      <div class="form-row align-items-center pt-3 pb-3">
        <div class="form-group col-1">
          <div class="form-check">
            <input class="form-check-input" type="checkbox">
          </div>
        </div>
        <p class="id d-none">${product.getId()}</p>
        <p class="name col-3 mb-0">${product.getName()}</p>
        <p class="descr col-4 mb-0">${product.getDescription()}</p>
        <p class="price offset-1 col-2 mb-0">${product.getPrice()}</p>
        <input class="col-1 form-control quantity" type="number" min="1">
      </div>
      </c:forEach>
    </form>
  </main>

  <div class="modal fade" id="orderModal" tabindex="-1" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="orderModalLabel">Place Order</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Back</button>
          <button id="place-order-btn" type="button" class="btn btn-primary">Order Now</button>
        </div>
      </div>
    </div>
  </div>

  <div class="alert alert-success container" role="alert">
    <h4>Everything looks great!</h4>
    <h6>Your order will be ready to be collected as soon as possible.</h6>
    <p>Redirecting you to the main site now...</p>
  </div>

  <footer ng-include="'./userfooter.html'" class="fixed-bottom d-flex justify-content-between align-items-center"></footer>

  <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  <script type="text/javascript" src="./resources/js/placeorder.js"></script>
</body>

</html>
