<%--
    Document   : viewActiveOrders
    Created on : Jan 20, 2019, 2:18:05 PM
    Author     : Goat
--%>

<%@ page isELIgnored="false" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>
        <meta charset="utf-8">
        <title>Admin Panel</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../resources/css/adminorders.css">
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
                <a href="#" class="navbar-brand">Logo</a>
                <form class="form-inine" action="/" method="post">
                    <button class="btn btn-outline-secondary" type="submit">Logout</button>
                </form>
            </nav>
        </header>

        <main class="container">
            <h1 class="mb-5 mt-5 text-center">Active Orders</h1>

            <div id="head" class="row">
                <div class="col-1 d-flex align-items-center">
                    <p class="h5 font-weight-bold">ID</p>
                </div>
                <div class="col-3 d-flex align-items-center">
                    <p class="h5 font-weight-bold">Date</p>
                </div>
                <div class="col-2 d-flex align-items-center">
                    <p class="h5 font-weight-bold">Products</p>
                </div>
                <div class="col-3 d-flex align-items-center">
                    <p class="h5 font-weight-bold">Customer</p>
                </div>
                <div class="col-2 d-flex align-items-center">
                    <p class="h5 font-weight-bold">Price</p>
                </div>
            </div>
            <div id="content">

                <c:forEach items="${activeOrders}" var="activeOrder">

                    <div class="row">
                        <div class="cols col-1 d-flex align-items-center">
                            <p class="id font-weight-bold">${activeOrder.key.getId()}</p>
                        </div>
                        <div class="cols col-3 d-flex align-items-center">
                            <p items=${DATE_TIME_FORMATTER} var="DATE_TIME_FORMATTER">${DATE_TIME_FORMATTER.format(activeOrder.key.getDate())}</p>
                        </div>
                        <div class="cols products col-2">
                            <ul class="list-unstyled">
                                <c:forEach items="${activeOrder.key.getProductsOfOrder()}" var="product">
                                    <li>${product}</li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="cols col-3 d-flex align-items-center">
                            <p>${activeOrder.value.getFname()} ${activeOrder.value.getLname()}</p>
                        </div>
                        <div class="cols col-1 d-flex align-items-center">
                            <p items="${DECIMAL_FORMAT}" var="DECIMAL_FORMAT">${DECIMAL_FORMAT.format(activeOrder.key.getTotalPrice())}</p>
                        </div>
                        <div class="cols col-2 d-flex align-items-center justify-content-end">
                            <button class="btn btn-outline-success update-btn">Completed</button>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </main>

        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script type="text/javascript" src="../resources/js/viewactiveorders.js">
        </script>
    </body>

</html>
