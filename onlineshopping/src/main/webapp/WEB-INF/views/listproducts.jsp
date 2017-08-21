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
			<div class="row">
				<div class="col-md-12">
					<table id="productListTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>

		</div>


	</div>

</div>