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
    <link rel="stylesheet" type="text/css" href="./resources/css/userorders.css">
</head>

<body ng-app="myApp">
<header ng-include="'./userheader.html'" class="fixed-top"></header>

<main class="container">
    <h1 class="h2 mt-5 mb-5">Your orders</h1>
    <div id="head" class="row">
        <div class="col-3 d-flex align-items-center">
            <p class="h5 font-weight-bold">Date</p>
        </div>
        <div class="col-3 d-flex align-items-center">
            <p class="h5 font-weight-bold">Products</p>
        </div>
        <div class="col-3 d-flex align-items-center">
            <p class="h5 font-weight-bold">Price</p>
        </div>
        <div class="col-3 d-flex align-items-center">
            <p class="h5 font-weight-bold">Status</p>
        </div>
    </div>
    <div id="content">
        <div class="row">
            <div class="col-3 d-flex align-items-center">
                <p>Friday 6/6/6 6:66</p>
            </div>
            <div class="products col-3">
                <ul class="list-unstyled">
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                </ul>
            </div>
            <div class="col-3 d-flex align-items-center">
                <p>100</p>
            </div>
            <div class="col-3 d-flex align-items-center">
                <p>Active</p>
            </div>
        </div>
        <div class="row">
            <div class="col-3 d-flex align-items-center">
                <p>Friday 13/12/13 13:13</p>
            </div>
            <div class="products col-3">
                <ul class="list-unstyled">
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                </ul>
            </div>
            <div class="col-3 d-flex align-items-center">
                <p>200</p>
            </div>
            <div class="col-3 d-flex align-items-center">
                <p>Completed</p>
            </div>
        </div>
        <div class="row">
            <div class="col-3 d-flex align-items-center">
                <p>Friday 13/12/13 13:13</p>
            </div>
            <div class="products col-3">
                <ul class="list-unstyled">
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                    <li>Product</li>
                </ul>
            </div>
            <div class="col-3 d-flex align-items-center">
                <p>200</p>
            </div>
            <div class="col-3 d-flex align-items-center">
                <p>Completed</p>
            </div>
        </div>
    </div>
</main>

<footer ng-include="'./userfooter.html'" class="fixed-bottom d-flex justify-content-between align-items-center"></footer>

<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script type="text/javascript">
    var app = angular.module('myApp', []);
</script>
</body>

</html>

