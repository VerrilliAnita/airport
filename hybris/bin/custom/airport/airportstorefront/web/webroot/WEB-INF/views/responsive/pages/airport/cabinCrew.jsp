<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airport Departure: ${airportDep}</title>
</head>
<body>
	<h1>Cabin Crewes List</h1>
	<ul>
		<c:forEach var="entry" items="${cabinCrewes}">
			<h3>Route: ${entry.key} </h3>
			<c:forEach var="cabinCrew" items="${entry.value}">
			<h4>${cabinCrew}</h4>
			</c:forEach>
		</c:forEach>
	</ul>
</body>
</html>