
$(document).ready(function(e) {	
var tr='tr';
var td='td';
var buttonlist="";
	
	$.ajax({
			url: "http://localhost:8080/Osa/api/movies",
			dataType: "json",
			success: function(data) {
			e.stopPropagation;
		 	for(var i=0; i<data.length; i++) {
		 		slika=data[i];
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
				var newTdu11=$('<input min="0" max="100" type="number" id="skor '+slika.id+'" name="skor"></input>');
				var newTdu12=$('<button id="dodajskor '+slika.id+'" name="dodajskor">Dodaj unesen skor</button>')
				newTdu12.addClass("button");
				newTdu12.data("id",slika.id);
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
				newTru.append(newTdu11);
				newTru.append(newTdu12);
				$("#tfilm").append(newTru)
				
		 	}
			buttonlist=sessionStorage.getItem("lista");
		 	if(buttonlist==null){
				buttonlist ="";
				}
				else{
					if (buttonlist.length!=0) {
						var lista=buttonlist.split("|");
						for (i = 0; i < lista.length; i++) {
							if (document.getElementById(lista[i])!=null) {
								document.getElementById(lista[i]).disabled=true;
							}
						}
					}
				}
           },
		error: function(request, options, error) {
				alert(error);
		}
	});
	
//TABELAAAA
		//
		//
		
		$("#tfilm").on("click", ".button", function(e) {
			e.stopPropagation();
			current = $(this);
			var sifra = current.data("id");
			var stringSkor='skor '+sifra;
			var skor=document.getElementById(stringSkor).value;
			$.ajax({
				url: "http://localhost:8080/Osa/api/scores/add",
				method: "POST",
				data:  {
				    'sifra': sifra,
				    'score': skor
	            },
				dataType: "json",
				success: function(data) {
					buttonlist=sessionStorage.getItem("lista");
					var komad='dodajskor '+sifra;
					buttonlist=buttonlist+komad+"|";
					sessionStorage.setItem("lista",buttonlist);
					document.getElementById("dodajskor "+sifra).disabled=true;
			 	},
			error: function(request, options, error) {
					alert(error);
			}
		});
			event.preventDefault();
			return false;	 
		});
});