<%@page import="edu.rit.cs.csci651.mail.model.Message"%>
<%@page import="edu.rit.cs.csci651.mail.model.IMAPFolder"%>
<%@page import="edu.rit.cs.csci651.mail.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mailbox</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<%
	User user = (User) request.getAttribute("user");
	System.out.println("MXTYPE=" + request.getAttribute("mxtype"));
	if (request.getAttribute("mxtype").equals("imap")) {
		int count = 0;
%>
<script type="text/javascript">
	function getPreview(index) {
		$('.previewClass').hide();
		console.log(index);
		$('li[id^=msg' + index + ']').show();
	}
	function getMessage(folderIndex, msgIndex) {
		var div = documnet.createTextNode
	}
	function stripHtml(bodyVar){
	$('#mailBody').html($(bodyVar).text());}
</script>
</head>
<body style="background-image: url('http://www.intrawallpaper.com/static/images/abstract-mosaic-background.png'); width:inherit; height: inherit;">
	<nav class="navbar navbar-dark bg-primary">
	<center>
		<h3>Mailbox</h3>
	</center>
	</nav>
	<div style="float: right">
		<ul class="nav nav-pills">
			<li class="nav-item"><a href="nav-link active" href="#">Compose</a>
			</li>
			<li class="nav-item"><a href="nav-link" href="#">Reply</a></li>
			<li class="nav-item"><a href="nav-link" href="#">Reply All</a></li>
			<li class="nav-item"><a href="nav-link" href="#">Forward</a></li>
			<li class="nav-item"><a href="nav-link" href="#">Delete</a></li>
		</ul>
	</div>
	<div class="col-sm-3">

		<ul class="nav nav-tabs nav-stacked">
			<%
				for (IMAPFolder folder : user.getImapFolders()) {
			%>
			<li class="nav-item" style="overflow: auto;"><a
				onclick="getPreview('<%=count%>')" id="folder<%=count%>"> <%=folder.getName()%></a>
			</li>

			<%
				count++;
					}
				}
			%>

		</ul>

	</div>
	<div class="col-sm-3">
		<ul class="nav nav-tabs nav-stacked" id="preview">
			<%
				int count2 = 0;
				int count3 = 0;
				for (IMAPFolder folder : user.getImapFolders()) {
					for (Message msg : folder.getMessages()) {
						String subj = msg.getSubject();
						String from = msg.getFrom();
						System.out.println("From from from from :" + from);
						if (subj == null) {
							subj = "No Subject";
						}
			%>
			<li class="previewClass list-group-item"
				style="margin: 0px; cursor: pointer;" id="msg<%=count2%>">

				<blockquote style="margin: 0px" id="actMsg<%=count3%>"
					onclick="getMessage('<%=count2%>','<%=count3%>')">
					<p>
						<a><%=subj%></a>
						<footer><%=from%></footer>
					</p>
				</blockquote>
			</li>
			<%
				count3++;
					}
					count2++;
				}
			%>


		</ul>
	</div>
	<div class="col-sm-6 jumbotron"
		style="padding: 10px; height: 100%; width: 100%" id="mailBody"
		onclick="stripHtml(<%=user.getImapFolders().get(0).getMessages().get(1).getBody()%>)">

	</div>
</body>
</html>