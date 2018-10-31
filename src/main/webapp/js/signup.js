function signup(){
	var firstName=$('#firstname').val();
	var lastName=$('#lastname').val();
	var email=$('#email').val();
	var password=$('#password').val();
	var data={
			"firstname":firstName,
			"lastname":lastName,
			"email":email,
			"password":password
	}
	$.ajax({
		url : "/signup",
		type : 'POST',
		contentType: "application/json",
		data : JSON.stringify(data),
		success : function(data) {
			if(data=="sucess"){
				window.location.assign("/login");
			}
		},
		error : function(data) {
			alert("something went wrong");
		}
	});
	
}