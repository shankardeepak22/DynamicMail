<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Mailbox</title>
    <style>
        input{
            
        }
    </style>
</head>
<body>
<form action="AddAccount" method = "post">
    <div class="col-sm-6">
    <nav class="navbar navbar-dark bg-primary"> <center><h3>Welcome to Mailbox</h3></center></nav>
        
    <legend>Sign-In</legend>
    <div class="form-group">
    <label for="uname">Username</label>
    <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username">
    </div>
    <div class="form-group">
    <label for="pwd">Password</label>
    <input type="password" class="form-control" id="pwd" name ="pwd" placeholder="Enter Password">
    </div>
    <legend>Incoming Mail Server Info</legend>
    <fieldset class="form-group">
        <label for="accountType">Account Type</label>
        <div class="form-check">
            <label class="form-check-label">
        <input type="radio" class="form-check-input" name="accountType" id="imapRadio" value="IMAP">IMAP
            </label></div>
        <div class="form-check">
            <label class="form-check-label">
        <input type="radio" class="form-check-input" name="accountType" id="popRadio" value="POP3">POP3
            </label>
        </div>
    </fieldset>
        <div class="form-group">
    <label for="mailServer">Mail Server</label>
    <input type="text" class="form-control" id="mailServerName" name="mailServerName" placeholder="Enter mail server name">
    </div>
    <div class="form-group">
    <label for="portNumMail">Port Number</label>
    <input type="text" class="form-control" id="portMail" name ="portMail" placeholder="Enter port number">
    </div>
    <legend>Outgoing Mail Server Info</legend>
    <div class="form-group">
    <label for="smtpServer">SMTP Server</label>
    <input type="text" class="form-control" id="smtpServer" name = "smtpServer" placeholder="Enter SMTP server name">
    </div>
    <div class="form-group">
    <label for="smtpPortNum">Port Number</label>
    <input type="text" class="form-control" id="smtpPortNum" name = "smtpPortNum" placeholder="Enter port number">
    </div>
    <div class="form-group">
<input type="submit" class="btn btn-primary" value="Submit">
    </div>
        </div>
</form>
</body>
</html>