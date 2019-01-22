<%@ page import="com.webappcafe.model.Customer" %>
<%
  Customer customer = (Customer) session.getAttribute("loggedInCustomer");

  if (customer == null) {
    response.sendRedirect("./");
  }
%>
<nav class="navbar navbar-dark bg-dark">
  <a id="logo" href="./index" class="navbar-brand">Logo</a>
  <div class="d-flex align-items-center">

    <ul class="nav">
      <li class="nav-item dropdown">
        <i class="fa fa-user fa-2x nav-link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></i>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="./orders">Orders</a>
          <a class="dropdown-item" href="./profile">Profile</a>
            <div class="dropdown-divider"></div>
          <a href="./logoutFunction" class="dropdown-item">Logout</a>
        </div>
      </li>
    </ul>
    <p id="username-value" class="mt-3">${loggedInCustomer.getUsername()}</p>
  </div>
</nav>
