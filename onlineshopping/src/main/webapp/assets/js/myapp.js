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
									} else{
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
									
									if(row.quantity<1){
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><strike>Add to Cart</strike></a>'
									}	else {
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

});