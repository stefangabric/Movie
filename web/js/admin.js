
$(document).ready(function(e) {	
var tr='tr';
var td='td';
	$.ajax({
		url: "http://localhost:8080/Osa/api/users",
		dataType: "json",
		success: function(data) {
			e.stopPropagation;
		 	for(var i=0; i<data.length; i++) {
			    slika = data[i];
			    var newLik = $("<li>"+slika.username+"</li>");
			    newLik.addClass("podatak");
				newLik.data("userName",slika.username);
				newLik.data("tip",slika.category);
				newLik.data("id",slika.id);
				var OnewLik = $("<li>"+slika.username+"</li>");
				OnewLik.addClass("podatak");
				OnewLik.data("userName",slika.username);
				OnewLik.data("tip",slika.category);
				OnewLik.data("id",slika.id);
				$("#korisnik").append(newLik)
				$("#okorisnik").append(OnewLik);
				var newTrkk=$("<tr></tr>");
				var newTd1=$("<td>"+slika.fname+"</td>");
				var newTd2=$("<td>"+slika.lname+"</td>");
				var newTd3=$("<td>"+slika.username+"</td>");
				var newTd4=$("<td>"+slika.pass+"</td>");
				var newTd5=$("<td>"+slika.category.name+"</td>");
				newTrkk.append(newTd1);
				newTrkk.append(newTd2);
				newTrkk.append(newTd3);
				newTrkk.append(newTd4);
				newTrkk.append(newTd5);
				$("#tkoris").append(newTrkk)
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
			    var newLika = $("<li>"+slika.name+"</li>");
			    newLika.addClass("podatak");
				newLika.data("id",slika.id);
				var OnewLika = $("<li>"+slika.name+"</li>");
			    OnewLika.addClass("podatak");
				OnewLika.data("id",slika.id);
				$("#kategorija").append(newLika);
				$("#okategorija").append(OnewLika);
				var newTrkg=$("<tr></tr>");
				var newTd1=$("<td>"+slika.id+"</td>");
				var newTd2=$("<td>"+slika.name+"</td>");
				newTrkg.append(newTd1);
				newTrkg.append(newTd2);
				$("#tkateg").append(newTrkg)
		 	
		 	}
           },
		error: function(request, options, error) {
				alert(error);
		}
	});
	
	
		$.ajax({
			url: "http://localhost:8080/Osa/api/movies",
			dataType: "json",
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
		window.location="Ifilm.html?id="+sifra;
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
                window.location.href="http://localhost:8080/Osa/Ameni.html";
            },
            error : function(request, options, error) {
                console.log("error je: "+ error+ " //////////////////////requset je"+ request.toString());
                     }
		}); 
	});
	
	

	$("#kategorija").on("click", ".podatak", function(e) {
		e.stopPropagation();
		cfilmrent = $(this);
		var sifra = cfilmrent.data("id");
		window.location="Ikategoriju.html?id="+sifra;
		event.preventDefault();
		return false;	 
	});
	
	
	$("#okategorija").on("click", ".podatak", function(e) {
		e.stopPropagation();
		cfilmrent = $(this);
		var sifra = cfilmrent.data("id");
		$.ajax({
            method:"delete",
            url : "http://localhost:8080/Osa/api/categories"+ '/'+ sifra ,
            data: {'id':sifra},
            success : function(data) {
        		alert("film je obrisan");
                window.location.href="http://localhost:8080/Osa/Ameni.html";
            },
            error : function(request, options, error) {
                console.log("error je: "+ error+ " //////////////////////requset je"+ request.toString());
                     }
		});
	});
	

	$("#korisnik").on("click", ".podatak", function(e) {
		e.stopPropagation();
		cfilmrent = $(this);
		var sifra = cfilmrent.data("id");
		window.location="Ikorisnik.html?userName="+sifra;
		event.preventDefault();
		return false;	 
	});
	$("#okorisnik").on("click", ".podatak", function(e) {
		e.stopPropagation();
		cfilmrent = $(this);
		var sifra = cfilmrent.data("id");
		alert("nesroooo");
		alert("http://localhost:8080/Osa/api/users"+ '/'+ sifra);
		$.ajax({
            method:"delete",
            url : "http://localhost:8080/Osa/api/users"+ '/'+ sifra ,
            data: {'id':sifra},
            success : function(data) {

        		alert("film je obrisan");
                window.location.href="http://localhost:8080/Osa/Ameni.html";
            },
            error : function(request, options, error) {
                console.log("error je: "+ error+ " //////////////////////requset je"+ request.toString());
                     }
		});
	});

		//korisnik
	$("#uitkor").on('mouseover',function(){
		  $("#uitkor").show();
	});
	$("#uitkor").on('mouseleave',function(){
			  $("#uitkor").hide();
	});
	$("#akor").on('mouseover',function(){
		  $("#uitkor").show();
	});
	$("#akor").on('mouseleave',function(){
			  $("#uitkor").hide();
	});

	$("#dtkor").click(function(event){
		window.location="Dkorisnik.html";
		event.preventDefault();
		return false;	 
	});

	$("#ikor").on('mouseover',function(){
		  $("#korisnik").show();
	});
	$("#ikor").on('mouseleave',function(){
			  $("#korisnik").hide();
	});
	$("#okor").on('mouseover',function(){
		  $("#okorisnik").show();
	});
	$("#okor").on('mouseleave',function(){
		  $("#okorisnik").hide();
	});

	$("#korisnik").on('mouseover',function(){
		  $("#uitkor").show();
	});
	$("#korisnik").on('mouseleave',function(){
		  $("#uitkor").hide();
	});
	$("#korisnik").on('mouseover',function(){
		  $("#korisnik").show();
	});
	$("#korisnik").on('mouseleave',function(){
		  $("#korisnik").hide();
	});
	
	$("#okorisnik").on('mouseover',function(){
		  $("#uitkor").show();
	});
	$("#okorisnik").on('mouseleave',function(){
		  $("#uitkor").hide();
	});
	$("#okorisnik").on('mouseover',function(){
		  $("#okorisnik").show();
	});
	$("#okorisnik").on('mouseleave',function(){
		  $("#okorisnik").hide();
	});
	
			//kategorija
		$("#uikat").on('mouseover',function(){
			  $("#uikat").show();
		});
		$("#uikat").on('mouseleave',function(){
				  $("#uikat").hide();
		});
		$("#akat").on('mouseover',function(){
			  $("#uikat").show();
		});
		$("#akat").on('mouseleave',function(){
				  $("#uikat").hide();
		});
	
		$("#dkat").click(function(event){
			window.location="Dkategoriju.html";
			event.preventDefault();
			return false;	 
		});
	
		$("#ikat").on('mouseover',function(){
			  $("#kategorija").show();
		});
		$("#ikat").on('mouseleave',function(){
				  $("#kategorija").hide();
		});
		$("#okat").on('mouseover',function(){
			  $("#okategorija").show();
		});
		$("#okat").on('mouseleave',function(){
			  $("#okategorija").hide();
		});

		$("#kategorija").on('mouseover',function(){
			  $("#uikat").show();
		});
		$("#kategorija").on('mouseleave',function(){
			  $("#uikat").hide();
		});
		$("#kategorija").on('mouseover',function(){
			  $("#kategorija").show();
		});
		$("#kategorija").on('mouseleave',function(){
			  $("#kategorija").hide();
		});
		
		$("#okategorija").on('mouseover',function(){
			  $("#uikat").show();
		});
		$("#okategorija").on('mouseleave',function(){
			  $("#uikat").hide();
		});
		$("#okategorija").on('mouseover',function(){
			  $("#okategorija").show();
		});
		$("#okategorija").on('mouseleave',function(){
			  $("#okategorija").hide();
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
			window.location="Dfilm.html";
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
		
		$("#akor").on("click", function(e) {
			$(".table").hide();
			$("#tkoris").show();
		});
		$("#akat").on("click", function(e) {
			$(".table").hide();
			$("#tkateg").show();
		});
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
			var sifra=sessionStorage.getItem("osoba");
			window.location="Ikorisnik.html?userName="+sifra;
			event.preventDefault();
			return false;	 
		});
		

});