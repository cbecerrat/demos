<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>		
		<meta charset="ISO-8859-1">
		<title>Welcome!</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#consultar").click(function(){
					var theID = $("#id").val();
					$.ajax({
						url: "/company/getProduct?id=" + theID
					}).done(function(data){
						$("#content").text(data);						
					});
				});				
			});
		</script>
	</head>
	<body>
		</br>
		<table align="center">
			<tr>
				<td><strong>ID:</strong></td>
				<td><input id="id"></td>
				<td><button id="consultar">Consultar</button></td>
			</tr>			
		</table>
		</br>
		<table id="data" align="center" border="1">
			<tr>
				<td><label id="content"/></td>
			</tr>			
		</table>
	</body>
	
	${counter}
</html>