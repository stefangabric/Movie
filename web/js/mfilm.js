$(document).ready(function (e) {

	var zanr=sessionStorage.getItem("zanr");
	$("#kat").val(zanr);
	$.ajax({
		url: "http://localhost:8080/Osa/api/countries",
		dataType: "json",
		success: function(data) {
			for(var i=0; i<data.length; i++) {
				slika = data[i];
				var newLika = $("<option value="+slika.id+">"+slika.name+"</option>");
				newLika.data("id",slika.id);
				$("#zem").append(newLika)

			}
		},
		error: function(request, options, error) {
			alert(error);
		}
	}); 
	$.ajax({
		url: "http://localhost:8080/Osa/api/languages",
		dataType: "json",
		success: function(data) {
			e.stopPropagation;
			for(var i=0; i<data.length; i++) {
				slika = data[i];
				var newLika = $("<option value="+slika.id+">"+slika.name+"</option>");
				newLika.data("id",slika.id);
				$("#jez").append(newLika)

			}
		},
		error: function(request, options, error) {
			alert(error);
		}
	}); 

});