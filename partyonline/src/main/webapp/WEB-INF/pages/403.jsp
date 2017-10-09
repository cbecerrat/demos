<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>HTTP Status 403 - Acceso denegado</h1>

	<c:choose>
		<c:when test="${empty username}">
			<h2>Usted no tiene permiso para acceder a esta página!</h2>
		</c:when>
		<c:otherwise>
			<h2>
				El usuario : ${username} <br /> No tiene permiso para acceder esta página!
			</h2>
		</c:otherwise>
	</c:choose>
</body>
</html>