<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>InfoFlight</title>
</head>
<body>
	<h1>Route code: ${route.getCodeRoute()}</h1>
	<h1>Time departed ${route.getDateRouteDep()}</h1>
	<h1>Time Arrived ${route.getDateRouteArr()}</h1>
	
	<ul>
		<c:forEach var="ticket" items="${route.tickets}">
			<li>${ticket.passenger.name} , ${ticket.seat}</li>
		</c:forEach>
	</ul>
</body>
</html>