$(document).ready(function (e) {
	var zanr=sessionStorage.getItem("zanr");
	$("#kat").val(zanr);
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
});