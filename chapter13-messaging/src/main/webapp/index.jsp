<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chapter 13 - Messaging</title>
</head>
<body>
	<h1>Chapter 13 - Messaging</h1>
	Messages count sent/receive <c:out value="${messageCounterCdiBean.sentMessagesCount}" />/
	<c:out value="${messageCounterCdiBean.receivedMessagesCount}" />
	<br />
	<a href="./produce">Produce Message</a>
</body>
</html>
