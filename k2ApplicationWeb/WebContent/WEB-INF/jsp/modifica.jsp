<%@page import="entita.Impiegato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Modifica Impiegato</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/ImpiegatoServlet" method="get">
			<%Impiegato impiegato = (Impiegato) request.getAttribute("impiegato"); %>
			<%if (impiegato!=null) {%>	
			<hr>
			<div class="container">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
					    <div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Nome</span>
			  				<input type="text" maxlength="45" name="nome" id="nome" class="form-control" value="<%= impiegato.getNome() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Cognome</span>
			  				<input type="text" maxlength="45" name="cognome" id="cognome" class="form-control" value="<%= impiegato.getCognome() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Codice Fiscale</span>
			  				<span class="input-group-addon" readonly="readonly" id="basic-addon1"><%= impiegato.getCodiceFiscale() %></span>
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Email</span>
			  				<input type="text" maxlength="45" name="email" id="email" class="form-control" value="<%= impiegato.geteMail() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Telefono</span>
			  				<input type="text"  maxlength="11" class="form-control" id="telefono" name="telefono" value="<%= impiegato.getTelefono() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Indirizzo</span>
			  				<input type="text" maxlength="100" name="indirizzo" id="indirizzo" class="form-control" value="<%= impiegato.getIndirizzo() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Salario</span>
			  				<input type="text" class="form-control" id="salario" name="salario" value="<%= impiegato.getSalario() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Descrizione</span>
			  				<input type="text" maxlength="200" name="descrizione" id="descrizione" class="form-control" value="<%= impiegato.getDescrizione() %>" aria-describedby="basic-addon1">
						</div>
						<br>
						<input type="hidden" name="codiceFiscale" value="<%= impiegato.getCodiceFiscale() %>" />
						<input type="hidden" name="operazione" value="modificaJPA"/>
						<button type="submit" onClick="return validate()" class="btn btn-primary" >
			  				Modifica
						</button>
						<a href="${pageContext.request.contextPath}/ImpiegatoServlet?operazione=visualizzazione">
							<button type="button" class="btn btn-primary" >
  								Torna all'Elenco
							</button>
						</a>
						<hr>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
			<%} %>
			<script type="text/javascript">
				function validate() {
					var nome, cognome, email, salario, telefono, indirizzo, descrizione; 
					nome = document.getElementById("nome").value;
					if ((nome == "") || (document.getElementById("nome").value.lenght > 45)) {
						alert("Il campo NOME è obbligatorio e di massimo 45 caratteri.");
						document.getElementById("nome").focus();
						return false;
						} 
					cognome = document.getElementById("cognome").value;
				    if ((cognome == "") || (document.getElementById("cognome").value.lenght > 45)) {
						alert("Il campo COGNOME è obbligatorio e di massimo 45 caratteri.");
						document.getElementById("nome").focus();
						return false;
						} 
					email = document.getElementById("email").value;
					if ((email == "") || (document.getElementById("email").value.lenght > 45)) {
						alert("Il campo EMAIL è obbligatorio e di massimo 45 caratteri.");
						document.getElementById("email").focus();
						return false;
						} 
					salario = document.getElementById("salario").value;
					if ((salario == "")) {
						alert("Il campo SALARIO è obbligatorio.");
						document.getElementById("salario").focus();
						return false;
						} 
					var strNumber = isNaN (salario);
					if (strNumber == true) {
					    alert ("Il campo SALARIO non è un numero!");	
						document.getElementById("salario").focus();
				        return false;
				    }		
					telefono = document.getElementById("telefono").value;	
					if ((document.getElementById("telefono").value.lenght > 11)) {
						alert("Il campo TELEFONO è di massimo 11 caratteri.");
						document.getElementById("telefono").focus();
						return false;
						} 			
					indirizzo = document.getElementById("indirizzo").value;	
					if ((document.getElementById("indirizzo").value.lenght > 100)) {
						alert("Il campo INDIRIZZO è di massimo 100 caratteri.");
						document.getElementById("indirizzo").focus();
						return false;
						}		
					descrizione = document.getElementById("descrizione").value;	
					if ((document.getElementById("descrizione").value.lenght > 100)) {
						alert("Il campo DESCRIZIONE è di massimo 200 caratteri.");
						document.getElementById("descrizione").focus();
						return false;
						} 	
				    return true; 
				}
			</script>
		</form>		
	</body>
</html>