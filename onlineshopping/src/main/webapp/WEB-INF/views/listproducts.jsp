<div class="container">

	<div class="row">

		<!-- To display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- To display actual products -->
		<div class="col-md-9">
			<!-- Add breadcrumb -->
			<div class="row">
				<c:if test="${userClickAllProducts == true}">
					<div class="col-md-12">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</div>
				</c:if>
				<c:if test="${userClickCategoryProducts == true}">
					<div class="col-md-12">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</div>
				</c:if>
			</div>

		</div>


	</div>

</div>