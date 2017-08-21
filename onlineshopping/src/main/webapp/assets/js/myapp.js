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
		if(menu=="Home") break;
		$('#listProducts').addClass('active');
		$('#a_' +menu).addClass('active');
		break;

	}
	
	//Code for Jquery Data Table
	//create a dummy dataSet
	
	var products =[
	               ['1','ABC'],
	               ['2','BCD'],
	               ['3','CDE'],
	               ['4','DEF'],
	               ['5','EFG'],
	               ['6','FGH'],
	               ['7','GHI'],
	               ['8','HIJ'],
	               ['9','JKL']
	               ];
	var $table = $('#productListTable')
if($table.length){
	$table.DataTable({
		
		data:products
	});
}
	
});