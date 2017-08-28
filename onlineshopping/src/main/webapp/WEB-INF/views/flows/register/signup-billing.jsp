<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flow-header.jsp"%>

<%@include file="../shared/flow-navbar.jsp"%>

<!-- Content -->
<div class="content">
	<div class="container">

		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up - Billing</h4>
				</div>
				<div class="panel-body">
					<!--  FORM ELEMENTS -->
					<sf:form id="billingForm" class="form-horizontal"
						modelAttribute="billing" method="POST">

						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne">Billing Address: Line 1 : </label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineOne" id="addressLineOne"
									placeholder="Enter Address" class="form-control" />
								<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineTwo">Billing Address: Line 2 : </label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineTwo" id="addressLineTwo"
									placeholder="Enter Address" class="form-control" />
								<sf:errors path="addressLineTwo" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="city">Enter
								City: </label>
							<div class="col-md-8">
								<sf:input type="text" path="city" id="city"
									placeholder="Enter City" class="form-control" />
								<sf:errors path="city" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="state">Enter
								State: </label>
							<div class="col-md-8">
								<sf:input type="text" path="state" id="state"
									placeholder="Enter State" class="form-control" />
								<sf:errors path="state" cssClass="help-block"
									element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="postalCode">Enter
								State: </label>
							<div class="col-md-8">
								<sf:input type="text" path="postalCode" id="postalCode"
									placeholder="Enter Pin Code" class="form-control" />
								<sf:errors path="postalCode" cssClass="help-block"
									element="em" />
							</div>
						</div>
						
						<!-- Button -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type="submit" class="btn btn-primary"
									name="_eventId_personalEvent">
									<span class="glyphicon glyphicon-chevron-left"></span>Previous - Personal 
								</button>
								<button type="submit" class="btn btn-primary"
									name="_eventId_confirmEvent">
									Next - Confirm <span class="glyphicon glyphicon-chevron-right"></span>
								</button>
							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>

	</div>
</div>
<!-- Content End -->


<!-- footer comes here -->
<%@include file="../shared/flow-footer.jsp"%>