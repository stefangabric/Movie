
$(document).ready(function(e) {	

var zanr=sessionStorage.getItem("zanr");

var sifra=sessionStorage.getItem("osoba");
var tr='tr';
var td='td';
		$.ajax({
			url: "http://localhost:8080/Osa/api/movies",
			dataType: "json",
			data:  {
			    'zanr': zanr
            },
			success: function(data) {
			e.stopPropagation;
		 	for(var i=0; i<data.length; i++) {
			    slika = data[i];
			    var newLiku = $("<li>"+slika.title+"</li>");
			    newLiku.addClass("podatak");
				newLiku.data("id",slika.id);
				var OnewLiku = $("<li>"+slika.title+"</li>");
			    OnewLiku.addClass("podatak");
				OnewLiku.data("id",slika.id);
				newLiku.data("kt",1);
				$("#film").append(newLiku);
				OnewLiku.data("kt",2);
				$("#ofilm").append(OnewLiku);
				var newTru=$("<tr></tr>");
				var newTdu1=$("<td>"+slika.title+"</td>");
				var newTdu2=$("<td>"+slika.description+"</td>");
				var newTdu3=$("<td>"+slika.category_id.name+"</td>");
				var newTdu4=$("<td>"+slika.movieActors+"</td>");
				var newTdu5=$("<td>"+slika.movieProducent+"</td>");
				var newTdu6=$("<td>"+slika.movieDirector+"</td>");
				var newTdu7=$("<td>"+slika.language_id.name+"</td>");
				var newTdu8=$("<td>"+slika.country_id.name+"</td>");
				var newTdu9=$("<td>"+slika.movie_year+"</td>");
				var newTdu10=$("<td>"+slika.avgScore+"</td>");
				newTru.append(newTdu1);
				newTru.append(newTdu2);
				newTru.append(newTdu3);
				newTru.append(newTdu4);
				newTru.append(newTdu5);
				newTru.append(newTdu6);
				newTru.append(newTdu7);
				newTru.append(newTdu8);
				newTru.append(newTdu9);
				newTru.append(newTdu10);
				$("#tfilm").append(newTru)
		 	}
           },
		error: function(request, options, error) {
				alert(error);
		}
	});
		
	
	$("#film").on("click", ".podatak", function(e) {
		e.stopPropagation();
		cfilmrent = $(this);
		var sifra = cfilmrent.data("id");
		window.location="MIfilm.html?id="+sifra;
		event.preventDefault();
		return false;	 
	});
	$("#ofilm").on("click", ".podatak", function(e) {
		e.stopPropagation();
		cfilmrent = $(this);
		var sifra = cfilmrent.data("id");
		$.ajax({
            method:"delete",
            url : "http://localhost:8080/Osa/api/movies"+ '/'+ sifra ,
            data: {'id':sifra},
            success : function(data) {

        		alert("film je obrisan");
                window.location.href="http://localhost:8080/Osa/Mmeni.html";
            },
            error : function(request, options, error) {
                console.log("error je: "+ error+ " //////////////////////requset je"+ request.toString());
                     }
		}); 
	});		
//film
	$("#uifilm").on('mouseover',function(){
		  $("#uifilm").show();
	});
	$("#uifilm").on('mouseleave',function(){
			  $("#uifilm").hide();
	});
	$("#afilm").on('mouseover',function(){
		  $("#uifilm").show();
	});
	$("#afilm").on('mouseleave',function(){
			  $("#uifilm").hide();
	});

	
		$("#dfilm").click(function(event){
			window.location="MDfilm.html";
			event.preventDefault();
			return false;	 
		});
		$("#ifilm").on('mouseover',function(){
			  $("#film").show();
		});
		$("#ifilm").on('mouseleave',function(){
				  $("#film").hide();
		});
		$("#ofi").on('mouseover',function(){
			  $("#ofilm").show();
		});
		$("#ofi").on('mouseleave',function(){
			  $("#ofilm").hide();
		});

		$("#film").on('mouseover',function(){
			  $("#uifilm").show();
		});
		$("#film").on('mouseleave',function(){
			  $("#uifilm").hide();
		});
		$("#film").on('mouseover',function(){
			  $("#film").show();
		});
		$("#film").on('mouseleave',function(){
			  $("#film").hide();
		});
		
		$("#ofilm").on('mouseover',function(){
			  $("#uifilm").show();
		});
		$("#ofilm").on('mouseleave',function(){
			  $("#uifilm").hide();
		});
		$("#ofilm").on('mouseover',function(){
			  $("#ofilm").show();
		});
		$("#ofilm").on('mouseleave',function(){
			  $("#ofilm").hide();
		});
//TABELAAAA
		//
		//
		
		$("#afilm").on("click", function(e) {
			$(".table").hide();
			$("#tfilm").show();
		});
		$("#aod").click(function(event){
			sessionStorage.clear();
			window.location="http://localhost:8080/Osa/Meni.html";
			event.preventDefault();
			return false;	 
		});
		$("#apr").click(function(event){
			sessionStorage.clear();
			window.location="http://localhost:8080/Osa/profil.html?userName="+sifra;
			event.preventDefault();
			return false;	 
		});
});