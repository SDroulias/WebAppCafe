<%@ page import="com.webappcafe.model.Customer" %>
<%@ page isELIgnored="false" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Web Cafe</title>
  <script type="text/javascript">
    var userPass = '${loggedInCustomer.getPassword()}';
  </script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="./resources/css/userheaderfooter.css">
  <link rel="stylesheet" type="text/css" href="./resources/css/userprofile.css">
</head>

<body ng-app="myApp">

  <%
    Customer customer = (Customer) session.getAttribute("loggedInCustomer");

    if (customer == null) {
      response.sendRedirect("../");
    }
  %>

  <header ng-include="'./userheader.html'" class="fixed-top"></header>

  <main>
    <section class="container pt-5 pb-5">
      <h1 class="pb-3">Profile</h1>
      <form id="user-form">
        <div class="form-group mb-0">
          <input type="hidden" name="id" class="form-control" id="user-id-update" readonly>
        </div>
        <div class="form-group">
          <label for="fname">First Name</label>
          <input name="fname" type="text" class="form-control" id="fname" value="${loggedInCustomer.getFname()}" required disabled maxlength="45">
        </div>
        <div class="form-group">
          <label for="lname">Last Name</label>
          <input name="lname" type="text" class="form-control" id="lname" value="${loggedInCustomer.getLname()}" required disabled maxlength="45">
        </div>
        <button id="save-user" class="btn btn-outline-success float-right" disabled>Save</button>
        <button id="update-user" class="btn btn-outline-secondary float-right mr-3">Update</button>
      </form>
    </section>

    <hr>

    <section class="container mt-2">
      <h1 class="h3 pb-3">Update Password</h1>
      <form id="pass-form">
        <div class="form-group mb-0">
          <input type="hidden" name="id" class="form-control" id="user-id-pass" readonly>
        </div>
        <div class="form-group">
          <label for="oldPass">Enter your current password</label>
          <input type="password" class="form-control" id="oldPass" required>
          <div id="oldPass-feed" class="invalid-feedback">Incorrect password</div>
        </div>
        <div class="form-group">
          <label for="pass1">Enter your new password</label>
          <input name="password" type="password" class="form-control" id="pass1" required maxlength="70">
          <div id="pass1-feed" class="invalid-feedback"></div>
          <small id="passwordHelp" class="form-text text-muted">
            Your password must be 8-70 characters long, contain one capital and one lowercase letter and a number
          </small>
        </div>
        <div class="form-group">
          <label for="pass2">Re-enter your password</label>
          <input type="password" class="form-control" id="pass2" required maxlength="70">
          <div id="pass2-feed" class="invalid-feedback">The passwords must match</div>
        </div>
        <button id="save-pass" class="btn btn-outline-success float-right">Update</button>
      </form>
    </section>

    <p>1</p>
    <p>2</p>
    <p>3</p>
    <p>4</p>
    <p>5</p>
    <p>6</p>
    <p>7</p>
    <p>8</p>
    <p>9</p>
    <p>10</p>
    <p>11</p>
    <p>12</p>
    <p>13</p>
    <p>14</p>
    <p>15</p>
    <p>16</p>
    <p>17</p>
    <p>18</p>
    <p>19</p>
    <p>20</p>
    <p>21</p>
    <p>22</p>
    <p>23</p>
    <p>24</p>
    <p>25</p>
    <p>26</p>
    <p>27</p>
    <p>28</p>
    <p>29</p>
    <p>30</p>
  </main>

  <footer ng-include="'./userfooter.html'" class="fixed-bottom d-flex justify-content-between align-items-center"></footer>

  <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  <script type="text/javascript" src="./resources/js/userprofile.js"></script>
</body>

</html>
