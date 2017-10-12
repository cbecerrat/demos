$(document).ready(function() {
	$('#registrarme').click(function(e){
		e.preventDefault();
		$('#mainDIV').css('display', 'none');
		$('#registroDIV').css('display', 'block');
	});
	
	//registroDIV
	$('#cancelarRegistro').click(function(e){
		e.preventDefault();
		$('#registroForm').trigger("reset");
		$('#registroDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});
	
	$('#continuarRegistro').click(function(e){
		e.preventDefault();
		$('#registroForm').trigger("reset");
		$('#registroDIV').css('display', 'none');					
		$('#continuarRegistroDIV').css('display', 'block');
	});
	
	//continuarRegistroDIV
	$('#cancelarContinuarRegistro').click(function(e){
		e.preventDefault();
		$('#continuarRegistroForm').trigger("reset");
		$('#continuarRegistroDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});
	
	$('#concluirRegistro').click(function(e){
		e.preventDefault();
		$('#continuarRegistroForm').trigger("reset");
		$('#continuarRegistroDIV').css('display', 'none');
		$('#concluirDIV').css('display', 'block');
	});	
	
	//concluirDIV
	$('#cancelarConcluir').click(function(e){
		e.preventDefault();
		$('#concluirRegistroForm').trigger("reset");
		$('#concluirDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});	
	
	$('#concluir').click(function(e){
		e.preventDefault();
		$('#concluirRegistroForm').trigger("reset");
		$('#concluirDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});
	
	//Olvide mi contrasenia
	$('#olvideContrasenia').click(function(e){				
		e.preventDefault();
		$('#mainDIV').css('display', 'none');
		$('#recuperarContraseniaDIV').css('display', 'block');
	});
	
	$('#cancelarRecuperarContrasenia').click(function(e){
		e.preventDefault();
		$('#recuperarContraseniaForm').trigger("reset");
		$('#recuperarContraseniaDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});
	
	$('#confirmarRecuperarContrasenia').click(function(e){				
		e.preventDefault();
		$('#recuperarContraseniaForm').trigger("reset");		
		$('#recuperarContraseniaDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});
	
	//Iniciar sesion
	$('#entrar').click(function(e){				
		e.preventDefault();		
		performLogin();
		
		$('#mainDIV').css('display', 'none');
		$('#sesionDIV').css('display', 'block');
	});
	
	//Cerrar sesion
	$('#cerrarSesion').click(function(e){
		e.preventDefault();
		$('#sesionDIV').css('display', 'none');
		$('#mainDIV').css('display', 'block');
	});
	
	//miCarritoDIV
	$('#miCarrito').click(function(e){				
		e.preventDefault();
		$('#sesionDIV').css('display', 'none');
		$('#miCarritoDIV').css('display', 'block');
	});
	
	$('#continuarComprando').click(function(e){				
		e.preventDefault();
		$('#miCarritoDIV').css('display', 'none');
		$('#sesionDIV').css('display', 'block');
	});
	
	function performLogin(){
		var oldValue = $('#password').val();
		$('#password').val(digest(oldValue));
		
		var form = convertFormToJSON($('#loginForm'));
		formAsJSON = JSON.stringify(form);				
		$('#password').val(oldValue);
		oldValue = "";
		
		$.ajax({
			  type: 'POST',
			  contentType: 'application/json; charset=utf-8',
			  dataType: 'json',
			  url: 'login',
			  data: formAsJSON		  
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
	
	$('#loading').css('display', 'none');
	$('#mainDIV').css('display', 'block');	
});
