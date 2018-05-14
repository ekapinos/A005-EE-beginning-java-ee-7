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
		<li>@WebServlet - same instance on each call
		<ul>
			<li><a href="./webservlet/stateless">@Stateless</a> same ejb on low load, new ejb on load
			<li><a href="./webservlet/stateful">@Stateful</a> same ejb always with sequential execution on load
			<li><a href="./webservlet-sessionscoped/stateless">@SessionScoped-@Stateless</a> same as @Stateless
			<li><a href="./webservlet-sessionscoped/stateful">@SessionScoped-@Stateful</a> same ejb for each HTTP session
		</ul>
		<li>@ApplicationPath("/rest") + @Path - new instance on each call
		<ul>
		    <li>@RequestScoped via getClasses - new instance on each call
		    <ul>
				<li><a href="./rest/stateless">@Stateless</a> same ejb on low load, new ejb on load
				<li><a href="./rest/stateful">@Stateful</a> new ejb on each call
			</ul>
		    <li>@ApplicationScoped via getSingletons - single instance
		    <ul>
				<li><a href="./rest/singleton/stateless">@SessionScoped-@Stateless</a> same as @WebServlet-@SessionScoped-@Stateless
				<li><a href="./rest/singleton/stateful">@SessionScoped-@Stateful</a> same as @WebServlet-@SessionScoped-@Stateful
			</ul>
		</ul>
		<li><a href="./webservlet-async">@ApplicationScoped-@Stateful-@Asynchronous</a> works Ok in WAR file
		<li><a href="./webservlet-chain">@ApplicationScoped-@Stateless-@Stateless-@Stateful</a> new @Stateful on load (@Stateless client instantiated). No proxy. Bad practice
	</ul>
</body>
</html>
