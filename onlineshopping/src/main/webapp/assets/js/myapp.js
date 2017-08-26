$(function() {
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	// Code for Jquery Data Table
	// create a dummy dataSet

	/*
	 * var products =[ ['1','ABC'], ['2','BCD'], ['3','CDE'], ['4','DEF'],
	 * ['5','EFG'], ['6','FGH'], ['7','GHI'], ['8','HIJ'], ['9','JKL'] ];
	 */
	var $table = $('#productListTable')
	if ($table.length) {
		var jsonUrl = '';
		if (categoryId == '') {
			jsonUrl = contextRoot + '/json/data/all/products'
		} else {
			jsonUrl = contextRoot + '/json/data/category/' + categoryId
					+ '/products'
		}

		$table
				.DataTable({

					"lengthMenu" : [
							[ '3', '5', '10', '-1' ],
							[ '3 records', '5 records', '10 records',
									'All records' ] ],
					"pageLength" : 5,
					// "data" : products
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>'

								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
									// &#8377; is for Rupees Symbol
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									str1 = ''
									if (data < 1) {
										str1 = '<span style="color:red">Out of Stock!!</span>'
									} else {
										str1 = data
									}
									return str1
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									str = ''
									str += '<a href="'
											+ contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary">View</a> | '

									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><strike>Add to Cart</strike></a>'
									} else {
										str += '<a href="'
												+ contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success">Add to Cart</a>'
									}

									return str
								}
							}

					]

				});
	}
	// dismissing the alert after 3 seconds

	var $alert = $('.alert')

	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow')
		}, 3000)
	}

	// code for toggle switch

	

	var $adminTable = $('#adminProductsTable')

	if ($adminTable.length) {

		var jsonAdminUrl = contextRoot + '/json/data/admin/all/products';

		$adminTable.DataTable({
					"lengthMenu" : [
							[ '3', '5', '10', '-1' ],
							[ '3 records', '5 records', '10 records',
									'All records' ] ],
					"pageLength" : 5,
					// "data" : products
					ajax : {
						url : jsonAdminUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImg" alt="'
											+ row.name + '"/>'
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data + ' /-'
									// &#8377; is for Rupees Symbol
								}

							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									str1 = ''
									if (data < 1) {
										str1 = '<span style="color:red">Out of Stock!!</span>'
									} else {
										str1 = data
									}
									return str1
								}

							},
							{
								data : 'active',
								mRender : function(data, type, row) {
									if (data == true) {
										return '<label class="switch"><input type="checkbox" checked="checked" value="'
												+ row.id
												+ '"/><div class="slider"></div></label>';
									} else {
										return '<label class="switch"><input type="checkbox" value="'
										+ row.id
										+ '"/><div class="slider"></div></label>';

									}
								}
							}, {
								data : 'id',
								mRender : function(data, type, row) {
									return '<a href="'+ window.contextRoot +'/manage/'+data+'/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"/></a>'
								}
							} ],
							drawCallback: function(){
								
									$('.switch input[type="checkbox"]').on('change', function() {
											
										var checkbox = $(this);
										var checked = checkbox.prop('checked');
										var dMsg = (checked) ? 'You want to activate the product ?'
												: 'You want to deactivate the product ?';
										var value = checkbox.prop('value');
										bootbox
												.confirm({
													size : 'medim',
													title : 'Product Activation & DeActivation',
													message : dMsg,
													callback : function(confirmed) {
														if (confirmed) {
															
															console.log(value);
															var activationUrl= window.contextRoot +'/manage/product/'+ value +'/activation';
															
															$.post(activationUrl,function(data){
																bootbox
																.alert({
																	size : 'medium',
																	title : 'Information',
																	message : data

																});																		
															});
															
															
														} else {
															checkbox.prop('checked', !checked);
														}
													}

												});

									}		
									
									);
										
								
							},
							

				});// end of dataTable

	}
	
// validation code for category
	
	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length) {
		
		$categoryForm.validate({
			
			rules : {
				
				name : {
					
					required: true,
					minlength: 2
					
				},
				
				description: {
					required: true
				}
				
			},
			
			messages : {
				
				name : {
					
					required: 'Please add the category name!',
					minlength: 'The category name should not be less than 2 characters'
					
				},
				
				description: {
					
					required: 'Please add a description for this category!'
				}
				
				
			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				// add the error element after the input element
				error.insertAfter(element);				
			}
		});
		
		
	}


});
