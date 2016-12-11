<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddAccount" method="POST">
		<p>
			enter your user name: <input type="text" id="username"
				name="username">
		</p>
		<br>
		<p>
			enter your user password: <input type="password" id="username"
				name="username">
		</p>
		<br>
		<p>
			choose your incoming mail settings <input type="radio" id="serverType"
				name="serverType" value ="imap">IMAP <input type="radio" id="serverType" name="serverType" value = "pop">POP
			<br> enter incoming server address: <input type="text"
				id="incomingServer" name="incomingServer"><br> enter
			incoming server port number: <input type="text"
				id="incomingserverPort" name="incomingServerPort">
		</p>
		<br>
		<p>
			SMTP settings:<br> <br> smtp server address: <input
				type="text" id="smtpServer" name="smtpServer"><br>
			enter incoming server port number: <input type="text"
				id="smtpServerPort" name="smtpServerPort">
		</p>
		<input type="submit" value="submit" name="submit">
	</form>
</body>
</html>