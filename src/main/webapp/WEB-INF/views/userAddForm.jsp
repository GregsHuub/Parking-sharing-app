<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>UserAddForm</title>
</head>
<body>
<h1>USER ADD FORM</h1>
<form:form method="post" action="./save" modelAttribute="user">
Imie<form:input path="firstName" type="text" name="firstName"/>
Nazwisko<form:input path="lastName" type="text" name="lastName"/>
Email<form:input path="email" type="email" name="email"/>
Haslo<form:input path="password" type="password" name="password"/>
<label>Numer kontaktowy</label><form:input path="contactNumber" type="text" name="NumerKont"/>
    <button type="submit">Create</button>
</form:form>
</body>
</html>
