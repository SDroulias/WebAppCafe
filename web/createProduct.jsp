<%--
  Created by IntelliJ IDEA.
  User: STATHIS
  Date: 13/1/2019
  Time: 8:44 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>Create Product</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body>
<header>
    <nav class="navbar navbar-dark bg-dark">
        <a href="#" class="navbar-brand">Logo</a>
        <form class="form-inine" action="/" method="post">
            <button class="btn btn-outline-secondary" type="submit">Logout</button>
        </form>
    </nav>
</header>

<section class="container mt-5">
    <h1 class="text-center">Create a Product</h1>
    <form class="mt-5" action="createProduct" method="POST">
        <div class="form-group row">
            <label for="product-name" class="col-sm-2 col-form-label col-form-label-lg">Name</label>
            <div class="col-sm-10">
                <input type="text" name="productName" class="form-control form-control-lg" maxlength="45" id="product-name" placeholder="Enter the product's name" required>
            </div>
        </div>
        <div class="form-group row">
            <label for="product-price" class="col-sm-2 col-form-label col-form-label-lg">Price</label>
            <div class="col-sm-10">
                <input type="number" name="price" step="0.01" class="form-control form-control-lg" id="product-price" required>
            </div>
        </div>
        <div class="form-group row">
            <label for="product-descr" class="col-sm-2 col-form-label col-form-label-lg">Description</label>
            <div class="col-sm-10">
                <textarea name="description" class="form-control form-control-lg" id="product-descr" rows="3" maxlength="150" placeholder="Enter the product's description" required></textarea>
            </div>
        </div>
        <div class="form-group row justify-content-end">
            <div class="col-sm-2">
                <input class="btn btn-outline-dark w-100" type="submit" value="Create">
            </div>
        </div>
    </form>
</section>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>

</html>

