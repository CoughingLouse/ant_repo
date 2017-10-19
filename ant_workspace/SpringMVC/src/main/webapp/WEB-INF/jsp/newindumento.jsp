
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD</title>
</head>
<body bgcolor="orange">
	<img src="duke.waving.gif">
	<h2>My name is Duke. What is yours?</h2>
	<form method="get">
		<input type="text" name="username" size="25">
		<p></p>
		<input type="submit" value="Submit"> <input type="reset"
			value="Reset">
	</form>

</body>
</html>