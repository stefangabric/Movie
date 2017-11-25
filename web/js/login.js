$(document).ready(function () {
    
    var button = $("#button");
    button.on("click", function (event) {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        
        $.ajax({
            url: "http://localhost:8080/Osa/api/auth/login",
            method: "POST",
            data:  {
			    'username': username,
			    'password': password
            },
            success: function (data) {
               if (data!=undefined) {
            	   sessionStorage.setItem('zanr',data.category.id);
            	   sessionStorage.setItem('zanrime',data.category.name);
                   sessionStorage.setItem('osoba',data.id);
                   if (data.category.name=='admin') {
                   	window.location.href="http://localhost:8080/Osa/Ameni.html";
                       
   				}
                   else{
                   	window.location.href="http://localhost:8080/Osa/Mmeni.html";
                       
                   }
			}
                },
            error: function (request, options, error) {
                alert(request);
                alert(error.stack);
                window.location.href="http://localhost:8080/Osa/login.html";
            }
        });

        event.preventDefault();
	    return false;
    });
    

});
