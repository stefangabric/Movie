$(document).ready(function (e) {
	var id = window.location.toString().split('=')[1];
	$.ajax({
		url: "http://localhost:8080/Osa/api/categories/"+id,
		method:"get",
		data: {'id':id},
		dataType: "json",
		success: function(data) {
			e.stopPropagation;
			cat=data;
			$("#id").val(cat.id);
			$("#naziv").val(cat.name);
			document.getElementById("#id").readOnly = true;
	           },
		error: function(request, options, error) {
				alert(error);
		}
	});
	
});