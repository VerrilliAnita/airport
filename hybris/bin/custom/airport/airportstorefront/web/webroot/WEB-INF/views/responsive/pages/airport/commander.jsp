<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Route Commander</title>
</head>
<body>
    <h1>Route for commander: ${commander}</h1>
	<ul>
		<c:forEach var="route" items="${routes}">
			<li>${route.codeRoute}</li>
		</c:forEach>
	</ul>
</body>
</html>