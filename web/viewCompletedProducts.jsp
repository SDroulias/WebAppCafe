<%@ page isELIgnored="false" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>Admin Panel</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="./resources/css/viewcompletedorders.css">
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

<main class="container">
    <h1 class="mb-5 mt-5 text-center">Completed Orders</h1>

    <table class="table table-striped">
        <thead id="thead">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Date</th>
            <th scope="col">Products</th>
            <th scope="col">Customer</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${completedOrders}" var="completedOrder">
            <tr>
                <th class="id" scope="row">${completedOrder.key.getId()}</th>
                <td>${completedOrder.key.getDate()}</td>
                <%--<td>${completedOrder.key.getProductsOfOrder()}</td>--%>
                <td>
                    <ul class="list-unstyled">
                        <c:forEach items="${completedOrder.key.getProductsOfOrder()}" var="products">
                            <li>${products}</li>
                        </c:forEach>
                    </ul>
                </td>
                <td>${completedOrder.value.getLname()}</td>
                <td>0</td>
            </tr>
        </c:forEach>


        <%--<tr>--%>
            <th class="id" scope="row">1</th>
            <td>2018</td>
            <td><ul class="list-unstyled">
                <li>Product</li>
                <li>Product</li>
                <li>Product</li>
            </ul></td>
            <td>drea</td>
            <td>100</td>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<th class="id" scope="row">2</th>--%>
            <%--<td>2019</td>--%>
            <%--<td><ul class="list-unstyled">--%>
                <%--<li>Product</li>--%>
                <%--<li>Product</li>--%>
                <%--<li>Product</li>--%>
                <%--<li>Product</li>--%>
            <%--</ul></td>--%>
            <%--<td>stef</td>--%>
            <%--<td>200</td>--%>
        <%--</tr>--%>
        </tbody>
    </table>
</main>

<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>

</html>

