<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gestione Impiegati</title>	
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	</head>
	<body class="container">
		<form action="${pageContext.request.contextPath}/ImpiegatoServlet" method="POST">
			<div class="jumbotron text-center">
			  <h1>Gestione Impiegati</h1>
			  <p>Gestione dei dati dell'impiegato su Database MySql e su file csv</p> 
			</div>
			<div class="container">
			  <div class="row">
			    <div class="col-sm-4 text-center">
			      <a href="${pageContext.request.contextPath}/ImpiegatoServlet?operazione=inserimento">
					<button type="button" class="btn btn-primary">Inserimento</button>
				  </a>
			    </div>
			    <div class="col-sm-4 text-center">
			      <a href="${pageContext.request.contextPath}/ImpiegatoServlet?operazione=ricerca">
					<button type="button" class="btn btn-primary">Ricerca</button>
				  </a>
			    </div>
			    <div class="col-sm-4 text-center">
			      <a href="${pageContext.request.contextPath}/ImpiegatoServlet?operazione=visualizzazione">
					<button type="button" class="btn btn-primary">Visualizzazione</button>
				  </a>
			    </div>
			  </div>
			</div>
		</form>
		<% if (request.getAttribute("errore")!=null) {%>
			<%=request.getAttribute("errore") %>
		<%} %>
	</body>
</html>