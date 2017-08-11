package rest;

import javax.ws.rs.Path;
import Interfacce.PersistenceEJBLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;

import entita.Impiegato;
import model.Filtro;

// javax.ws.rs.Path:                 L'annotazione @Path identifica il modello di percorso URI a cui la risorsa risponde e viene specificato 
//						             il livello di classe o metodo di una risorsa
// javax.ejb.EJB:                    Utilizzato per specificare o iniettare una dipendenza come istanza EJB
// javax.ws.rs.POST  	             Indicatore di metodo di richiesta, Il metodo Java annotato con questo request method designator elaborerà le richieste 
//									 HTTP POST
// javax.ws.rs.core.MediaType: a
// javax.ws.rs.Consumes:             Utilizzata per specificare i tipi di rappresentazioni multimediali MIME che una risorsa può consumare che  
//                                   sono state inviate dal client.
// javax.ws.rs.Produces:             Utilizzata per specificare i tipi di supporti MIME di rappresentazioni che una risorsa può produrre ed 
//                                   inviare al client
// javax.ws.rs.core.Response:        Fornisce alcuni metodi utili che consentono di aggiungere informazioni relative alla cache, ai cookie ed 
//                                   alle intestazioni alla risposta HTTP.
// javax.ws.rs.core.Response.Status: Java enum fornito dalla specifica JAX-RS. OK, CREATED, ACCEPTED, NO_CONTENT, MOVED_PERMANENTLY, 
//									 SEE_OTHER, NOT_MODIFIED, TEMPORARY_REDIRECT, BAD_REQUEST, UNAUTHORIZED, FORBIDDEN, NOT_FOUND, 
//									 NOT_ACCEPTABLE, CONFLICT, GONE, PRECONDITION_FAILED, UNSUPPORTED_MEDIA_TYPE, INTERNAL_SERVER_ERROR, 
//									 SERVICE_UNAVAILABLE
// javax.ws.rs.PathParam             Tipo di parametro. I parametri del percorso URI vengono estratti dall'URI della richiesta ed i nomi dei 
//                                   parametri corrispondono ai nomi delle variabili dei modelli di percorso URI specificati nell'annotazione 
//                                   a livello di classe @Path.
// javax.ws.rs.GET					 Indicatore di metodo di richiesta. Il metodo Java annotato con questo indicatore di metodo di richiesta elaborerà le 
//									 richieste HTTP GET. 
// javax.ws.rs.PUT					 Indicatore di metodo di richiesta. Il metodo Java annotato con questo indicatore di metodo di richiesta elaborerà le 
//									 richieste HTTP PUT. 
// import javax.ws.rs.DELETE		 Indicatore di metodo di richiesta. Il metodo Java annotato con questo designatore di metodo di richiesta elaborerà le 
//									 richieste HTTP DELETE. 
// javax.ws.rs.PathParam			 Tipo di parametro estratto. 
@Path("/impiegato")
public class ServiziRest {
	
	@EJB
	private PersistenceEJBLocal bean;
	
	// Inserimento di un impiegato
	@POST
	@Path("/inserimento")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserimento(Impiegato impiegato) throws Exception{
		try {
			bean.inserimento(impiegato);
			return Response.status(Status.ACCEPTED).entity(impiegato).build();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	// Elenco impiegati
	@GET
	@Path("/lettura")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response lettura() throws Exception {
		ArrayList<Impiegato> listaImpiegati = bean.lettura();
		return Response.status(Status.OK).entity(listaImpiegati).build();
	}
	
	// Modifica impiegato
	@PUT
	@Path("/modifica")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response modifica(Impiegato impiegato) throws Exception{
		try{
			bean.modifica(impiegato);
			return Response.status(Status.ACCEPTED).entity(impiegato).build();
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	// Cancellazione impiegato
	@DELETE
	@Path("/{codiceFiscale}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancellazione(@PathParam("codiceFiscale") String codiceFiscale) throws Exception{
		Impiegato impiegato = bean.cancellazione(codiceFiscale);
		// Verifica se la cancellazione ha avuto esito positivo
		if (impiegato != null) {
			return Response.status(Status.ACCEPTED).entity(impiegato).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	// Elenco impiegati per filtro
	@GET
	@Path("/filtro")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response filtro(Filtro filtro) throws Exception {
		System.out.println(filtro.getCodiceFiscale());
		ArrayList<Impiegato> listaImpiegati = bean.filtro(filtro.getNome(), filtro.getCognome(), filtro.geteMail(), filtro.getIndirizzo(), 
														  filtro.getTelefono(), filtro.getCodiceFiscale(), filtro.getMinimo(), filtro.getMassimo(), 
														  filtro.getDescrizione());
		if (listaImpiegati != null) {
			return Response.status(Status.OK).entity(listaImpiegati).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
		
	}

	// Elenco impiegati per filtro
	@GET
	@Path("/{nome}/{cognome}/{codiceFiscale}/{eMail}/{telefono}/{indirizzo}/{minimo}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response filtro(@PathParam("nome") String nome, @PathParam("cognome") String cognome, 
						   @PathParam("eMail") String eMail, @PathParam("indirizzo") String indirizzo, @PathParam("telefono") String telefono, 
						   @PathParam("codiceFiscale") String codiceFiscale, @PathParam("minimo") Integer minimo) throws Exception {
		ArrayList<Impiegato> listaImpiegati = bean.filtro(nome, cognome, eMail, indirizzo, telefono, codiceFiscale, minimo, 1921, "c");
		System.out.println("********* Nome:" + nome);
		System.out.println("********* Cognome:" + cognome);
		System.out.println("********* EMail:" + eMail);
		System.out.println("********* Indirizzo:" + indirizzo);
		System.out.println("********* Telefono:" + telefono);
		System.out.println("********* Codice Fiscale:" + codiceFiscale);
		System.out.println("********* Salario Minimo:" + minimo);
		if (listaImpiegati != null) {
			return Response.status(Status.OK).entity(listaImpiegati).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
		
	}
}
