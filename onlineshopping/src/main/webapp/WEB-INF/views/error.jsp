<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<!-- header comes here -->
<%@include file="./shared/header.jsp"%>
</head>
<body>
	<div class="wrapper">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${contextRoot}/home">Ashish
						Online Shopping Home</a>

				</div>
			</div>
		</nav>
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="jumbotron">
						<h1>${errorTitle}</h1>
						<hr/>
						<blockquote>${errorDescription}</blockquote>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- footer comes here -->
		<%@include file="./shared/footer.jsp"%>

		<!-- scripts -->
		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<script src="${js}/jquery.dataTables.js"></script>
		<!-- DataTable bootstarp -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- self coded JavaScript -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
