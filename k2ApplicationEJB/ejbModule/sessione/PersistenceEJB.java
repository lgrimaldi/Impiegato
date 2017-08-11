package sessione;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import Interfacce.PersistenceEJBLocal;
import Interfacce.PersistenceEJBRemote;
import gestione.GestioneJPAImpiegato;

import entita.Impiegato;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class PersistenceEJB implements PersistenceEJBLocal, PersistenceEJBRemote {
	
	private GestioneJPAImpiegato dbImpiegato;
	
	public PersistenceEJB() {
		dbImpiegato = new GestioneJPAImpiegato();
	}

	@Override
	public void inserimento(Impiegato impiegato) throws IOException {
		dbImpiegato.inserimento(impiegato);
	}
	
	@Override
	public ArrayList<Impiegato> lettura() throws IOException {
		return dbImpiegato.lettura();
	}

	@Override
	public void modifica(Impiegato impiegato) throws IOException {
		dbImpiegato.modifica(impiegato);
	}

	@Override
	public Impiegato cancellazione(String codiceFiscale) throws IOException {
		return dbImpiegato.cancellazione(codiceFiscale);
	}

	@Override

	public ArrayList<Impiegato> filtro(String nome, String cognome, String eMail, String indirizzo, String telefono, 
									   String codiceFiscale, double minimo, double massimo, String descrizione) throws IOException{
		return dbImpiegato.filtro(nome, cognome, eMail, indirizzo, telefono,codiceFiscale, minimo, massimo, descrizione);
	}

}
