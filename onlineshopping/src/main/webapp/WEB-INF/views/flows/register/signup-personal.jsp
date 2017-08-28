<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flow-header.jsp"%>

<%@include file="../shared/flow-navbar.jsp"%>

<!-- Content -->

<div class="content">
	<div class="container">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up - Personal</h4>
				</div>
				<div class="panel-body">
					<!--  FORM ELEMENTS -->
					<sf:form id="registerForm" class="form-horizontal"
						modelAttribute="user" method="POST">

						<div class="form-group">
							<label class="control-label col-md-4" for="firstName">Enter
								First Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="firstName" id="firstName"
									placeholder="First Name" class="form-control" />
								<sf:errors path="firstName" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="lastName">Enter
								Last Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="lastName" id="lastName"
									placeholder="Last Name" class="form-control" />
								<sf:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="email">Enter
								Email: </label>
							<div class="col-md-8">
								<sf:input type="text" path="email" id="email"
									placeholder="email@yourdomain.com" class="form-control" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="contactNumber">Enter
								Contact Number: </label>
							<div class="col-md-8">
								<sf:input type="text" path="contactNumber" id="contactNumber"
									placeholder="Contact Number" class="form-control" />
								<sf:errors path="contactNumber" cssClass="help-block"
									element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="password">Enter
								Password: </label>
							<div class="col-md-8">
								<sf:input type="password" path="password" id="password"
									placeholder="Enter your Password here" class="form-control" />
								<sf:errors path="password" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="confirmPassword">Confirm
								Password: </label>
							<div class="col-md-8">
								<sf:input type="password" path="confirmPassword" id="confirmPassword"
									placeholder="Confirm your Password" class="form-control" />
								<sf:errors path="confirmPassword" cssClass="help-block" element="em" />
							</div>
						</div>
						<!-- radio button using bootstrap class of radio-inline -->
						<div class="form-group">
							<label class="control-label col-md-4">Select Role</label>
							<div class="col-md-8">
								<label class="radio-inline"> 
									<sf:radiobutton path="role" value="USER" checked="checked" /> User
								</label>
								<label class="radio-inline">
									<sf:radiobutton path="role" value="SUPPLIER" /> Supplier
								</label>
							</div>
						</div>
						<!-- Button -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type="submit" class="btn btn-primary"
									name="_eventId_billingEvent">
									Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
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

