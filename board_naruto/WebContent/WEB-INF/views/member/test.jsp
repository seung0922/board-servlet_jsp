<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ss = (String)session.getAttribute("ss");
	out.print(ss);

%>