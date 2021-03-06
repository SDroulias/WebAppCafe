<!DOCTYPE html>
<html lang="en" dir="ltr">

  <head>
    <meta charset="utf-8">
      <title>Admin Panel</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../resources/css/createcustomer.css"></head>

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
                  <a id="logo" href="./dashboard" class="navbar-brand">Logo</a>
                  <form class="form-inine" action="/" method="post">
                    <a id="logout-btn" href="../logoutFunction" class="btn btn-outline-secondary" type="submit">Logout</a>
                  </form>
                </nav>
              </header>

              <section class="container mt-5">
                <h1 class="text-center">Create Customer</h1>
                <form id="register-form" class="mt-5" method="POST">
                  <div class="form-group row">
                    <label for="customer-fname" class="col-sm-2 col-form-label col-form-label-lg">First Name</label>
                    <div class="col-sm-10">
                      <input type="text" name="fname" class="form-control form-control-lg" maxlength="45" id="customer-fname" placeholder="Enter the customer's name" required="required">
                        <div class="invalid-feedback">Please enter the customer's name</div>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="customer-lname" class="col-sm-2 col-form-label col-form-label-lg">Last Name</label>
                      <div class="col-sm-10">
                        <input type="text" name="lname" class="form-control form-control-lg" maxlength="45" id="customer-lname" placeholder="Enter the customer's surname" required="required">
                          <div class="invalid-feedback">Please enter the customer's surname</div>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="customer-uname" class="col-sm-2 col-form-label col-form-label-lg">Username</label>
                        <div class="col-sm-10">
                          <input type="text" name="username" class="form-control form-control-lg" maxlength="45" id="customer-uname" placeholder="Enter the customer's username" required="required">
                            <div class="invalid-feedback">Please enter the customer's username</div>
                            <p id="register-fail"></p>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="pswd-register" class="col-sm-2 col-form-label col-form-label-lg">Password</label>
                          <div class="col-sm-10">
                            <input name="password" type="password" class="form-control form-control-lg" id="pswd-register" placeholder="Enter the customer's password" maxlength="70" required="required">
                              <div id="pass-val-feed" class="invalid-feedback"></div>
                              <small id="passwordHelp" class="form-text text-muted">
                                The password must be 8-70 characters long, contain one capital and one lowercase letter and a number
                              </small>
                            </div>
                          </div>
                          <div class="form-group row justify-content-end">
                            <div class="col-sm-2">
                              <input id="create-btn" class="btn btn-outline-dark w-100" type="submit" value="Create"></div>
                            </div>
                          </form>
                        </section>

                        <div class="modal fade" id="successModal" tabindex="-1" role="dialog" aria-labelledby="successModalLabel" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="successModalLabel">Create Customer</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                              </div>
                              <div class="modal-body">
                                <p>The customer was created successfully!</p>
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Back</button>
                                <a id="dash-btn" href="dashboard" type="button" class="btn btn-primary">Dashboard</a>
                              </div>
                            </div>
                          </div>
                        </div>

                        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
                        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
                        <script type="text/javascript" src="../resources/js/createcustomer.js"></script>
                      </body>

                    </html>
