<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- search(/[^a-z0-9]/gi) -->

<c:set var="inputId" value="${param.id}" />
<%
	String inputId = (String)pageContext.getAttribute("inputId");
%>

<c:choose>
	<c:when test="${empty inputId}">
        <h4>아이디를 입력해주세요.</h4>
    </c:when>
    
    <c:when test="${inputId eq 'fail'}">
        <h4>영어와 숫자만 가능합니다.</h4>
    </c:when>
    
    <c:when test="${inputId eq 'sizeMiss'}">
        <h4>4글자 이상 입력해주세요.</h4>
    </c:when>
 
    <c:when test="${mem_id eq null}">
        <h2>${param.id}</h2>
        <h4>는 사용할 수 있는 아이디입니다.</h4>
    </c:when>
 
    <c:otherwise>
        <h2>이미 사용중인 아이디입니다.</h2>
    </c:otherwise>
 
</c:choose>

</body>
</html>