<%@ page import="com.webappcafe.model.Customer" %>
<%
  Customer customer = (Customer) session.getAttribute("loggedInCustomer");

  if (customer == null) {
    response.sendRedirect("./");
  }
%>
<div class="d-flex flex-column ml-3">
  <p class="mb-0">Address: Ano Ilisia</p>
  <p class="mb-0">Tel: 21096969696</p>
  <p class="mb-0">Copyright 2019</p>
</div>
<div class="mr-3">
  <a href="https://facebook.com" target="_blank"><i class="fa fa-facebook-square fa-3x"></i></a>
  <a href="https://twitter.com" target="_blank" class="ml-3"><i class="fa fa-twitter fa-3x"></i></a>
  <a href="mailto:coffee@coffe.com" class="ml-3"><i class="fa fa-envelope fa-3x"></i></a>
</div>
