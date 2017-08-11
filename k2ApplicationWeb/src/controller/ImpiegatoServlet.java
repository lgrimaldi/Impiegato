package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interfacce.PersistenceEJBLocal;
import entita.Impiegato;
import gestione.GestioneCSVImpiegato;

/**
 * Servlet implementation class ImpiegatoServlet
 */
@WebServlet("/ImpiegatoServlet")
public class ImpiegatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	@EJB(lookup="java:app/k2ApplicationWeb-0.0.1/PersistenceEJB!Interfacce.PersistenceEJBLocal")
    private PersistenceEJBLocal bean; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImpiegatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestioneCSVImpiegato csvImpiegato = null;
		Impiegato impiegato = null;
		ArrayList<Impiegato> listaImpiegati = null;
		ArrayList<Impiegato> listaImpiegatiCSV = null;
		ArrayList<Impiegato> listaImpiegatiDB = null;
		String operazione = request.getParameter("operazione");
		String forward = "/index.jsp";
		switch (operazione) {		
		// Apre la pagina di digitazione dei dati da inserire
		case "inserimento":	
			forward = "/WEB-INF/jsp/inserimento.jsp";
			break;
		// Ricerca 
		case "ricerca":	
			forward = "/WEB-INF/jsp/ricerca.jsp";
			break;
		// registra i dati 
		case "registrazione":
			// Registrazione sul file csv
			csvImpiegato = new GestioneCSVImpiegato();
			try {
				listaImpiegati = csvImpiegato.letturaCSV();				
				int id = listaImpiegati.size() + 1;
				impiegato = new Impiegato();
				impiegato.setId(id);
				impiegato.setCognome(request.getParameter("cognome"));
				impiegato.setNome(request.getParameter("nome"));
				impiegato.seteMail(request.getParameter("email"));
				impiegato.setIndirizzo(request.getParameter("indirizzo"));
				impiegato.setTelefono(request.getParameter("telefono"));
				impiegato.setCodiceFiscale(request.getParameter("codiceFiscale"));
				impiegato.setDescrizione(request.getParameter("descrizione"));
				impiegato.setSalario(Double.parseDouble(request.getParameter("salario")));	
				listaImpiegati.add(impiegato);
				csvImpiegato.inserimentoCSV(listaImpiegati);
				forward="/index.jsp";
				request.setAttribute("impiegatoInserito", impiegato);
			} catch (IOException e) {
				request.setAttribute("errore", "Errore nella scrittura sul file "+e.getMessage());
			} catch (NumberFormatException e) {
				request.setAttribute("errore", "Errore nella digitazione del numero decimale "+e.getMessage());
			} 
			// Registrazione sul db
			try {
				impiegato = new Impiegato();
				impiegato.setCognome(request.getParameter("cognome"));
				impiegato.setNome(request.getParameter("nome"));
				impiegato.seteMail(request.getParameter("email"));
				impiegato.setIndirizzo(request.getParameter("indirizzo"));
				impiegato.setTelefono(request.getParameter("telefono"));
				impiegato.setCodiceFiscale(request.getParameter("codiceFiscale"));
				impiegato.setDescrizione(request.getParameter("descrizione"));
				impiegato.setSalario(Double.parseDouble(request.getParameter("salario")));	
				bean.inserimento(impiegato);
				forward="/index.jsp";
				request.setAttribute("impiegatoInserito", impiegato);
			} catch (IOException e) {
				request.setAttribute("errore", "Errore nella scrittura sul db "+e.getMessage());
			}catch (NumberFormatException e) {
				request.setAttribute("errore", "Errore nella digitazione del numero decimale "+e.getMessage());
			} 
			break;
			// Visualizzazione di dati letti
			case "visualizzazione":
				forward="/WEB-INF/jsp/lista.jsp";
				// Lista con i dati del file csv
				csvImpiegato = new GestioneCSVImpiegato();
				try {
					listaImpiegati = csvImpiegato.letturaCSV();
					request.setAttribute("listaImpiegatiCSV", listaImpiegati);
				} catch (IOException e) {
					request.setAttribute("errore", "Errore nella lettura dal file "+e.getMessage());
				} 
				// Lista con i dati del file db
				try {
					listaImpiegati = bean.lettura();
					request.setAttribute("listaImpiegati", listaImpiegati);
				} catch (IOException e) {
					request.setAttribute("errore", "Errore nella lettura dal db "+e.getMessage());
				} 
				break;
			// Modifica dei dati CSV	
			case "modificaCSV":
				forward="/WEB-INF/jsp/modificaCSV.jsp";
				csvImpiegato = new GestioneCSVImpiegato();
				try {
					listaImpiegati = csvImpiegato.letturaCSV();
					// Cerca il record da modificre
					for (Impiegato impiegato2 : listaImpiegati) {
						if (impiegato2.getId()==Integer.parseInt(request.getParameter("id")))
							impiegato=impiegato2;
					}
					request.setAttribute("impiegatoDaModificare", impiegato);
				} catch (IOException e) {
					request.setAttribute("errore", "Errore nella lettura dal file "+e.getMessage());
				} 
				break;
			// Modifica di un dato del file db
			case "modifica":
				forward="/WEB-INF/jsp/modifica.jsp";				
				try {
					listaImpiegati = bean.lettura();
					// Ciclo di ricerca del record con il giusto codice fiscale
					for (Impiegato impiegato2 : listaImpiegati) {
						if (impiegato2.getCodiceFiscale().equals(request.getParameter("codiceFiscale")))
							impiegato=impiegato2;
					}
					request.setAttribute("impiegato", impiegato);
				} catch (IOException e) {
					request.setAttribute("errore", "Errore nella lettura dal file "+e.getMessage());
				} 
				break;
			// Modifica di un dato del file CSV
			case "modificaRecordCSV":
				forward="/index.jsp";
				try {
					impiegato = new Impiegato();
					impiegato.setId(Integer.parseInt(request.getParameter("id")));
					impiegato.setCognome(request.getParameter("cognome"));
					impiegato.setNome(request.getParameter("nome"));
					impiegato.seteMail(request.getParameter("email"));
					impiegato.setIndirizzo(request.getParameter("indirizzo"));
					impiegato.setTelefono(request.getParameter("telefono"));
					impiegato.setCodiceFiscale(request.getParameter("codiceFiscale"));
					impiegato.setDescrizione(request.getParameter("descrizione"));
					impiegato.setSalario(Double.parseDouble(request.getParameter("salario")));	
					csvImpiegato = new GestioneCSVImpiegato();
					csvImpiegato.modificaCSV(impiegato);
					forward="/index.jsp";
					request.setAttribute("impiegatoInserito", impiegato);
				} catch (IOException e) {
					request.setAttribute("errore", "Errore nella scrittura sul file "+e.getMessage());
				} 
				break;
			// Modifica di un dato del DB	
			case "modificaJPA":
				forward="/index.jsp";
				try {
					impiegato = new Impiegato();
					impiegato.setCognome(request.getParameter("cognome"));
					impiegato.setNome(request.getParameter("nome"));
					impiegato.seteMail(request.getParameter("email"));
					impiegato.setIndirizzo(request.getParameter("indirizzo"));
					impiegato.setTelefono(request.getParameter("telefono"));
					impiegato.setDescrizione(request.getParameter("descrizione"));
					impiegato.setSalario(Double.parseDouble(request.getParameter("salario")));	
					impiegato.setCodiceFiscale(request.getParameter("codiceFiscale"));
					System.out.println(request.getParameter("codiceFiscale"));
					bean.modifica(impiegato);
					request.setAttribute("impiegatoInserito", impiegato);
				} catch (IOException e) {
					request.setAttribute("errore", "Errore nella scrittura sul file "+e.getMessage());
				} 
				break;
			// Cancellazione di una riga del file CSV
			case "cancellazioneCSV":
				// Cancellazione di una riga del CSV
				csvImpiegato = new GestioneCSVImpiegato();
				try {
					csvImpiegato.cancellazioneCSV(Integer.parseInt(request.getParameter("id")));
					listaImpiegati = csvImpiegato.letturaCSV();
					request.setAttribute("listaImpiegati", listaImpiegati);
				} catch (IOException e) {
					request.setAttribute("errore", "Errore nella lettura dal file "+e.getMessage());
				} 
				break;	

			// Cancellazione di una riga della tabella
			case "cancellazione":
				try {
					bean.cancellazione(request.getParameter("codiceFiscale"));
					listaImpiegati = bean.lettura();
					request.setAttribute("listaImpiegati", listaImpiegati);
				} catch (IOException e) {
					request.setAttribute("errore", "Errore nella lettura dal db "+e.getMessage());
				} 
				
				break;	
			// Visualizzazione di dati filtrati
			case "ricercaImpiegato":
				forward="/WEB-INF/jsp/lista.jsp";
				// Lista con i dati del file csv
				csvImpiegato = new GestioneCSVImpiegato();
				listaImpiegati = new ArrayList<Impiegato>();
				try {
					listaImpiegatiCSV  = csvImpiegato.letturaCSV();
					listaImpiegati = filtro(listaImpiegatiCSV, request);
					request.setAttribute("listaImpiegatiCSV", listaImpiegati);
				} catch (IOException e) {
					request.setAttribute("errore", "Errore nella lettura dal file "+e.getMessage());
				} 
				// Lista con i dati del file db
				listaImpiegati = new ArrayList<Impiegato>();
				try {
					listaImpiegatiDB  = bean.lettura();
					listaImpiegati = filtro(listaImpiegatiDB, request);
					request.setAttribute("listaImpiegati", listaImpiegati);
				} catch (IOException e) {
					request.setAttribute("errore", "Errore nella lettura dal db "+e.getMessage());
				} 
				break;
				
				// Visualizzazione di dati filtrati che richiama createnamedquery
				case "ricercaImpiegatoDB":
					forward="/WEB-INF/jsp/lista.jsp";
					listaImpiegati = new ArrayList<Impiegato>();
					try {
						double minimo = 0;
						double massimo = 999999;
						// Verifica se è stato digitato un valore di salario minimo
						if(!request.getParameter("salarioMinimo").isEmpty()){
							minimo = Double.parseDouble(request.getParameter("salarioMinimo"));
						}
						// Verifica se è stato digitato un valore di salario minimo
						if(!request.getParameter("salarioMassimo").isEmpty()){
							massimo = Double.parseDouble(request.getParameter("salarioMassimo"));
						}
						listaImpiegatiDB  = bean.filtro(request.getParameter("nome"), request.getParameter("cognome"), 
														request.getParameter("eMail"), request.getParameter("indirizzo"),
														request.getParameter("telefono"), request.getParameter("codiceFiscale"),
														minimo, massimo, request.getParameter("descrizione"));
						request.setAttribute("listaImpiegati", listaImpiegatiDB);
					} catch (IOException e) {
						request.setAttribute("errore", "Errore nella lettura dal db "+e.getMessage());
					} 
					break;
		}
		this.getServletContext().getRequestDispatcher(forward).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private ArrayList<Impiegato> filtro(ArrayList<Impiegato> listaImpiegatiInput, HttpServletRequest request){
		double sMinimo = 0;
		double sMassimo = 999999;
		// Verifica se è stato digitato un valore di salario minimo
		if(!request.getParameter("salarioMinimo").isEmpty()){
			sMinimo = Double.parseDouble(request.getParameter("salarioMinimo"));
		}
		// Verifica se è stato digitato un valore di salario minimo
		if(!request.getParameter("salarioMassimo").isEmpty()){
			sMassimo = Double.parseDouble(request.getParameter("salarioMassimo"));
		}
		ArrayList<Impiegato> listaImpiegatiOutput = new ArrayList<Impiegato>();
		// Ciclo di filtro in base ai valori ricevuti
		for (Impiegato impiegato : listaImpiegatiInput ) {
			// Verifica corrispondenza nome
			if (impiegato.getNome().toUpperCase().contains(request.getParameter("nome").toUpperCase()))
				// Verifica corrispondenza cognome
				if (impiegato.getCognome().toUpperCase().contains(request.getParameter("cognome").toUpperCase()))
					// Verifica corrispondenza codice fiscale
					if (impiegato.getCodiceFiscale().toUpperCase().contains(request.getParameter("codiceFiscale").toUpperCase()))
						// Verifica corrispondenza email
						if (impiegato.geteMail().toUpperCase().contains(request.getParameter("eMail").toUpperCase()))
							// Verifica corrispondenza telefono
							if (impiegato.getTelefono().toUpperCase().contains(request.getParameter("telefono").toUpperCase()))
								// Verifica corrispondenza indirizzo
								if (impiegato.getIndirizzo().toUpperCase().contains(request.getParameter("indirizzo").toUpperCase()))
									// Verifica corrispondenza salario minimo
									if (impiegato.getSalario() >= sMinimo)
										// Verifica corrispondenza salario massimo
										if (impiegato.getSalario() <= sMassimo)
											// Verifica corrispondenza descrizione
											if (impiegato.getDescrizione().toUpperCase().contains(request.getParameter("descrizione").toUpperCase()))
												listaImpiegatiOutput.add(impiegato);
		}
		return listaImpiegatiOutput;
		
		
	}

}
