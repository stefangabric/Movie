$(document).ready(function (e) {
	var id = window.location.toString().split('=')[1];

	$.ajax({
		url: "http://localhost:8080/Osa/api/users/"+id,
		method:"get",
		data: {'id':id},
		dataType: "json",
		success: function(data) {
			e.stopPropagation;
			kor=data;

			$("#id").val(id);
			$("#ime").val(kor.fname);
			$("#prezime").val(kor.lname);
			$("#kime").val(kor.username);
			$("#pass").val(kor.password);
	           },
		error: function(request, options, error) {
				alert(error);
		}
	});
	$.ajax({
		url: "http://localhost:8080/Osa/api/categories",
		dataType: "json",
		success: function(data) {
			e.stopPropagation;
		 	for(var i=0; i<data.length; i++) {
			    slika = data[i];
			    var newLika = $("<option value="+slika.id+">"+slika.name+"</option>");
				newLika.data("id",slika.id);
				$("#cat").append(newLika)
		 	
		 	}
           },
		error: function(request, options, error) {
				alert(error);
		}
	}); 
});