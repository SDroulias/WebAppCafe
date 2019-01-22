$(document).ready(function(){
  const $createBtn = $("#create-btn");
  const $modal = $("#successModal");
  const $form = $("#create-form");
  const $productName = $("#product-name");
  const $productPrice = $("#product-price");
  const $productDescr = $("#product-descr");

  $createBtn.click(function(e){
    e.preventDefault();
    $form.addClass("was-validated");
    if ($form[0].checkValidity()){
      $.post("crea",{productName: $productName.val(), price: $productPrice.val(), description: $productDescr.val()},
      function(){
        $modal.modal('show');
      });
    }
  });

});
