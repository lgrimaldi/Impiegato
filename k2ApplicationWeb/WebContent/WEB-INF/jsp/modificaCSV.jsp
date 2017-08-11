<%@page import="entita.Impiegato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Modifica Impiegato CSV</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	</head>
	<body>
		<%Impiegato impiegato = (Impiegato) request.getAttribute("impiegatoDaModificare"); %>
		<%if (impiegato!=null) {%>	
		<hr>
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<form action="${pageContext.request.contextPath}/ImpiegatoServlet" method="post">
					    <div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Id</span>
			  				<span class="input-group-addon" id="basic-addon1"><%= impiegato.getId() %></span>
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Nome</span>
			  				<input type="text" name="nome" maxlength="45" id="nome" class="form-control" value="<%= impiegato.getNome() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Cognome</span>
			  				<input type="text" name="cognome" maxlength="45" id="cognome" class="form-control" value="<%= impiegato.getCognome() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Codice Fiscale</span>
			  				<input type="text" name="codiceFiscale" maxlength="16" id="codiceFiscale" class="form-control" value="<%= impiegato.getCodiceFiscale() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Email</span>
			  				<input type="text" name="email" id="email" maxlength="45" class="form-control" value="<%= impiegato.geteMail() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Telefono</span>
			  				<input type="text" class="form-control" maxlength="11" id="telefono" name="telefono" value="<%= impiegato.getTelefono() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Indirizzo</span>
			  				<input type="text" name="indirizzo" maxlength="100" id="indirizzo" class="form-control" value="<%= impiegato.getIndirizzo() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Salario</span>
			  				<input type="text" class="form-control" id="salario" name="salario" value="<%= impiegato.getSalario() %>" aria-describedby="basic-addon1">
						</div>
						<div class="input-group">
			  				<span class="input-group-addon" id="basic-addon1">Descrizione</span>
			  				<input type="text" name="descrizione" maxlength="200" id="descrizione" class="form-control" value="<%= impiegato.getDescrizione() %>" aria-describedby="basic-addon1">
						</div>
						<br>
						<input type="hidden" name="id" value="<%= impiegato.getId() %>" />
						<input type="hidden" name="operazione" value="modificaRecordCSV"/>
						<button type="submit" onClick="return validate()" class="btn btn-primary">
			  					Modifica
						</button>			
						<%-- <button type="submit" onClick="return confirm('Confermi aggiornamento di <%= impiegato.getId() %> <%= impiegato.getNome() %> <%= impiegato.getCognome() %>?');" class="btn btn-primary" data-toggle="button" aria-pressed="false" >
			  				Modifica
						</button> --%>
						<a href="${pageContext.request.contextPath}/ImpiegatoServlet?operazione=visualizzazione">
							<button type="button" class="btn btn-primary" >
  								Torna all'Elenco
							</button>
						</a>
						<hr>
					</form>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
		<%} %>
		<script type="text/javascript">
			function validate() {
				var nome, cognome, email, salario, codiceFiscale, telefono, indirizzo, descrizione; 
				nome = document.getElementById("nome").value;
				if ((nome == "") || (nome.lenght > 45)) {
					alert("Il campo NOME è obbligatorio e di massimo 45 caratteri.");
					document.getElementById("nome").focus();
					return false;
					} 
				cognome = document.getElementById("cognome").value;
			    if ((cognome == "") || (cognome.lenght > 45)) {
					alert("Il campo COGNOME è obbligatorio e di massimo 45 caratteri.");
					document.getElementById("nome").focus();
					return false;
					} 
				email = document.getElementById("email").value;
				if ((email == "") || (email.lenght > 45)) {
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
			    codiceFiscale = document.getElementById("codiceFiscale").value;	
				if ((codiceFiscale == "") || (codiceFiscale.lenght > 16)) {
					alert("Il campo CODICE FISCALE è obbligatorio e di massimo 16 caratteri.");
					document.getElementById("codiceFiscale").focus();
					return false;
					} 				
				telefono = document.getElementById("telefono").value;	
				if ((telefono.lenght > 11)) {
					alert("Il campo TELEFONO è di massimo 11 caratteri.");
					document.getElementById("telefono").focus();
					return false;
					} 			
				indirizzo = document.getElementById("indirizzo").value;	
				if ((indirizzo.lenght > 100)) {
					alert("Il campo INDIRIZZO è di massimo 100 caratteri.");
					document.getElementById("indirizzo").focus();
					return false;
					}		
				descrizione = document.getElementById("descrizione").value;	
				if ((indirizzo.lenght > 100)) {
					alert("Il campo DESCRIZIONE è di massimo 200 caratteri.");
					document.getElementById("descrizione").focus();
					return false;
					} 	
			    return true; 
			}
		</script>
	</body>
</html>