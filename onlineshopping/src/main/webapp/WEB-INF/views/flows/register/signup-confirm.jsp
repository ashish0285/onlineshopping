<%@include file="../shared/flow-header.jsp"%>

<%@include file="../shared/flow-navbar.jsp"%>

<!-- Content -->
<div class="content">
	<div class="container">
		<div class="row">
			<!-- for Personal Details -->
			<div class="col-sm-6">
			<div class="panel panel-primary">
			<div class="panel-heading"><h4>Personal Details:</h4></div>
			<div class="panel-body">
			<!-- code for displaying personal details -->
			<div class="text-center">
			<h4>${registerModel.user.firstName}
							${registerModel.user.lastName}</h4>

						<h5>Email: ${registerModel.user.email}</h5>

						<h5>Contact Number: ${registerModel.user.contactNumber}</h5>

						<h5>Role: ${registerModel.user.role}</h5>
			</div>
			</div>
			<div class="panel-footer">
			<!-- link to personal page flow view -->
			<a href="${flowExecutionUrl}&_eventId_personalEvent" class="btn btn-primary">Edit Personal Details</a>			
			</div>
			</div>
			</div>
			<!-- for Billing address -->
			<div class="col-sm-6">
			<div class="panel panel-primary">
			<div class="panel-heading"><h4>Billing Address:</h4></div>
			<div class="panel-body">
			<!-- code for displaying billing address -->
			
			<div class="text-center">
						<h4>${registerModel.billing.addressLineOne}</h4>
						<h4>${registerModel.billing.addressLineTwo}</h4>
						<h4>${registerModel.billing.city}-
							${registerModel.billing.postalCode}</h4>
						<h4>${registerModel.billing.state}</h4>
					</div>
			</div>
			<div class="panel-footer">
			<!-- link to billing address flow view -->
			<a href="${flowExecutionUrl}&_eventId_billingEvent" class="btn btn-primary">Edit Billing Details</a>
			</div>
			</div>
			</div>
		</div>
		<div class="row">
		<div class="col-sm-offset-4 col-sm-4">
		<div class="text-center">
				<a href="${flowExecutionUrl}&_eventId_successEvent" class="btn btn-primary">Confirm Details</a>
		</div>
		</div>
		</div>

	</div>
</div>
<!-- Content End -->


<!-- footer comes here -->
<%@include file="../shared/flow-footer.jsp"%>