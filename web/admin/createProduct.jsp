<%@ page import="com.webappcafe.model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: STATHIS
  Date: 13/1/2019
  Time: 8:44 μμ
  To change this template use File | Settings | File Templates.
--%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="en" dir="ltr">

      <head>
        <meta charset="utf-8">
          <title>Create Product</title>
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
          <link rel="stylesheet" type="text/css" href="../resources/css/createproduct.css">
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
                <a id="logo" href="./dashboard" class="navbar-brand">Logo</a>
                <form class="form-inine" action="/" method="post">
                  <a id="logout-btn" href="../logoutFunction" class="btn btn-outline-secondary" type="submit">Logout</a>
                </form>
              </nav>
            </header>

            <section class="container mt-5">
              <h1 class="text-center">Create a Product</h1>
              <form id="create-form" class="mt-5" method="POST" novalidate="novalidate">
                <div class="form-group row">
                  <label for="product-name" class="col-sm-2 col-form-label col-form-label-lg">Name</label>
                  <div class="col-sm-10">
                    <input type="text" name="productName" class="form-control form-control-lg" maxlength="45" id="product-name" placeholder="Enter the product's name" required="required">
                      <div class="invalid-feedback">Please enter a product name</div>
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="product-price" class="col-sm-2 col-form-label col-form-label-lg">Price</label>
                    <div class="col-sm-10">
                      <input type="number" name="price" step="0.01" class="form-control form-control-lg" id="product-price" min="0.01" max="99.99" placeholder="Enter the product's price" required="required">
                        <div class="invalid-feedback">Please enter a price from 0.01 to 99.99</div>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="product-descr" class="col-sm-2 col-form-label col-form-label-lg">Description</label>
                      <div class="col-sm-10">
                        <textarea name="description" class="form-control form-control-lg" id="product-descr" rows="3" maxlength="150" placeholder="Enter the product's description" required="required"></textarea>
                        <div class="invalid-feedback">Please enter a product description</div>
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
                          <h5 class="modal-title" id="successModalLabel">Create Product</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
                        <div class="modal-body">
                          <p>The product was created successfully!</p>
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
                  <script type="text/javascript" src="../resources/js/createproduct.js"></script>
              </body>

            </html>
