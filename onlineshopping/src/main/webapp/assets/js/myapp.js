$(function() {
	// solving action menu problem
	switch (menu) { // menu from page.jsp=> window.menu
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		break;
	}
})