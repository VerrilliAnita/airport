<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<body>
    <h1>Commander: ${commander} month:${month}</h1>
	<ul>
		<c:forEach var="route" items="${routes}">
			<h2>Route: ${route.codeRoute}</h2>
		</c:forEach>
	</ul>
</body>
</html>