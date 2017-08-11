package gestione;

import java.io.IOException;
import java.util.ArrayList;

import entita.Impiegato;

public interface InterfacciaGestioneCSVImpiegato {
	
	public void inserimentoCSV(ArrayList<Impiegato> listaImpiegati) throws IOException;
	public ArrayList<Impiegato> letturaCSV() throws IOException;
	public void modificaCSV(Impiegato impiegato) throws IOException;
	public void cancellazioneCSV(int id) throws IOException;

}
