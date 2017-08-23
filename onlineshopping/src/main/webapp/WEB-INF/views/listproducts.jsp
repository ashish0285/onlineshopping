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
				<script>window.categoryId=''</script>
					<div class="col-md-12">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</div>
				</c:if>
				<c:if test="${userClickCategoryProducts == true}">
				    <script>window.categoryId='${category.id}'</script>
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
				<div class="col-xs-12">
					<table id="productListTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Image</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Unit Price</th>
								<th>Qty Available</th>
								<th>View/Add</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Image</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Unit Price</th>
								<th>Qty Available</th>
								<th>View/Add</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>

		</div>


	</div>

</div>