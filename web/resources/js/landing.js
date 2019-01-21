$(document).ready(function(){
  const $pswd1 = $("#pswd1-register");
  const $pswd2 = $("#pswd2-register");
  const $passFeedback = $("#pass-val-feed");
  const $pass2Feedback = $("#pass2-val-feed");
  const $regUnameFeed = $("#uname-val-feed");
  const $loginBtn = $("#login-submit");
  const $registerBtn = $("#register-submit");
  const $username = $("#username-login");
  const $loginPass = $("#pswd-login");
  const $loginFail = $("#login-fail");
  const $registerForm = $("#register-form");
  const $loginForm = $("#login-form");

  const $regUsername = $("#username-register");
  const $regFname = $("#fname-register");
  const $regLname = $("#lname-register");
  const $regFail = $("#register-fail");

  let pswd1Check = false;

  $(".carousel").slick({
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
    arrows: false,
    draggable: false,
    pauseOnFocus: false,
    pauseOnHover: false
  });

  function addInvalid(a) {
    if (!(a.hasClass("is-invalid"))){
        a.removeClass("is-valid");
        a.addClass("is-invalid");
    }
  }

  function addValid(a) {
    if (!(a.hasClass("is-valid"))){
        a.removeClass("is-invalid");
        a.addClass("is-valid");
    }
  }

  $pswd1.keyup(function(){
    re1 = /[0-9]/;
    re2 = /[a-z]/;
    re3 = /[A-Z]/;
    if ($(this).val().length < 8) {
     addInvalid($(this));
     $passFeedback.html("Your password must be at least 8 characters long");
     pswd1Check = false;
     $pswd1.css("border-color", "#dc3545");
   } else if (!re1.test($(this).val())){
      addInvalid($(this));
      $passFeedback.html("Your password must contain at least one number");
      pswd1Check = false;
      $pswd1.css("border-color", "#dc3545");
    } else if (!re2.test($(this).val())){
      addInvalid($(this));
      $passFeedback.html("Your password must contain at least one lowercase letter");
      pswd1Check = false;
      $pswd1.css("border-color", "#dc3545");
    } else if (!re3.test($(this).val())){
      addInvalid($(this));
      $pswd1.css("border-color", "#dc3545");
      $passFeedback.html("Your password must contain at least one uppercase letter");
      pswd1Check = false;
    } else {
      addValid($(this));
      pswd1Check = true;
      $pswd1.css("border-color", "#28a745");
    }

    if ($(this).val() === $pswd2.val()) {
      $pswd2.css("border-color", "#28a745");
    } else {
      $pswd2.css("border-color", "#dc3545");
    }
  });

  $pswd2.keyup(function(){
    if ($pswd1.val() !== $(this).val() || $(this).val().length == 0){
      addInvalid($(this));
      $pswd2.css("border-color", "#dc3545");
    } else {
      addValid($(this));
      $pswd2.css("border-color", "#28a745");
    }
  });

  $pswd1.focus(function(){
    $registerForm.removeClass("was-validated");
  });

  $pswd2.focus(function(){
    $registerForm.removeClass("was-validated");
  });

  $regUsername.focus(function(){
    $(this).removeClass("login-fail");
    $regFail.empty();
  });

  // $registerForm.submit(function(e){
  //   if (pswd1Check == false) {
  //     e.preventDefault();
  //   } else if ($pswd1.val() !== $pswd2.val()) {
  //     addInvalid($pswd2);
  //     $pass2Feedback.html("The passwords must match");
  //     e.preventDefault();
  //   }
  // });

  $registerBtn.click(function(e){
    e.preventDefault();
    $registerForm.addClass("was-validated");
    if ($regUsername.val().length == 0) {
      $regUnameFeed.html("Please enter a username");
    }
    if ($pswd1.val().length == 0) {
      $pswd1.addClass("login-fail");
      $passFeedback.html("Please enter a password");
    }
    if ($pswd1.val() !== $pswd2.val()) {

      $pswd2.css("border-color", "#dc3545");
      $pass2Feedback.html("The passwords must match");
    }

    if (pswd1Check == false) {
      $pswd1.css("border-color", "#dc3545");
    }

    if (pswd1Check == true && $pswd1.val() === $pswd2.val() && $registerForm[0].checkValidity()) {
      console.log("I WILL POST");


      $.post("registrationFunction", {username: $regUsername.val(), fname: $regFname.val(),
      lname: $regLname.val(), pswd: $pswd1.val()},
      function(result){
        if (result == 'true') {
          console.log("THE CUSTOMER WAS REGISTERD");
          window.location.assign("index.jsp");
        } else {
          console.log("THIS USERNAME EXISTS");
          $registerForm.removeClass("was-validated");
          $regUsername.addClass("login-fail");
          $regFail.html("This username is unavailable");
        }
      });
    }
  });

  $username.focus(function(){
    $username.removeClass("login-fail");
    $loginPass.removeClass("login-fail");
    $loginFail.empty();
  });

  $loginPass.focus(function(){
    $username.removeClass("login-fail");
    $loginPass.removeClass("login-fail");
    $loginFail.empty();
  });

  $loginBtn.click(function(e) {
    e.preventDefault();
    $loginForm.addClass("was-validated");
    if ($loginForm[0].checkValidity()) {
      $.post("loginFunction", {
          username: $username.val(),
          password: $loginPass.val()
        },
        function(result) {
          console.log(result);
          if (result == 'customer') {
            // console.log("IT IS TRUE");
            window.location.assign("index.jsp");
          } else if (result == 'root') {
            window.location.assign("admin/dashboard.jsp");
          } else {
            // console.log("IT IS FALSE");
            // window.location.assign("loginfailure.jsp");
            $loginForm.removeClass("was-validated");
            $loginFail.html("Invalid username or password");
            $username.addClass("login-fail");
            $loginPass.addClass("login-fail");
          }
        });
    }
  });

});
