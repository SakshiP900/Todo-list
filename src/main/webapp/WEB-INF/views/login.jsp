<%@ include file="../common/header.jspf"%>


<body>

	<%@ include file="../common/navigation.jspf"%>

	<div class="container">
		<form action="/login.do" method="post">
			<p>
				<font color="red">${errorMessage}</font>
			</p>
			<br> Enter your name: <input type="text" name="name" /> <br>
			<br> Enter your password: <input type="password" name="password" />
			<br> <br> <input type="submit" value="Submit" />
		</form>
	</div>

	<%@ include file="../common/footer.jspf"%>

</html>