var app = angular.module('myApp', []);

// NOTE!!!

// in for each get name price quantity and create dynamically
// the content of the checkout modal

// for quantity after click for these inputs prop require true?

// how to validate the whole form

$(document).ready(function() {
  $beforeOrderBtn = $("#before-order-btn");

  $("input[type=checkbox]").click(function(){
    $(this).parents(".form-row").toggleClass("toggle-checkbox");
  });

  $($beforeOrderBtn).click(function() {
    let products;
    let cart = {};
    let array = [];
    let JSONcart = {};
    let checked = $("input:checked");
    checked.each(function(i, elem) {
      products = {};
      let id = $(elem).parents(".form-group").siblings(".id").text();
      let quantity = $(elem).parents(".form-group").siblings(".quantity").val();
      //cart[id] = quantity;
      products.id = id;
      products.quantity = quantity;
      array.push(products);
    });
    // let cart = {products: array};
    // cart.products = array;
    cart = {products: array};
    console.log(cart);
    JSONcart = JSON.stringify(cart);
    // console.log(JSONcart);
    $.post("placeOrder", JSONcart);
    console.log(JSONcart);
  });
});
