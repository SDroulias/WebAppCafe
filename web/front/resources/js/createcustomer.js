$(document).ready(function() {
  const $pswd = $("#pswd-register");
  const $passFeedback = $("#pass-val-feed");
  const $registerForm = $("#register-form");
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

  $pswd.keyup(function() {
    re1 = /[0-9]/;
    re2 = /[a-z]/;
    re3 = /[A-Z]/;
    if ($(this).val().length < 8) {
      addInvalid($(this));
      $passFeedback.html("Your password must be at least 8 characters long");
      pswdCheck = false;
    } else if (!re1.test($(this).val())) {
      addInvalid($(this));
      $passFeedback.html("Your password must contain at least one number");
      pswdCheck = false;
    } else if (!re2.test($(this).val())) {
      addInvalid($(this));
      $passFeedback.html("Your password must contain at least one lowercase letter");
      pswdCheck = false;
    } else if (!re3.test($(this).val())) {
      addInvalid($(this));
      $passFeedback.html("Your password must contain at least one uppercase letter");
      pswdCheck = false;
    } else {
      addValid($(this));
      pswdCheck = true;
    }
  });

  $registerForm.submit(function(e) {
    if (pswdCheck == false) {
      e.preventDefault();
    }
  });

});
