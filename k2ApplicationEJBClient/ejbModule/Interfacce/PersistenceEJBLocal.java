package Interfacce;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Local;

import entita.Impiegato;

@Local
public interface PersistenceEJBLocal {
	
	public void inserimento(Impiegato impiegato) throws IOException;
	public ArrayList<Impiegato> lettura() throws IOException;
	public void modifica(Impiegato impiegato) throws IOException;
	public Impiegato cancellazione(String codiceFiscale) throws IOException;
	public ArrayList<Impiegato> filtro(String nome, String cognome, String eMail, String indirizzo, String telefono, 
									   String codiceFiscale, double minimo, double massimo, String descrizione) throws IOException;

}
