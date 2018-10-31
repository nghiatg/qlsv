<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head fragment="head">
<meta charset="utf-8" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="css/style.css" rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/class.js"></script>
</head>
<body>
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Class</h4>
				</div>
				<div class="container">
					<div class="form-group">
						<label for="email">Class ID:</label> <input style="width: 50%;"
							type="text" class="form-control" id="classId">
					</div>
					<div class="form-group">
						<label for="pwd">Name:</label> <input style="width: 50%;"
							type="text" class="form-control" id="className">
					</div>
					<div class="form-group">
						<label for="pwd">Khoa</label>
						 <select style="width: 50%;"
							type="text" class="form-control" id="department">
							<c:forEach var="temp" items="${listDepartment}">
								<option value="${temp.departmentId}">${temp.departmentName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="pwd">HeDT</label>
						 <select style="width: 50%;"
							type="text" class="form-control" id="eduSystem">
							<c:forEach var="temp" items="${listEdu}">
								<option value="${temp.systemId}">${temp.systemName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="pwd">Khoa Hoc</label>
						 <select style="width: 50%;"
							type="text" class="form-control" id="course">
							<c:forEach var="temp" items="${listCourse}">
								<option value="${temp.courseId}">${temp.courseName}</option>
							</c:forEach>
						</select>
					</div>
					<button id="btnDone" type="submit" class="btn btn-default" onclick="updateClasss();">Update</button>
					<button id="btnDone1" type="submit" class="btn btn-default" onclick="insertClass();">Insert</button>
				</div>
				<div class="modal-footer">
					<button type="button" value="Update" class="btn btn-default"
						data-dismiss="modal" onclick="changeButton($(this));">Close</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModalTwo" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Delele Class</h4>
				</div>
				<div class="modal-body">
					<p>Delete rows</p>
				</div>
				<div class="modal-footer">
					<button id="btnDelete" type="button" class="btn btn-default"
						data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
	<div class="ss"></div>
	<jsp:include page="header.jsp"></jsp:include>
		<div class="row">
			<button id="insert" value="Insert" type="button"
				class="btn btn-primary" data-toggle="modal" data-target="#myModal">+
				Add new Class</button>
			<div class="search-box">
				<i class="material-icons">&#xE8B6;</i> <input type="text"
					class="form-control" placeholder="Search&hellip;" onkeyup="searchClass($(this))">
			</div>
		</div>
		<table id="tableStudent" class="table table-condensed">
			<thead>
				<tr>
					<th>Class ID</th>
					<th>Name</th>
					<th>Khoa</th>
					<th>He DT</th>
					<th>Khoa Hoc</th>
					<th>EDIT</th>
					<th>DELETE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tempClass" items="${listClass}">
					<tr>
						<td class="classId">${tempClass.classId.trim()}</td>
						<td class="className">${tempClass.className}</td>
						<td class="DepartmentName">${tempClass.course.courseName}</td>
						<td class="EducationSystemName">${tempClass.department.departmentName}</td>
						<td class="CourseName">${tempClass.eduSystem.systemName}</td>
						<td>
							<button id="update" type="button" onclick="updateClass($(this));"
								class="btn btn-primary" data-toggle="modal"
								data-target="#myModal">Update</button>
						</td>
						<td>
							<button id="dbtn" type="button" class="btn btn-primary"
								onclick="deleteClass($(this));" data-toggle="modal"
								data-target="#myModalTwo">Delete</button>
						</td>
					</tr>
				</c:forEach>
		</table>
</body>
</html>