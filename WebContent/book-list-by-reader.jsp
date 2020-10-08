<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>List of Book Lists</title>
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
		td {
			margin-left : auto;
			margin-right: auto;
			padding-left : 5px;
			padding-right: 5px
		}
		button, .link a{
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
		<form action="servletListNavigation" method="post">
			<table>
				<c:forEach items="${requestScope.allBookLists}" var="currentList">
					<tr>
						<td><input type="radio" name="id" value="${currentList.id }"></td>
						<td> <h4>${currentList.listName }</h4> </td>
					</tr>
					<tr>
						<td colspan="3">List Created: ${currentList.created }</td>
					</tr>
					<tr>
						<td colspan="3">Reader: ${currentList.bookReader.name }</td>
					</tr>
					<c:forEach var="listBooks" items="${currentList.listOfBooks }">
						<tr>
							<td></td>
							<td colspan="3"> ${listBooks.title}</td>
							<td> ${list.firstName }</td>
							<td> ${list.lastName }</td>
							<td> ${list.isbn10 }</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</table>
			<div>
				<button value ="edit" name="doThisToBookList">Edit</button>
				<button value ="delete" name="doThisToBookList">Delete</button>
				<button value ="add" name="doThisToBookList">Add</button>
			</div>
		</form>
		<div class="link">
			<a href="servletAddtoBookList">Create a New List</a>
			<a href="index.html">Add to All Books</a>
		</div>
	</div>
</body>
</html>