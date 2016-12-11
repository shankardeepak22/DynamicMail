<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Compose Email</title>
</head>
<body>
    
    <form action="sendMail">
    <div class="col-sm-6">
    <nav class="navbar navbar-dark bg-primary"> <center><h3>Compose E-mail</h3></center></nav>
    <div class="form-group">
    <label for="toLabel">To</label>
    <input type="text" class="form-control" id="to" placeholder="Enter to address">
    </div>
    <div class="form-group">
    <label for="subject">Subject</label>
    <input type="text" class="form-control" id="mailSubj" placeholder="Enter subject">
    </div>
    <div class="form-group">
        <textarea rows="10" class="form-control" id="mailBody"></textarea>
    </div>
    <div class="form-group">
    <button type="submit" class="btn btn-primary">Send</button>
    </div>
    </div>
</form>
</body>
</html>