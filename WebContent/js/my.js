$('#signin').click(function() {
//  alert($("#loginForm").attr("action"));
//  alert($("#email").val());
//  alert($("#password").val());
  //alert($("#password").attr("action"));



var url = $("#loginForm").attr("action");
var email = $("#email").val();
var password = $("#password").val();
var data = {email:email,password:password}
function success(result){
	if(result == "true"){
		location.reload();
	}
}
$.ajax({
  url: url,
  data: data,
  success: success
});


}); 

