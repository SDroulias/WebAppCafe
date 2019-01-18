$(document).ready(function(){
  const $editForm = $("#edit-form");
  const $submitBtn = $("#submit-edit");
  const $editBtn = $(".edit-btn");
  const $deleteBtn = $(".delete-btn");
  const $formId = $("#product-id");
  const $formName = $("#product-name");
  const $formPrice = $("#product-price");
  const $formDescr = $("#product-descr");
  
  $deleteBtn.click(function(){
    $deleteId = $(this).parent().siblings(".id");
//    $.post("deleteProduct", {id: $deleteId.html()});
    
    $.ajax({
    type: "POST",
    url: "setProductUnavailable",
    data: {id: $deleteId.html()},
    success: function() {   
        location.reload(true);  
    }
    });
  });

  $editBtn.click(function(){
    $id = $(this).parent().siblings(".id");
    $name = $(this).parent().siblings(".name");
    $price = $(this).parent().siblings(".price");
    $descr = $(this).parent().siblings(".descr");

    $formId.val($id.html());

    $formName.prop("disabled",false);
    $formName.val($name.html());

    $formPrice.prop("disabled",false);
    $formPrice.val(parseFloat($price.html()));

    $formDescr.prop("disabled",false);
    $formDescr.val($descr.html());

    $submitBtn.prop("disabled", false);

  });

  $editForm.submit(function(e){
    e.preventDefault();
    this.submit();
    setTimeout(function(){
      $submitBtn.prop("disabled", true);
      $formId.prop("disabled",true);
      $formName.prop("disabled",true);
      $formPrice.prop("disabled",true);
      $formDescr.prop("disabled",true);
      $formId.val('');
      $formName.val('');
      $formPrice.val('');
      $formDescr.val('');
    }, 1);

  });
});
