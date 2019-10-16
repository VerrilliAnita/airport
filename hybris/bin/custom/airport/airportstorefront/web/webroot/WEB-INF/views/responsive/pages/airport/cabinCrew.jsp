<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<body>
    <h1>Airport Departure: ${airportDeparture.name}</h1>
	<ul>
		<c:forEach var="entry" items="${cabinCrewes}">
			<h2>Route: ${entry.key}</h2>
			<h3>Departure Airport:${airportDeparture.name} **** Arrival Airport: ${airportArrival.name}</h3>
			<h3>Cabin Crewes List</h3>
			<c:forEach var="cabinCrew" items="${entry.value}">
			<h4> Name:${cabinCrew.name}</h4>
			<h4> Fiscal Code:${cabinCrew.codeFiscal}</h4>
			</c:forEach>
		</c:forEach>
	</ul>
</body>
</html>