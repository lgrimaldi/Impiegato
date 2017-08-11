<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Locale"%>
<%@page import="entita.Impiegato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Elenco Impiegati</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	</head>
	<body class="container">
		<hr>
		<div class="panel panel-default">
			<div class="panel-heading">Elenco Impiegati da CSV</div>
			<div>
				<table class="table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Cognome</th>
							<th>Codice Fiscale</th>
							<th>EMail</th>
							<th>Telefono</th>
							<th>Indirizzo</th>
							<th>Salario</th>
							<th>Descrizione</th>
							<th><p><i>(modifica)</i></p></th>
							<th><p><i>(cancellazione)</i></p></th>
						</tr>
					</thead>
					<tbody>
						<%
							@SuppressWarnings("unchecked")
							ArrayList<Impiegato> listaImpiegatiCSV = (ArrayList<Impiegato>) request.getAttribute("listaImpiegatiCSV");
							if (listaImpiegatiCSV!=null) {
								for (Impiegato impiegato:listaImpiegatiCSV) {
						%>
						<tr>
							<th><%= impiegato.getId()%></th>
							<td><%= impiegato.getNome()%></td>
							<td><%= impiegato.getCognome()%></td>
							<td><%= impiegato.getCodiceFiscale()%></td>
							<td><%= impiegato.geteMail()%></td>
							<td><%= impiegato.getTelefono()%></td>
							<td><%= impiegato.getIndirizzo()%></td>
							<td><%= impiegato.getSalario()%></td>
							<td><%= impiegato.getDescrizione()%></td>
							<td>
								<form action="${pageContext.request.contextPath}/ImpiegatoServlet" method="post">
									<input type="hidden" name="operazione" value="modificaCSV">
									<input type="hidden" name="id" value="<%= impiegato.getId()%>">
									<p align="center">
										<button type="submit" class="btn btn-default btn-sm" title="modifica">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										</button>
									</p>
								</form>
							</td>
							<td>
								<form action="${pageContext.request.contextPath}/ImpiegatoServlet" method="post">
									<input type="hidden" name="operazione" value="cancellazioneCSV">
									<input type="hidden" name="id" value="<%= impiegato.getId()%>">
									<p align="center">
										<button type="submit" class="btn btn-default btn-sm" title="cancellazione"
											onClick="return confirm('Confermi cancellazione <%=impiegato.getId()%> <%=impiegato.getNome()%> <%=impiegato.getCognome()%>?');">
											<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
										</button>
									</p>
								</form>
							</td>

						</tr>
						<%
							} }
						%>
					</tbody>
				</table>
			</div>
		</div>
		<hr>
		<div class="panel panel-default">
			<div class="panel-heading">Elenco Impiegati da DB</div>
			<div>
				<table class="table">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Cognome</th>
							<th>Codice Fiscale</th>
							<th>EMail</th>
							<th>Telefono</th>
							<th>Indirizzo</th>
							<th>Salario</th>
							<th>Descrizione</th>
							<th><p><i>(modifica)</i></p></th>
							<th><p><i>(cancellazione)</i></p></th>
						</tr>
					</thead>
					<tbody>
						<%
							@SuppressWarnings("unchecked")
							ArrayList<Impiegato> listaImpiegati = (ArrayList<Impiegato>) request.getAttribute("listaImpiegati");
							if (listaImpiegati!=null) {
								for (Impiegato impiegato:listaImpiegati) {
						%>
						<tr>
							<td><%= impiegato.getNome()%></td>
							<td><%= impiegato.getCognome()%></td>
							<td><%= impiegato.getCodiceFiscale()%></td>
							<td><%= impiegato.geteMail()%></td>
							<td><%= impiegato.getTelefono()%></td>
							<td><%= impiegato.getIndirizzo()%></td>
							<td><%= impiegato.getSalario()%></td>
							<td><%= impiegato.getDescrizione()%></td>
							<td>
								<form action="${pageContext.request.contextPath}/ImpiegatoServlet" method="post">
									<input type="hidden" name="operazione" value="modifica">
									<input type="hidden" name="codiceFiscale" value="<%=impiegato.getCodiceFiscale()%>">
									<p align="center">
										<button type="submit" class="btn btn-default btn-sm" title="modificaJPA">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										</button>
									</p>
								</form>
							</td>
							<td>
								<form action="${pageContext.request.contextPath}/ImpiegatoServlet" method="post">
									<input type="hidden" name="operazione" value="cancellazione">
									<input type="hidden" name="codiceFiscale" value="<%=impiegato.getCodiceFiscale()%>">
									<p align="center">
										<button type="submit" class="btn btn-default btn-sm" title="cancellazione"
											onClick="return confirm('Confermi cancellazione <%=impiegato.getCodiceFiscale()%> <%=impiegato.getNome()%> <%=impiegato.getCognome()%>?');">
											<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
										</button>
									</p>
								</form>
							</td>

						</tr>
						<%
							} }
						%>
					</tbody>
				</table>
			</div>
		</div>
		<div class="container">
			<hr>
			<a href="${pageContext.request.contextPath}/index.jsp">
				<button type="button" >
					Home
				</button>
			</a>
		</div>
	</body>
</html>