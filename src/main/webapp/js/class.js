function insertClass() {
		var tableStudent = $('#tableStudent');
		var classId = $('#classId').val();
		var className = $('#className').val();
		var courseId =  $('#course option:selected').attr('value');
		var courseName = $('#course option:selected').text();
		var departmentId =  $('#department option:selected').attr('value');
		var departmentName = $('#department option:selected').text();
		var systemId =  $('#eduSystem option:selected').attr('value');
		var systemName = $('#eduSystem option:selected').text();
		$.ajax({
			url : "/addOrUpdateClass",
			type : 'POST',
			data : {
				"classId" : classId,
				"className" : className,
				"courseId" : courseId,
				"departmentId" : departmentId,
				"systemId" : systemId
			},
			success : function(data) {
				if (data == "success") {
					alert("succeed");
					tableStudent.append('<tr><td>' + classId + '</td><td>'
							+ className + '</td><td>' + courseName
							+ '</td><td>' + departmentName + '</td><td>'
							+ systemName + '</td><td><button id="update" type="button" onclick="updateClass($(this));"class="btn btn-primary" data-toggle="modal"data-target="#myModal">Update</button></td><td><button id="dbtn" type="button" class="btn btn-primary"onclick="deleteClass($(this));" data-toggle="modal"data-target="#myModalTwo">Delete</button></td></tr>');
				}
			},
			error : function(data) {
				alert("something went wrong");
			}
		});
}
function updateClasss() {
	var tableStudent = $('#tableStudent');
	var classId = $('#classId').val();
	var className = $('#className').val();
	var courseId =  $('#course option:selected').attr('value');
	var courseName = $('#course option:selected').text();
	var departmentId =  $('#department option:selected').attr('value');
	var departmentName = $('#department option:selected').text();
	var systemId =  $('#eduSystem option:selected').attr('value');
	var systemName = $('#eduSystem option:selected').text();
	$.ajax({
		url : "/addOrUpdateClass",
		type : 'POST',
		data : {
			"classId" : classId,
			"className" : className,
			"courseId" : courseId,
			"departmentId" : departmentId,
			"systemId" : systemId
		},
		success : function(data) {
			if (data == "success") {
				alert("succees");
				tableStudent.find('tr').each(function (i) {
        	        var $tds = $(this).find('td');
        	            var temp = $tds.eq(0).text();
        	            if(temp==classId){
        	            	$tds.eq(1).html(className);
        	            	$tds.eq(2).html(courseName);
        	            	$tds.eq(3).html(departmentName);
        	            	$tds.eq(4).html(systemName);
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
function updateClass(x){
	    var rows=x.closest("tr");
	    var tableStudent=$('#tableStudent');
	    $('#classId').val(rows.find(".classId").text());
	    $('#className').val(rows.find(".className").text());
	    $("#course option").text(val(rows.find(".CourseName").text()));
	    $("#department option").text(val(rows.find(".DepartmentName").text()));
	    $("#eduSystem option").text(val(rows.find(".EducationSystemName").text()));
}
function deleteClass(params){
	 var rows=params.closest("tr");
	 var classId=rows.find(".classId").text();
	 var tableStudent=$('#tableStudent');
	 $.ajax({
	        url: "/deleteClass",
	        type: 'Post',
	        data: {
	        	"classId":classId
	        },
	        success: function (data) {
	        	if(data=="successfully"){
	        		alert("delete Success");
	        		tableStudent.find('tr').each(function (i) {
	        	        var $tds = $(this).find('td');
	        	            var temp = $tds.eq(0).text();
	        	            if(temp==classId){
	        	            	$(this).remove();
	        	            	return;
	        	            }
	        	       });	
	             }
	        }
	    });   
}
function searchClass(param) {
	var key=param.val();
	 var tableStudent=$('#tableStudent');
	if(key.trim()==""){
		tableStudent.find('tr').each(function (i) {
	            $(this).show();
	       });	
	}
	else{
	 $.ajax({
	        url: "/searchClass",
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