$(document).ready(function(){
  const $updateBtn = $(".update-btn");
  console.log($updateBtn);

  $updateBtn.click(function(){
    $updateId = $(this).parent().siblings().children(".id");
    $.post("UpdateOrder", {id: $updateId.html()});
  });
});
