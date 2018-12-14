<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<f:form action="update.htm" method="post" modelAttribute="data">
		<f:hidden path="id"/>
Firstname<f:input path="firstname" />
			<br>
			<br>
Lastname<f:input path="lastname" />
			<br>
			<br>
Username<f:input path="username" />
			<br>
			<br>
Password<f:password path="password" />
			<br>
			<br>
			<input type="submit" /><br><br>
		</f:form>
	</center>
</body>
</html>