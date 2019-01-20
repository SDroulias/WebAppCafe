$(document).ready(function() {
  const $fname = $("#customer-fname");
  const $lname = $("#customer-lname");
  const $uname = $("#customer-uname");
  const $pswd = $("#pswd-register");
  const $passFeedback = $("#pass-val-feed");
  const $registerForm = $("#register-form");
  const $createBtn = $("#create-btn");
  const $modal = $("#successModal");
  let pswdCheck = false;

  function addInvalid(a) {
    if (!(a.hasClass("is-invalid"))) {
      a.removeClass("is-valid");
      a.addClass("is-invalid");
    }
  }

  function addValid(a) {
    if (!(a.hasClass("is-valid"))) {
      a.removeClass("is-invalid");
      a.addClass("is-valid");
    }
  }

  $pswd.focus(function(){
    $registerForm.removeClass("was-validated");
  });

  $pswd.keyup(function() {
    re1 = /[0-9]/;
    re2 = /[a-z]/;
    re3 = /[A-Z]/;
    if ($(this).val().length < 8) {
      $pswd.css("border-color", "#e73568");
      addInvalid($(this));
      $passFeedback.html("Your password must be at least 8 characters long");
      pswdCheck = false;
    } else if (!re1.test($(this).val())) {
      $pswd.css("border-color", "#e73568");
      addInvalid($(this));
      $passFeedback.html("Your password must contain at least one number");
      pswdCheck = false;
    } else if (!re2.test($(this).val())) {
      $pswd.css("border-color", "#e73568");
      addInvalid($(this));
      $passFeedback.html("Your password must contain at least one lowercase letter");
      pswdCheck = false;
    } else if (!re3.test($(this).val())) {
      $pswd.css("border-color", "#e73568");
      addInvalid($(this));
      $passFeedback.html("Your password must contain at least one uppercase letter");
      pswdCheck = false;
    } else {
      $pswd.css("border-color", "#28a745");
      addValid($(this));
      pswdCheck = true;
    }
  });

  // $registerForm.submit(function(e) {
  //   if (pswdCheck == false) {
  //     e.preventDefault();
  //   }
  // });

  $createBtn.click(function(e) {
    e.preventDefault();
    $registerForm.addClass("was-validated");
    if ($pswd.val().length == 0) {
      $passFeedback.html("Please enter the customer's password");
    }

    if (pswdCheck == false) {
      $pswd.css("border-color", "#e73568");
    }

    if ($registerForm[0].checkValidity() && pswdCheck == true) {
      $.post("createCustomer", {fname: $fname.val(), lname: $lname.val(), username: $uname.val(), password: $pswd.val()},
      function(){
        $modal.modal('show');
      });
      // $modal.modal('show');
    }
  });

});
