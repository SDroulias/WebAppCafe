<%-- 
    Document   : viewCustomers
    Created on : 18 ??? 2019, 2:47:18 ??
    Author     : andreasbouras
--%>

<%@ page isELIgnored="false" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>View Customers</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="./resources//css/style.css">
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

<section class="container mt-4">
    <h1 class="text-center h2">Edit a Customer</h1>
    <form id="edit-form" class="mt-4" action="/UpdateProductServlet" method="POST">
<!--        <div class="form-group row">
            <label for="customers-id" class="col-sm-2 col-form-label">Id</label>
            <div class="col-sm-10">
                <input type="text" name="id" class="form-control-plaintext" id="customers-id" required readonly>
            </div>
        </div>-->
        <div class="form-group row">
            <label for="customers-name" class="col-sm-2 col-form-label">First Name</label>
            <div class="col-sm-10">
                <input type="text" name="customersFName" class="form-control" maxlength="45" id="customers-fname" placeholder="Enter the customers's first name" required disabled>
            </div>
        </div>
        <div class="form-group row">
            <label for="customers-price" class="col-sm-2 col-form-label">Last Name</label>
            <div class="col-sm-10">
                <input type="text" name="customersLName" class="form-control" maxlength="45" id="customers-lname" placeholder="Enter the customers's last name" required disabled>
            </div>
        </div>
        <div class="form-group row">
            <label for="customers-descr" class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-10">
                <input type="text" name="username" class="form-control" maxlength="45" id="customers-username" placeholder="Enter the customers's username" required disabled>
            </div>
        </div>
        <div class="form-group row">
            <label for="customers-descr" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="text" name="password" class="form-control" maxlength="45" id="customers-password" placeholder="Enter the customers's password" required disabled>
            </div>
        </div>
        <div class="form-group row justify-content-end">
            <div class="col-sm-2">
                <input id="submit-edit" class="btn btn-outline-dark w-100" type="submit" value="Save" disabled>
            </div>
        </div>
    </form>
</section>

<hr />

<section class="container">
    <h1 class="h2 mb-4 text-center">All Customers</h1>
    <table class="table table-striped">
        <thead id="thead">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Username</th>
        </tr>
        </thead>
        <tbody>
        <%--Loops through the list of customers--%>
        <c:forEach items="${customers}" var="customers">
            <tr>
                <th class="id" scope="row">${customers.getId()}</th>
                <td class="fname">${customers.getFname()}</td>
                <td class="lname">${customers.getLname()}</td>
                <td class="username">${customers.getUsername()}</td>
                <td class="buttons"><button type="button" class="btn btn-outline-secondary edit-btn">Edit</button></td>
                <td class="buttons"><a href="deleteCustomer" class="btn btn-outline-danger delete-btn">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<<script type="text/javascript" src="./resources/js/main.js">
</script>
</body>

</html>


