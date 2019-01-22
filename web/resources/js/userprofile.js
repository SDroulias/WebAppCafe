var app = angular.module('myApp', []);

$(document).ready(function(){
  const $userForm = $("#user-form");
  const $passForm = $("#pass-form");
  const $uidUpdate = $("#user-id-update");
  const $fname = $("#fname");
  const $lname = $("#lname");
  const $saveUserBtn = $("#save-user");
  const $updateUserBtn = $("#update-user");
  const $uidPass = $("#user-id-pass");
  const $oldPass = $("#oldPass");
  const $oldPassFeed = $("#oldPass-feed");
  const $pass1 = $("#pass1");
  const $pass1Feed = $("#pass1-feed");
  const $pass2 = $("#pass2");
  const $savePassBtn = $("#save-pass");
  let oldPassIsVal = false;
  let pass1IsVal = false;
  let pass2IsVal = false;

  console.log($saveUserBtn);
  console.log("IN JS");



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

  $updateUserBtn.click(function(e){
    console.log("click");
    e.preventDefault();
    $fname.prop("disabled", false);
    $lname.prop("disabled", false);
    $saveUserBtn.prop("disabled", false);
  });

  $saveUserBtn.click(function(){
    console.log("clicked save user");
    if ($userForm[0].checkValidity()) {
      $.ajax({
        type: "POST",
        url: "editCustomerFnameLname", // Enter the url for the update of user fname and lname
        data: {fname: $fname.val(), lname: $lname.val()},
        success: function(){
          location.reload(true);
        }
      });
    }
  });

  $pass1.keyup(function(){
    re1 = /[0-9]/;
    re2 = /[a-z]/;
    re3 = /[A-Z]/;
    if ($(this).val().length < 8) {
     addInvalid($(this));
     $pass1Feed.html("Your password must be at least 8 characters long");
     pass1IsVal = false;
   } else if (!re1.test($(this).val())){
      addInvalid($(this));
      $pass1Feed.html("Your password must contain at least one number");
      pass1IsVal = false;
    } else if (!re2.test($(this).val())){
      addInvalid($(this));
      $pass1Feed.html("Your password must contain at least one lowercase letter");
      pass1IsVal = false;
    } else if (!re3.test($(this).val())){
      addInvalid($(this));
      $pass1Feed.html("Your password must contain at least one uppercase letter");
      pass1IsVal = false;
    } else {
      addValid($(this));
      pass1IsVal = true;
    }
  });

  $pass2.keyup(function(){
    if ($pass1.val() !== $(this).val() || $(this).val().length == 0){
      addInvalid($(this));
      pass2IsVal = false;
    } else {
      addValid($(this));
      pass2IsVal = true;
    }
  });

  $savePassBtn.click(function(){
    if ($oldPass.val() === userPass) {
      addValid($oldPass);
      oldPassIsVal = true;
    } else {
      addInvalid($oldPass);
      oldPassIsVal = false;
    }

    if ($pass1.val() !== $pass2.val()) {
      addInvalid($pass2);
      pass2IsVal = false;
    } else {
      addValid($pass2);
      pass2IsVal = true;
    }

    console.log(oldPassIsVal);

    if (oldPassIsVal && pass1IsVal && pass2IsVal) {
      $.ajax({
        type: "POST",
        url: "editCustomerPassword", // Enter url for user password update
        data: {password: $pass1.val()},
        success: function(){
          location.reload(true);
        }
      });
    }
  });

});
