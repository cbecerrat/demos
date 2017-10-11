$(document).ready(function() {	
	$('#loading').css('display', 'none');
	$('#mainDIV').css('display', 'block');	
	
	$('#registrarme').click(function(e){
		e.preventDefault();
		$('#mainDIV').css('display', 'none');
		$('#registroDIV').css('display', 'block');
	});
	
	//Botones cancelar
	$('#cancelarRegistro').click(function(e){
		e.preventDefault();
		$('#registroForm').trigger("reset");
		$('#registroDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});
	
	$('#cancelarContinuarRegistro').click(function(e){
		e.preventDefault();
		$('#continuarRegistroForm').trigger("reset");
		$('#continuarRegistroDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});
	
	$('#cancelarConcluir').click(function(e){
		e.preventDefault();
		$('#concluirRegistroForm').trigger("reset");
		$('#concluirDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});
	
	//Botones continuar
	$('#continuarRegistro').click(function(e){
		e.preventDefault();
		$('#registroForm').trigger("reset");
		$('#registroDIV').css('display', 'none');					
		$('#continuarRegistroDIV').css('display', 'block');
	});
	
	$('#concluirRegistro').click(function(e){
		e.preventDefault();
		$('#continuarRegistroForm').trigger("reset");
		$('#continuarRegistroDIV').css('display', 'none');
		$('#concluirDIV').css('display', 'block');
	});
	
	$('#concluir').click(function(e){
		e.preventDefault();
		$('#concluirRegistroForm').trigger("reset");
		$('#concluirDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});
	
	//Iniciar sesion
	$('#entrar').click(function(e){				
		e.preventDefault();
		
		var form = convertFormToJSON($('#loginForm'));
		formAsJSON = JSON.stringify(form)
		performLogin(formAsJSON);
		
		$('#mainDIV').css('display', 'none');
		$('#sesionDIV').css('display', 'block');
	});
	
	//Cerrar sesion
	$('#cerrarSesion').click(function(e){
		e.preventDefault();
		$('#sesionDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});
	

	var postData = JSON.stringify({'user': 'myUser'});
	$.ajax({
		  type: 'POST',
		  contentType: 'application/json; charset=utf-8',
		  dataType: 'json',
		  url: 'login',
		  data: postData		  
	}).done(function(data) {
		console.log('AJAX_RESPONSE: ' + JSON.stringify(data));
	}).fail(function(data) {
		console.log('ERROR ON AJAX CALL...\n' + JSON.stringify(data));
	});
	
	function performLogin(form){
		console.log(form);
		$.ajax({
			  type: 'POST',
			  contentType: 'application/json; charset=utf-8',
			  dataType: 'json',
			  url: 'login',
			  data: form		  
		}).done(function(data) {
			console.log('AJAX_RESPONSE: ' + JSON.stringify(data));
		}).fail(function(data) {
			console.log('ERROR ON AJAX CALL...\n' + JSON.stringify(data));
		});
	}
	
	function convertFormToJSON(form){
	    var array = jQuery(form).serializeArray();
	    var json = {};
	    
	    jQuery.each(array, function() {
	        json[this.name] = this.value || '';
	    });
	    
	    return json;
	}
});
