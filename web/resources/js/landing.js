$(document).ready(function(){
  const $pswd1 = $("#pswd1-register");
  const $pswd2 = $("#pswd2-register");
  const $passFeedback = $("#pass-val-feed");
  const $pass2Feedback = $("#pass2-val-feed");
  const $registerForm = $("#register-form");
  let pswd1Check = false;

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
   } else if (!re1.test($(this).val())){
      addInvalid($(this));
      $passFeedback.html("Your password must contain at least one number");
      pswd1Check = false;
    } else if (!re2.test($(this).val())){
      addInvalid($(this));
      $passFeedback.html("Your password must contain at least one lowercase letter");
      pswd1Check = false;
    } else if (!re3.test($(this).val())){
      addInvalid($(this));
      $passFeedback.html("Your password must contain at least one uppercase letter");
      pswd1Check = false;
    } else {
      addValid($(this));
      pswd1Check = true;
    }
  });

  $pswd2.keyup(function(){
    if ($pswd1.val() !== $(this).val() || $(this).val().length == 0){
      addInvalid($(this));
    } else {
      addValid($(this));
    }
  });

  $registerForm.submit(function(e){
    if (pswd1Check == false) {
      e.preventDefault();
    } else if ($pswd1.val() !== $pswd2.val()) {
      addInvalid($pswd2);
      $pass2Feedback.html("The passwords must match");
      e.preventDefault();
    }
  });

});