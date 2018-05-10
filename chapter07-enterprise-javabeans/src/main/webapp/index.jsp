<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web-EJB demo</title>
</head>
<body>
	<h1>Web-EJB demo</h1>
	<h3>(be aware of 3 sec delay for load testing)</h3>
	<ul>
		<li>Servlet - same controller on each call,
		<ul>
			<li><a href="./servlet/stateless">servlet/stateless</a> same ejb on low load, new ejb on load
			<li><a href="./servlet/stateful">servlet/stateful</a> same ejb always with sequential execution on load
		</ul>
		<li>Rest - new controller on each call
		<ul>
			<li><a href="./rest/stateless">rest/stateless</a> same ejb on low load, new ejb on load
			<li><a href="./rest/stateful">rest/stateful</a> new ejb on each call
		</ul>
	</ul>
</body>
</html>
