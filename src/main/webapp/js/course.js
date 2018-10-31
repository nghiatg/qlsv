function insertCourse(){
	var courseId;
	var courseName;
	var tableStudent = $('#tableStudent');
	courseId = $('#courseId').val();
	courseName = $('#courseName').val();
	$.ajax({
		url : "/addOrUpdateCourse",
		type : 'POST',
		data : {
			"courseId" : courseId,
			"courseName" : courseName
		},
		success : function(data) {
			if (data == "success") {
				alert("succeed");
				tableStudent.append('<tr><td>' + courseId + '</td><td>'
						+ courseName + '</td>'+'<td><button id="update" type="button" onclick="updateOrder($(this));"class="btn btn-primary" data-toggle="modal"data-target="#myModal">Update</button></td><td><button id="dbtn" type="button" class="btn btn-primary"onclick="deleteCourse($(this));" data-toggle="modal"data-target="#myModalTwo">Delete</button></td></tr>');
			}
		},
		error : function(data) {
			alert("something went wrong");
		}
	});
}
function updateCourses() {
	var courseId;
	var courseName;
	var tableStudent = $('#tableStudent');
	courseId = $('#courseId').val();
	courseName = $('#courseName').val();
	$.ajax({
		url : "/addOrUpdateCourse",
		type : 'POST',
		data : {
			"courseId" : courseId,
			"courseName" : courseName
		},
		success : function(data) {
			if (data == "success") {
				alert("succeed");
				tableStudent.find('tr').each(function (i) {
        	        var $tds = $(this).find('td');
        	            var temp = $tds.eq(0).text();
        	            if(temp==courseId){
        	            	$tds.eq(1).html(courseName);
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
function updateCourse(x){
	    var rows=x.closest("tr");
	    var tableStudent=$('#tableStudent');
	    $('#courseId').val(rows.find(".courseId").text());
	    $('#courseName').val(rows.find(".courseName").text());
}
function deleteCourse(params){
	 var rows=params.closest("tr");
	 var courseId=rows.find(".courseId").text();
	 var tableStudent=$('#tableStudent');
	 $.ajax({
	        url: "/deleteCourse",
	        type: 'Post',
	        data: {
	        	"courseId":courseId
	        },
	        success: function (data) {
	        	if(data=="success"){
	        		alert("delete Success");
	        		tableStudent.find('tr').each(function (i) {
	        	        var $tds = $(this).find('td');
	        	            var temp = $tds.eq(0).text();
	        	            if(temp==courseId){
	        	            	$(this).remove();
	        	            	return;
	        	            }
	        	       });	
	             }
	        }
	    });   
}
function searchCourse(param) {
	var key=param.val();
	 var tableStudent=$('#tableStudent');
	if(key.trim()==""){
		tableStudent.find('tr').each(function (i) {
	            $(this).show();
	       });	
	}
	else{
	 $.ajax({
	        url: "/searchCourse",
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