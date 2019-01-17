$(document).ready(function(){
  const $deleteBtn = $(".delete-btn");

  $deleteBtn.click(function(){
    $deleteId = $(this).parent().siblings(".id");
    $.post("DeleteCustomerServlet", {id: $deleteId.html()});
  });
});
