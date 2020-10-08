<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
 -	Called from: 	ServletAddtoBookList.java
 -	Attribute:		"allBooks"
 -	form action:	servletCreateNewList.java
 -	Form function:	for creating a new BookList
--%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create a New List</title><style>
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
			margin-top : 10px;
			margin-bottom : 10px;
			width: 110px;
			font : 12px Arial;
  			text-decoration: none;
 			background-color: #FFFFFF;
  			color: #333333;
  			padding: 2px 6px 2px 6px;
  			border: thin solid #A0A3A3;
  			border-radius: 5px;
		}
		.link a{
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
		<form action="servletCreateNewList" Method="post">
			<label>List Name:</label><input type="text" name="listName">
			<label>Reader Name:</label><input type="text" name="bookReader">
			<label>Available Books</label>
			<select name="allBooksToAdd" size="8" multiple>
				<c:forEach items="${requestScope.allBooks}" var="currentBook">
					<option value="${currentBook.id}">
						${currentBook.title} | ${currentBook.firstName} ${currentBook.lastName}
					</option>
				</c:forEach>
			</select><br>
			<button>Submit</button>
			<div class="link">
				<a href="index.html">Add to All Books</a>
			</div>
		</form>
	</div>
</body>
</html>