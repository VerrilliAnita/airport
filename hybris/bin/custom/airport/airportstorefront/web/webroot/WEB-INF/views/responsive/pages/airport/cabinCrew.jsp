<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<h1>Airport Departure: ${airportData.name}</h1>
	<h1>Cabin Crewes List</h1>
	<ul>
		<c:forEach var="entry" items="${cabinCrewes}">
			<h2>Route: ${entry.key}</h2>
			<h3>Departure Airport:${airportDeparture.name} **** Arrival Airport: ${airportArrival.name}</h3>
			<h3>Cabin Crewes List</h3>
			<c:forEach var="cabinCrew" items="${entry.value}">
			<h4>${cabinCrew.name}</h4>
			<h4>${cabinCrew.codeFiscal}</h4>

			</c:forEach>
		</c:forEach>
	</ul>
</body>
</html>