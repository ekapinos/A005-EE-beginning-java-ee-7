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
	Messages count
	<br/>
	Queue sent: <c:out value="${counter.sentMessagesCountQueue}" />, received:<c:out value="${counter.receivedMessagesCountQueue}" />
	<a href="./produce/queue">Produce Queue Message</a>
	<br/>
	Topic sent: <c:out value="${counter.sentMessagesCountTopic}" />, received:<c:out value="${counter.receivedMessagesCountTopic}" />
	<a href="./produce/topic">Produce Topic Message</a>
</body>
</html>
