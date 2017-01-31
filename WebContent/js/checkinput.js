document.getElementById('producto').onchange = function() {
	
	document.getElementById('cantidad').disable = !this.checked;
	
}; 