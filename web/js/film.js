$(document).ready(function (e) {
	/*$("#submitae").on("click", function(e) {
			var naziv=$("#naziv").val();
			var opis=$("#opis").val();
			var direktor=$("#direktor").val();
			var producent=$("#producent").val();
			var godina=$("#godina").val();
			var glumci=$("#glumci").val();
			var kategorija=$("#kat").val();
			var zemlja=$("#zem").val();
			var jezik=$("#jez").val();
		$.ajax({
			method:"POST",
			url: "http://localhost:8080/Osa/api/movies/add",
			data:{'naziv':naziv,'opis':opis,'direktor':direktor,'producent':producent,'godina':godina,
				'glumci':glumci,'kategorija':kategorija,'zemlja':zemlja,'jezik':jezik},
			dataType: "json",
			success: function(data) {
				e.stopPropagation;
				window.location="Ameni.html";
			},
			error: function(request, options, error) {
				alert(error);
			}
		});
	});*/
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

	$.ajax({
		
		url: "http://localhost:8080/Osa/api/categories",
		dataType: "json",
		success: function(data) {
			e.stopPropagation;
			for(var i=0; i<data.length; i++) {
				slika = data[i];
				var newLika = $("<option value="+slika.id+">"+slika.name+"</option>");
				newLika.data("id",slika.id);
				$("#kat").append(newLika);

			}
		},
		error: function(request, options, error) {
			alert(error);
		}
	}); 

});