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
<script src="/js/course.js"></script>
</head>
<body>
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Course</h4>
				</div>

				<div class="container">
					<div class="form-group">
						<label for="email">Course ID:</label> <input style="width: 50%;"
							type="text" class="form-control" id="courseId">
					</div>
					<div class="form-group">
						<label for="pwd">Name:</label> <input style="width: 50%;"
							type="text" class="form-control" id="courseName">
					</div>
					<button id="btnDone" type="submit" class="btn btn-default" onclick="updateCourses();">Update</button>
					<button id="btnDone1" type="submit" class="btn btn-default" onclick="insertCourse();">Insert</button>
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
					<h4 class="modal-title">Delele Course</h4>
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
	<div>
		<div class="row">
			<button id="insert" value="Insert" type="button"
				class="btn btn-primary" data-toggle="modal" data-target="#myModal">+
				Add new Course</button>
			<div class="search-box">
				<i class="material-icons">&#xE8B6;</i> <input type="text"
					class="form-control" placeholder="Search&hellip;" onkeyup="searchCourse($(this))">
			</div>
		</div>
		<table id="tableStudent" class="table table-condensed">
			<thead>
				<tr>
					<th>Course ID</th>
					<th>Course Name</th>
					<th>EDIT</th>
					<th>DELETE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tempCourse" items="${listCourse}">
					<tr>
						<td class="courseId">${tempCourse.courseId.trim()}</td>
						<td class="courseName">${tempCourse.courseName}</td>
						<td>
							<button id="update" type="button" onclick="updateCourse($(this));"
								class="btn btn-primary" data-toggle="modal"
								data-target="#myModal">Update</button>
						</td>
						<td>
							<button id="dbtn" type="button" class="btn btn-primary"
								onclick="deleteCourse($(this));" data-toggle="modal"
								data-target="#myModalTwo">Delete</button>
						</td>
					</tr>
				</c:forEach>
		</table>
		</div>
</body>
</html>