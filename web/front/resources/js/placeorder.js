var app = angular.module('myApp', []);

$(document).ready(function() {
  let JSONcart;
  const $beforeOrderBtn = $("#before-order-btn");
  const $orderModal = $("#orderModal");
  const $modalBody = $(".modal-body");
  const $placeOrderBtn = $("#place-order-btn");
  const $orderForm = $("#order-form");

  $("input[type=checkbox]").click(function() {
    $(this).parents(".form-row").toggleClass("toggle-checkbox");
    if ($(this).parents(".form-group").siblings(".quantity").prop("required") == true) {
      $(this).parents(".form-group").siblings(".quantity").prop("required", false);
    } else {
      $(this).parents(".form-group").siblings(".quantity").prop("required", true);
    }
  });

  $($beforeOrderBtn).click(function() {
    if ($orderForm[0].checkValidity() && $("input:checked").length > 0) {
      $modalBody.empty();
      let totalPrice = 0;
      let product;
      let cart = {};
      let products = [];
      JSONcart = {};
      let checked = $("input:checked");
      checked.each(function(i, elem) {
        product = {};
        let id = $(elem).parents(".form-group").siblings(".id").text();
        let name = $(elem).parents(".form-group").siblings(".name").text();
        let price = parseFloat($(elem).parents(".form-group").siblings(".price").text());
        let quantity = $(elem).parents(".form-group").siblings(".quantity").val();
        //cart[id] = quantity;
        totalPrice += quantity * price;
        product.id = id;
        product.quantity = quantity;
        products.push(product);
        $modalBody.append(`<p>${name} ${quantity} x ${price}&euro;</p>`);
      });
      totalPrice = Math.round(totalPrice*100)/100;
      $modalBody.append("<hr>");
      $modalBody.append(`<p class="float-right mb-0">Total Price: ${totalPrice}&euro;</p>`);
      $orderModal.modal('show');
      cart = {
        products: products
      };
      JSONcart = JSON.stringify(cart);
    }
  });

  $placeOrderBtn.click(function() {
    $.post("placeOrder", JSONcart, // the url to post to is placeOrder. Change to whatever you need
      function() {
        $orderModal.modal('hide');
        $(".alert").show();
        setTimeout(function() {
          window.location.assign("userlanding.html");
        }, 2000);
      });
  });
});
