var app = angular.module('myApp', []);

$(document).ready(function(){
  $(".carousel").slick({
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
    arrows: false,
    draggable: false,
    pauseOnFocus: false,
    pauseOnHover: false
  });
});
