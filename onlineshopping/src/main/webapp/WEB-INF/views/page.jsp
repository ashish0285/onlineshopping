<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/resources/css"/>
<spring:url var="fonts" value="/resources/fonts"/>
<spring:url var="images" value="/resources/images"/>
<spring:url var="js" value="/resources/js"/>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<!-- header comes here -->
<%@include file="./shared/header.jsp" %>

<!-- navbar comes here -->
<%@include file="./shared/navbar.jsp" %>

<c:if test="${userClickHome == true}">
<!-- PAGE CONTENT comes here -->
<%@include file="./home.jsp" %>
</c:if>

<!-- footer comes here -->
<%@include file="./shared/footer.jsp" %>