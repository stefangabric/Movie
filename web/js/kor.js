$(document).ready(function (e) {
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