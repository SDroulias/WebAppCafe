<%@ page import="com.webappcafe.model.Customer" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Admin Panel</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../resources/css/adminpanel.css">
  </head>
  <body class="d-flex flex-column">
    <header>
      <nav class="navbar navbar-dark bg-dark">
        <a href="#" class="navbar-brand">Logo</a>
        <form class="form-inine" action="/" method="post">
          <a href="../logoutFunction" class="btn btn-outline-secondary" type="submit">Logout</a>
        </form>
      </nav>
    </header>

    <%
        String username = String.valueOf(session.getAttribute("username"));
        String password = String.valueOf(session.getAttribute("password"));
    %>
    <% if (!username.equals("root") && !password.equals("root")) {
        response.sendRedirect("../");
        }
    %>

    <main class="mt-5 mb-5 container flex-grow-1 d-flex flex-column">
     <div class="row flex-grow-1">
        <div class="border-cols col-md-4 d-flex flex-column align-items-center">
          <h1 class="pt-5 pb-5">Customers</h1>
          <a class="d-block mb-5" href="./create-customer">Create Customer</a>
          <a class="" href="./viewCustomers">View Customers</a>
        </div>
        <div class="border-cols col-md-4 d-flex flex-column align-items-center">
          <h1 class="pt-5 pb-5 text-center">Products</h1>
          <a class="d-block mb-5" href="./createProduct">Create Product</a>
          <a class="" href="viewProducts">View Products</a>
        </div>
        <div class="col-md-4 d-flex flex-column align-items-center">
          <h1 class="pt-5 pb-5 text-center">Orders</h1>
          <a class="d-block mb-5" href="viewActiveOrders">View Active Orders</a>
          <a class="" href="viewCompletedOrders">View Completed Orders</a>
        </div>
      </div>
    </main>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
