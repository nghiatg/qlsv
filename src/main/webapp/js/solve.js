function insertStudent() {
		var studentId;
		var studentName;
		var studentSex;
		var studentDateOfBirth;
		var studentPlaceOfBirth;
		var tableStudent = $('#tableStudent');
		studentId = $('#studentId').val();
		studentName = $('#studentName').val();
		studentSex = $('#studentSex').val();
		studentDateOfBirth = $('#studentDate').val();
		studentPlaceOfBirth = $('#studentPlace').val();
		var classId = $('#studentClass option:selected').attr('value');
		var className = $('#studentClass option:selected').text();
		$.ajax({
			url : "/addOrUpdateStudent",
			type : 'POST',
			data : {
				"studentId" : studentId,
				"studentName" : studentName,
				"studentGender" : studentSex,
				"dateOfBirth" : studentDateOfBirth,
				"placeOfBirth" : studentPlaceOfBirth,
				"classId" : classId
			},
			success : function(data) {
				if (data == "success") {
					alert("succeed");
					tableStudent.append('<tr><td>' + studentId + '</td><td>'
							+ studentName + '</td><td>' + studentSex
							+ '</td><td>' + studentDateOfBirth + '</td><td>'
							+ studentPlaceOfBirth + '</td><td>' + className
							+ '</td><td><button id="update" type="button" onclick="updateOrder($(this));"class="btn btn-primary" data-toggle="modal"data-target="#myModal">Update</button></td><td><button id="dbtn" type="button" class="btn btn-primary"onclick="deleteOrder($(this));" data-toggle="modal"data-target="#myModalTwo">Delete</button></td></tr>');
				}
			},
			error : function(data) {
				alert("something went wrong");
			}
		});

}
function updateStudents() {
	var studentId;
	var studentName;
	var studentSex;
	var studentDateOfBirth;
	var studentPlaceOfBirth;
	var tableStudent = $('#tableStudent');
	studentId = $('#studentId').val();
	studentName = $('#studentName').val();
	studentSex = $('#studentSex').val();
	studentDateOfBirth = $('#studentDate').val();
	studentPlaceOfBirth = $('#studentPlace').val();
	var classId = $('#studentClass option:selected').attr('value');
	var className = $('#studentClass option:selected').text();
	$.ajax({
		url : "/addOrUpdateStudent",
		type : 'POST',
		data : {
			"studentId" : studentId,
			"studentName" : studentName,
			"studentGender" : studentSex,
			"dateOfBirth" : studentDateOfBirth,
			"placeOfBirth" : studentPlaceOfBirth,
			"classId" : classId
		},
		success : function(data) {
			if (data == "success") {
				alert("succeed");
				tableStudent.find('tr').each(function (i) {
        	        var $tds = $(this).find('td');
        	            var temp = $tds.eq(0).text();
        	            if(temp==studentId){
        	            	$tds.eq(1).html(studentName);
        	            	$tds.eq(2).html(studentSex);
        	            	$tds.eq(3).html(studentDateOfBirth);
        	            	$tds.eq(4).html(studentPlaceOfBirth);
        	            	$tds.eq(5).html(className);
        	            	return;
        	            }
				});
			}
		},
		error : function(data) {
			alert("something went wrong");
		}
    });
}
function updateStudent(x){
	    var rows=x.closest("tr");
	    var tableStudent=$('#tableStudent');
	    $('#studentId').val(rows.find(".studentId").text());
	    $('#studentName').val(rows.find(".studentName").text());
	    $('#studentSex').val(rows.find(".studentSex").text());
	    $('#studentDate').val(rows.find(".studentDateOfBirth").text());
	    $('#studentPlace').val(rows.find(".studentPlaceOfBirth").text());
	    $("#studentClass option").text(val(rows.find(".studentClass").text()));
}
function deleteStudent(params){
	 var rows=params.closest("tr");
	 var studentId=rows.find(".studentId").text();
	 var tableStudent=$('#tableStudent');
	 $.ajax({
	        url: "/deleteStudent",
	        type: 'Post',
	        data: {
	        	"studentId":studentId
	        },
	        success: function (data) {
	        	if(data=="successfully"){
	        		alert("delete Success");
	        		tableStudent.find('tr').each(function (i) {
	        	        var $tds = $(this).find('td');
	        	            var temp = $tds.eq(0).text();
	        	            if(temp==studentId){
	        	            	$(this).remove();
	        	            	return;
	        	            }
	        	       });	
	             }
	        }
	    });   
}
function searchStudent(param) {
	var key=param.val();
	 var tableStudent=$('#tableStudent');
	if(key.trim()==""){
		tableStudent.find('tr').each(function (i) {
	            $(this).show();
	       });	
	}
	else{
	 $.ajax({
	        url: "/searchStudent",
	        type: 'Post',
	        data: {
	        	"keySearch":key
	        },
	        success: function (data) {
	        		var res=data.split("_");
	        		tableStudent.find('tr').each(function (i) {
	        	        var $tds = $(this).find('td');
	        	            var temp = $tds.eq(1).text().trim();
	        	            var index=res.indexOf(temp);
	        	            if(res.indexOf(temp)<0){
	        	            	$(this).hide();
	        	            }
	        	            else{
	        	            	$(this).show();
	        	            }
	        	       });	
	        }
	    });
	}
}