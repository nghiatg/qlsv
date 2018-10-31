<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
   
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid #e7e7e7;
    background-color: #f3f3f3;
}
li {

    float: left;
}
li a {
    display: block;
    color: #666;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    
    background-color: #ddd;
}
</style>
</head>
<body>
<ul>
  <li><a  href="#home">Home</a></li>
  <li><a href="/course">Course</a></li>
  <li><a href="/student">Student</a></li>
  <li><a href="/class">Class</a></li>
  <li style="float:right"><a href="/logout">LogOut</a></li>
</ul>
</body>
</html>
