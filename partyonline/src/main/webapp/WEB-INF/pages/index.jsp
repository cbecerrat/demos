<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>		
		<!-- Required meta tags -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">						
		<link rel="stylesheet" href="<c:url value="/resources/fontAwesome/css/font-awesome.css"/>">
		<style>
			.badge{
				background-color: red;
				font-size: medium;
				float: right;
				border-radius: 50%;
			}

			.fa-stack[data-count]:after{
				position:absolute;								
				content: attr(data-count);
				font-size:45%;
				padding:.6em;
				border-radius:999px;
				line-height:.75em;
				color: white;
				background:rgba(255,0,0,.85);
				text-align:center;
				min-width:2em;
				font-weight:bold;
			}
			
			.radio-inline{
				padding: 15px;
			}
		</style>
	</head>
	<body>	
		<div id="loading" class="text-center container">
			<i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>			
		</div>
		<div id="mainDIV" class="container" style="display:none;">
			<div class="text-center">
				<img src="resources/images/party.jpg" style="width: 100%"/>
			</div>
			</br>
			<form>
				<div class="form-group">
					<label for="usuario">Usuario:</label>
					<input class="form-control" id="usuario"placeholder="Tu nombre de usuario">			
				</div>
				<div class="form-group">
					<label for="contrasenia">Contrase&ntilde;a:</label>
					<input type="password" class="form-control" id="contrasenia" placeholder="Contrase&ntilde;a">
				</div>
				<div class="text-center">
					<button id="entrar" type="submit" class="btn btn-primary">Entrar</button>
				</div>
				<div class="form-group">
					</br></br>
					<a href="javascript:;" id="registrarme">Registrarme.</a>
					</br></br>
					<a href="javascript:;">&iquest;Olvidaste tu contrase&ntilde;a?</a>
				</div>
			</form>
		</div>
		
		<div id="registroDIV" class="container" style="display:none;">
			<div class="text-center">
				<h3>PartyOnline registro:</h3>
			</div>
			<form id="registroForm">
				<div class="form-group">
					<label for="usuario">Usuario:</label>
					<input class="form-control" id="usuario" placeholder="jalfredoj">
				</div>
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input class="form-control" id="nombre" placeholder="Jos&eacute; Alfredo">
				</div>
				<div class="form-group">
					<label for="appelidos">Apellidos:</label>
					<input class="form-control" id="appelidos" placeholder="Jim&eacute;nez">
				</div>
				<div class="form-group">
					<label for="email">Email</label>
					<input type="email" class="form-control" id="email" placeholder="ejemplo@mail.com">
				</div>
				<div class="form-group">
					<label for="celular">Celular:</label>
					<input class="form-control" id="celular" aria-describedby="celularHelp" placeholder="55-5555-5555">
					<small id="celularHelp" class="form-text text-muted">No compartimos esta informaci&oacute;n con nadie.</small>
				</div>				
				<div class="form-group">
					<label for="contrasenia">Contrase&ntilde;a:</label>
					<input type="password" class="form-control" id="contrasenia" placeholder="********">
				</div>
				<div class="form-group">
					<label for="confirmaContrasenia">Confirmar contrase&ntilde;a:</label>
					<input type="password" class="form-control" id="confirmaContrasenia" placeholder="********">
				</div>
				<div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
					<div class="btn-group mr-2" role="group" aria-label="First group">
						<button id="cancelarRegistro" type="submit" class="btn btn-primary">Cancelar</button>
					</div>
					<div class="btn-group mr-2" role="group" aria-label="Second group">	
						<button id="continuarRegistro" type="submit" class="btn btn-primary">Continuar</button>
					</div>
				</div>
			</form>
		</div>
		
		<div id="continuarRegistroDIV" class="container" style="display:none;">
			<form id="continuarRegistroForm">
				<div class="form-group">
					<label for="formaPago">Forma de pago:</label>
					<select class="form-control" id="formaPago">
						<option value="tarjetaCredito">Tarjeta de Cr&eacute;dito</option>
						<option value="tarjetaDebito">Tarjeta de D&eacute;bito</option>
						<option value="paypal">Paypal</option>						
					</select>
				</div>
					
				<div class="text-center container">
					<label class="radio-inline"><input type="radio" name="optradio">Visa</label>
					<label class="radio-inline"><input type="radio" name="optradio">Mastercard</label>						
				</div> 
				
				<div class="form-group">
					<label for="numeroTarjeta">N&uacute;mero de tarjeta:</label>
					<input class="form-control" id="numeroTarjeta" placeholder="1111 2222 3333 4444">
				</div>
				
				<div class="form-group">
					<label for="codigoSeguridad">C&oacute;digo de seguridad:</label>
					<input class="form-control" id="codigoSeguridad" placeholder="555">
				</div>
				
				<div class="form-group">
					<label for="fechaVencimiento">Fecha de vencimiento:</label>
					<input class="form-control" id="fechaVencimiento" placeholder="dd/mm/aa">
				</div>
				
				<div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
					<div class="btn-group mr-2" role="group" aria-label="First group">
						<button id="cancelarContinuarRegistro" type="submit" class="btn btn-primary">Cancelar</button>
					</div>
					<div class="btn-group mr-2" role="group" aria-label="Second group">	
						<button id="concluirRegistro" type="submit" class="btn btn-primary">Continuar</button>
					</div>
				</div>
			</form>
		</div>
		
		<div id="concluirDIV" class="container" style="display:none;">
			<div class="text-center">
				<h3>Agregar domicilio:</h3>
			</div>
			<form id="concluirRegistroForm">
				<div class="form-group">
					<label for="calle">Calle:</label>
					<input class="form-control" id="calle" placeholder="Xicoht&eacute;ncatl">
				</div>
				
				<div class="form-group">
					<label for="calle">N&uacute;mero exterior:</label>
					<input class="form-control" id="calle" placeholder="125">
				</div>
				
				<div class="form-group">
					<label for="calle">N&uacute;mero interior:</label>
					<input class="form-control" id="calle" placeholder="125-A">
				</div>
	
				<div class="form-group">
					<label for="calle">Colonia:</label>
					<input class="form-control" id="calle" placeholder="Santa Ana">
				</div>
				
				<div class="form-group">
					<label for="calle">Estado:</label>
					<input class="form-control" id="calle" placeholder="Tlaxcala">
				</div>
				
				<div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
					<div class="btn-group mr-2" role="group" aria-label="First group">
						<button id="cancelarConcluir" type="submit" formaction="index.html"  class="btn btn-primary">Cancelar</button>
					</div>
					<div class="btn-group mr-2" role="group" aria-label="Second group">	
						<button id="concluir" type="submit" formaction="index.html" class="btn btn-primary">Terminar</button>
					</div>
				</div>
			</form>
		</div>
		
		<div id="sesionDIV" class="container" style="display:none;">
			<div class="text-center">
				<img src="resources/images/party.jpg" style="width: 100%"/>
			</div>
			</br>
			<form>				
				<div class="text-center">
					<h3>Bienvenido [Usuario]</h3>
				</div>				
				</br></br></br>
				<div class="text-center">					
					<i class="fa fa-stack fa-shopping-cart fa-2x" aria-hidden="true" data-count="10"></i>
					&nbsp;
					<i class="fa fa-stack fa-search fa-2x" aria-hidden="true"></i>					
					<i class="fa fa-stack fa-bars fa-2x" aria-hidden="true"></i>
				<div>
				</br></br></br>

				<div class="text-center">
					<button id="cerrarSesion"type="submit" class="btn btn-primary">Cerrar sesi&oacute;n</button>
				</div>
			</form>
		</div>
		
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
		<script src="<c:url value="/resources/javascript/functions.js"/>"></script>	
	</body>
</html>