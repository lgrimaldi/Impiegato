package gestione;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import entita.Impiegato;

public class GestioneCSVImpiegato implements InterfacciaGestioneCSVImpiegato{
	
	@Override
	public void inserimentoCSV(ArrayList<Impiegato> listaImpiegati) throws IOException {
		FileWriter file = new FileWriter("C:/Users/Lucio Grimaldi/Desktop/DT/Impiegato/Impiegato.csv");
		// Crea la riga con i separatori ";" da scrivere sul file
		for (Impiegato corrente : listaImpiegati) {
			String output = corrente.getNome() + ";";
			output = output + corrente.getCognome() + ";";
			output = output + corrente.getCodiceFiscale() + ";";
			output = output + corrente.geteMail() + ";";
			output = output + corrente.getTelefono() + ";";
			output = output + corrente.getIndirizzo() + ";";
			output = output + corrente.getSalario() + ";";
			output = output + corrente.getDescrizione() + ";";
			file.append(output + System.lineSeparator());
		}
		file.close();
	}

	@Override
	public ArrayList<Impiegato> letturaCSV() throws IOException {
		FileReader file = new FileReader("C:/Users/Lucio Grimaldi/Desktop/DT/Impiegato/Impiegato.csv");
		BufferedReader buffer = new BufferedReader(file);
		ArrayList<Impiegato> ritorno = new ArrayList<Impiegato>(); 
		String riga = buffer.readLine();
		int id = 0;
		// carica negli attributi della classe i vari pezzi della riga
		while (riga != null) {
			String[] pezzoRiga = riga.split(";");
			Impiegato impiegato = new Impiegato();
			id = id + 1;
			impiegato.setId(id);
			impiegato.setNome(pezzoRiga[0]);
			impiegato.setCognome(pezzoRiga[1]);
			impiegato.setCodiceFiscale(pezzoRiga[2]);
			impiegato.seteMail(pezzoRiga[3]);
			impiegato.setTelefono(pezzoRiga[4]);
			impiegato.setIndirizzo(pezzoRiga[5]);
			impiegato.setSalario(Double.parseDouble(pezzoRiga[6]));
			impiegato.setDescrizione(pezzoRiga[7]);
			ritorno.add(impiegato);
			riga = buffer.readLine();
		}
		buffer.close();
		return ritorno;
	}

	@Override
	public void modificaCSV(Impiegato impiegatoDaModificare) throws IOException {
		ArrayList<Impiegato> listaImpiegati = letturaCSV();
		System.out.println("id modifica: " + impiegatoDaModificare.getId());
		// scorre la collezione di impiegati
		for (int i = 0; i < listaImpiegati.size(); i++) {
			// cerca l'impiegato che ha l'id interessato
			System.out.println("lista id: " + listaImpiegati.get(i).getId());
			if(listaImpiegati.get(i).getId() == impiegatoDaModificare.getId()){
				System.out.println("Trovato");
				listaImpiegati.set(i, impiegatoDaModificare);
			}
		}
		File file = new File("C:/Users/Lucio Grimaldi/Desktop/DT/Impiegato/Impiegato.csv");
		file.delete();
		inserimentoCSV(listaImpiegati);
	}

	@Override
	public void cancellazioneCSV(int id) throws IOException {
		ArrayList<Impiegato> listaImpiegati = letturaCSV();
		Iterator<Impiegato> i = listaImpiegati.iterator();
		// Cerca l'impiegato da cancellare
		while(i.hasNext()){
			Impiegato impiegato = i.next();
			// Trovato l'impiegato, lo cancella
			if(impiegato.getId()==id){
				i.remove();
			}
		}
		File file = new File("C:/Users/Lucio Grimaldi/Desktop/DT/Impiegato/Impiegato.csv");
		file.delete();
		inserimentoCSV(listaImpiegati);
	}

}
