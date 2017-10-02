<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
			$(document).ready(function(){
				$("#consultar").click(function(){
					var theID = $("#id").val();
					$.ajax({
						url: "/company/getProduct?id=" + theID
					}).done(function(data){
						var json = JSON.parse(data);
						var tbody = document.createElement("tbody");
						
						var header = document.createElement("tr");											
						var th = document.createElement("th");
						$(th).text("NAME");
						$(header).append(th);
						th = document.createElement("th");						
						$(th).text("PRICE");
						$(header).append(th);
						
						var tr = document.createElement("tr");
						var td = document.createElement("td");
						$(td).text(json.name);
						$(tr).append(td);
						td = document.createElement("td");
						$(td).text(json.price);
						$(tr).append(td);						
						$('#data tbody').empty().append(header);
						$('#data tbody').append(tr);
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
		<tbody></tbody>
	</table>

	<div class="container" align="center">
		<h1>This is secured!</h1>
		<p>
			Hello <b><c:out value="${pageContext.request.remoteUser}" /></b>
		</p>
		<c:url var="logoutUrl" value="/logout" />
		<form class="form-inline" action="${logoutUrl}" method="post">
			<input type="submit" value="Log out" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</body>

${counter}
</html>