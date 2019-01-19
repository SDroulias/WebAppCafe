<%@ page isELIgnored="false" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Admin Panel</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="./resources/css/viewcustomers.css">
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
    <h1 class="mb-5 mt-5 text-center">All Customers</h1>
    <table class="table table-striped">
      <thead id="thead">
        <tr>
          <th scope="col">Id</th>
          <th scope="col">First Name</th>
          <th scope="col">Last Name</th>
          <th scope="col" colspan="2">Username</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th class="id" scope="row">1</th>
          <td class="fname">stev</td>
          <td class="lname">drea</td>
          <td class="uname">fredericia</td>
          <td class="buttons"><button class="btn btn-outline-danger delete-btn">Delete</button></td>
        </tr>
        <tr>
          <th class="id" scope="row">2</th>
          <td class="fname">Jacob</td>
          <td class="lname">drea</td>
          <td class="uname">stef</td>
          <td class="buttons"><button class="btn btn-outline-danger delete-btn">Delete</button></td>
        </tr>
      </tbody>
    </table>
  </main>

  <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  <script type="text/javascript" src="./resources/js/viewcustomers.js">
  </script>
</body>

</html>
