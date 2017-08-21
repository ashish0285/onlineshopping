<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="fonts" value="/resources/fonts" />
<spring:url var="images" value="/resources/images" />
<spring:url var="js" value="/resources/js" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<!-- header comes here -->
<%@include file="./shared/header.jsp"%>
</head>
<body>
	<div class="wrapper">
		<!-- navbar comes here -->
		<%@include file="./shared/navbar.jsp"%>
		<div class="content">
			<c:if test="${userClickHome == true}">
				<!-- PAGE CONTENT comes here -->
				<%@include file="./home.jsp"%>
			</c:if>
			<c:if test="${userClickAbout == true}">
				<!-- PAGE CONTENT comes here -->
				<%@include file="./about.jsp"%>
			</c:if>
			<c:if test="${(userClickAllProducts == true) or (userClickCategoryProducts == true)}">
				<!-- PAGE CONTENT comes here -->
				<%@include file="./listproducts.jsp"%>
			</c:if>
			<c:if test="${userClickContact == true}">
				<!-- PAGE CONTENT comes here -->
				<%@include file="./contact.jsp"%>
			</c:if>
		</div>
		<!-- footer comes here -->
		<%@include file="./shared/footer.jsp"%>

		<!-- scripts -->
		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- self coded JavaScript -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
