<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ricerca Impiegato</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
		<script type="text/javascript">  
			function validate() { 
				var salarioMinimo, salarioMassimo; 
				salarioMinimo = document.getElementById("salarioMinimo").value;
				if (salarioMinimo != "") {
					var strNumber = isNaN (salarioMinimo);
					if (strNumber == true) {
					    alert ("Il campo SALARIO MINIMO non è un numero!");	
						document.getElementById("salarioMinimo").focus();
				        return false;
				    }	
				}  
				salarioMassimo = document.getElementById("salarioMassimo").value;
				if (salarioMassimo != "") {
					var strNumber = isNaN (salarioMassimo);
					if (strNumber == true) {
					    alert ("Il campo SALARIO MASSIMO non è un numero!");	
						document.getElementById("salarioMassimo").focus();
				        return false;
				    }	
				if (salarioMassimo != "" && salarioMinimo != "" && parseInt(salarioMassimo) < parseInt(salarioMinimo)) {
					alert ("Il campo SALARIO MASSIMO è inferiore a SALARIO MINIMO!");	
						document.getElementById("salarioMinimo").focus();
				        return false;
				    }	
			    }	
			    return true; 
			}
		</script>
	</head>
	<body class="container">
		<form action="ImpiegatoServlet" method="post">
			<h2 style="text-align: center">Ricerca di impiegati</h2>
			<hr>
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">	
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Nome</span>
		  				<input type="text" class="form-control" maxlength="45" id="nome" name="nome" aria-describedby="basic-addon1">
					</div>
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Cognome</span>
		  				<input type="text" class="form-control" maxlength="45" id="cognome" name="cognome" aria-describedby="basic-addon1">
					</div>						
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Codice Fiscale</span>
		  				<input type="text" class="form-control" maxlength="16" id="codiceFiscale" name="codiceFiscale" ng-model="text" aria-describedby="basic-addon1">
					</div>						
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">E-mail</span>
		  				<input type="text" class="form-control" maxlength="45" id="eMail" name="eMail" ng-model="text" aria-describedby="basic-addon1">
					</div>						
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Telefono</span>
		  				<input type="text" class="form-control" maxlength="11" id="telefono" name="telefono" aria-describedby="basic-addon1">
					</div>							
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Indirizzo</span>
		  				<input type="text" class="form-control" maxlength="200" maxlength="100" id="indirizzo" name="indirizzo" ng-model="text" aria-describedby="basic-addon1">
					</div>						
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Salario (Minimo)</span>
		  				<!-- <input type="text" class="form-control" value="0" id="salarioMinimo" name="salarioMinimo" aria-describedby="basic-addon1"> -->
		  				<input type="text" class="form-control" id="salarioMinimo" name="salarioMinimo" aria-describedby="basic-addon1">
					</div>
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Salario (Massimo)</span>
		  				<!-- <input type="text" class="form-control" value="999999" id="salarioMassimo" name="salarioMassimo" aria-describedby="basic-addon1"> -->
		  				<input type="text" class="form-control" id="salarioMassimo" name="salarioMassimo" aria-describedby="basic-addon1">
					</div>						
					<div class="input-group">
		  				<span class="input-group-addon" id="basic-addon1">Descrizione</span>
		  				<input type="text" class="form-control" id="descrizione" name="descrizione" aria-describedby="basic-addon1">
					</div>							
					<br>
					<input type="hidden" name="operazione" value="ricercaImpiegatoDB">
					<button type="submit" onClick="return validate()">
		  					Ricerca
					</button>			
				</div>
				<div class="col-md-1"></div>
			</div>
		</form>		
	</body>
</html>