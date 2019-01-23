<%--
  Created by IntelliJ IDEA.
  User: Aggeliki
  Date: 1/15/2019
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>View Products</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../resources/css/viewproducts.css">
</head>

<body>

    <%
        String username = String.valueOf(session.getAttribute("username"));
        String password = String.valueOf(session.getAttribute("password"));
    %>
    <% if (!username.equals("root") && !password.equals("root")) {
        response.sendRedirect("../");
    }
    %>

<header>
    <nav class="navbar navbar-dark bg-dark">
        <a href="./dashboard" class="navbar-brand">Logo</a>
        <form class="form-inine" action="/" method="post">
            <a href="../logoutFunction" class="btn btn-outline-secondary" type="submit">Logout</a>
        </form>
    </nav>
</header>

<section class="container mt-4">
    <h1 class="text-center h2">Edit a Product</h1>
    <form id="edit-form" class="mt-4" novalidate>
        <div class="form-group row">
            <!--<label for="product-id" class="col-sm-2 col-form-label">Id</label>-->
            <div class="col-sm-10">
                <input type="hidden" name="id" class="form-control" id="product-id" readonly>
            </div>
        </div>
        <div class="form-group row">
            <label for="product-name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input type="text" name="productName" class="form-control" maxlength="45" id="product-name" placeholder="Enter the product's name" required disabled>
                <div class="invalid-feedback">Please enter a product name</div>
            </div>
        </div>
        <div class="form-group row">
            <label for="product-price" class="col-sm-2 col-form-label">Price</label>
            <div class="col-sm-10">
                <input type="number" name="price" step="0.01" class="form-control " id="product-price" min="0.01" max="99.99" placeholder="Enter the product's price" required disabled>
                <div class="invalid-feedback">Please enter a price from 0.01 to 99.99</div>
            </div>
        </div>
        <div class="form-group row">
            <label for="product-descr" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <textarea name="description" class="form-control" id="product-descr" rows="3" maxlength="150" placeholder="Enter the product's description" required disabled></textarea>
                <div class="invalid-feedback">Please enter a product description</div>
            </div>
        </div>
        <div class="form-group row justify-content-end">
            <div class="col-sm-2">
                <input id="submit-edit" class="btn btn-outline-dark w-100" value="Save" type="submit" disabled>
            </div>
        </div>
    </form>
</section>

<hr />

<section class="container">
    <h1 class="h2 mb-4 text-center">All Products</h1>
    <table class="table table-striped">
        <thead id="thead">
        <tr>
            <th scope="col" class="d-none">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col" colspan="3">Description</th>
        </tr>
        </thead>
        <tbody>
        <%--Loops through the list of products--%>
        <c:forEach items="${products}" var="product">
            <tr>
                <th class="id d-none" scope="row">${product.getId()}</th>
                <td class="name">${product.getName()}</td>
                <td class="price">${product.getPrice()}</td>
                <td class="descr">${product.getDescription()}</td>
                <td class="buttons"><button type="button" class="btn btn-outline-secondary edit-btn">Edit</button></td>
                <td class="buttons"><button type="button" class="btn btn-outline-danger delete-btn">Delete</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<<script type="text/javascript" src="../resources/js/viewproducts.js">
</script>
</body>

</html>
