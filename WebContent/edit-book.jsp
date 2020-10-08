<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body{
			box-sizing : border-box
		}
		.formContainer {
			margin: auto;
			padding : 15px;
			border : black thin solid;
			width : 50%;
			background : lightgray;
		}
		h4 {
			margin-top: 5px;
			margin-bottom : 5px;
		}
		label {
			display : inline-block;
			width : 100px;
		}
		input {
			display : inline-block;
			width : 250px;
		}
		button {
			width: 110px;
			font : 12px Arial;
  			text-decoration: none;
 			background-color: #FFFFFF;
  			color: #333333;
  			margin-right: 20px;
  			padding: 2px 6px 2px 6px;
  			border: thin solid #A0A3A3;
  			border-radius: 5px;
		}
	</style>
</head>
<body>
	<div class="formContainer">
		<form action="editBookServlet" method="post">
			<h4>Edit book:</h4>
				<label>Title:</label> <input type="text" name="title" value="${bookToEdit.title}"><br>
				<label>First Name:</label> <input type="text" name="firstName" value="${bookToEdit.firstName}"><br>
				<label>Last Name:</label> <input type="text" name="lastName" value="${bookToEdit.lastName}"><br>
				<label>10 Digit ISBN:</label> <input type="text" name="isbn10" value="${bookToEdit.isbn10}"><br>
			<input type="hidden" name="id" value="${bookToEdit.id}">
			<div class="buttons">
				<button>Submit</button>
			</div>
		</form>
	</div>
</body>
</html>