$(document).ready(function (e) {
	var id = window.location.toString().split('=')[1];

	$.ajax({
		url: "http://localhost:8080/Osa/api/movies/"+id,
		method:"get",
		data: {'id':id},
		dataType: "json",
		success: function(data) {
			e.stopPropagation;
			film=data;
			$("#naziv").val(film.title);
			$("#id").val(id);
			$("#opis").val(film.description);
			$("#godina").val(film.movie_year);
			$("#direktor").val(film.movieDirector);
			$("#producent").val(film.movieProducent);
			$("#glumci").val(film.movieActors);
			document.getElementById("#id").readOnly = true;
	           },
		error: function(request, options, error) {
				alert(error);
		}
	});
	$.ajax({
		url: "http://localhost:8080/Osa/api/countries",
		dataType: "json",
		success: function(data) {
			e.stopPropagation;
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
	var zanr=sessionStorage.getItem("zanr");
	$("#kat").val(zanr);
	
});