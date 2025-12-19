<%@ include file="../common/header.jspf"%>

</head>

<body>

	<%@ include file="../common/navigation.jspf"%>

	<div class="container">
		<br>
		<p>Your New Todo's Action Item: </p>
		<form action="/add-todo.do" method="post">
		<fieldset class="form-group">
			<label>Description:</label> &nbsp; <input type="text" name="todo" class="form-control"/> 
		</fieldset>
		<fieldset class="form-group">
			<label>Category:</label> &nbsp; <input type="text" name="category" class="form-control"/> 
		</fieldset>
			<input type="submit" value="Submit" class="btn btn-success"/>
		</form>
	</div>

	<%@ include file="../common/footer.jspf"%>

</html>