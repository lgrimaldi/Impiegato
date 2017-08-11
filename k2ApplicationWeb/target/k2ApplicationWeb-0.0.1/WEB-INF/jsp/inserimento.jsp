<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inserimento Impiegato</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
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
					document.getElementById("email").focus();
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
	</head>
	<body class="container">
		<form action="ImpiegatoServlet" method="post">
			<h2 style="text-align: center">Inserimento di un nuovo impiegato</h2>
			<hr>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">	
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Nome</span>
		  				<input type="text" class="form-control" maxlength="45" placeholder="lunghezza: 45 - Obbligatorio" id="nome" name="nome" aria-describedby="basic-addon1">
					</div>
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Cognome</span>
		  				<input type="text" class="form-control" maxlength="45" placeholder="lunghezza: 45 - Obbligatorio" id="cognome" name="cognome" aria-describedby="basic-addon1">
					</div>						
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Codice Fiscale</span>
		  				<input type="text" class="form-control" maxlength="16" placeholder="lunghezza: 16" id="codiceFiscale" name="codiceFiscale" ng-model="text" aria-describedby="basic-addon1">
					</div>						
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">E-mail</span>
		  				<input type="email" class="form-control" maxlength="45" placeholder="lunghezza: 45 - Obbligatorio" id="email" name="email" ng-model="text" aria-describedby="basic-addon1">
					</div>						
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Telefono</span>
		  				<input type="text" class="form-control" maxlength="11" placeholder="lunghezza: 11" id="telefono" name="telefono" aria-describedby="basic-addon1">
					</div>							
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Indirizzo</span>
		  				<input type="text" class="form-control" maxlength="200" maxlength="100" placeholder="lunghezza: 100" id="indirizzo" name="indirizzo" ng-model="text" aria-describedby="basic-addon1">
					</div>						
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Salario</span>
		  				<input type="text" class="form-control" placeholder="" id="salario" name="salario" ng-model="text" aria-describedby="basic-addon1">
					</div>						
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Descrizione</span>
		  				<input type="text" class="form-control" placeholder="lunghezza: 200" id="descrizione" name="descrizione" aria-describedby="basic-addon1">
					</div>							
					<br>
					<input type="hidden" name="operazione" value="registrazione">
					<button type="submit" onClick="return validate()" >
		  					Inserimento
					</button>			
				</div>
				<div class="col-md-2"></div>
			</div>
		</form>		
	</body>
</html>