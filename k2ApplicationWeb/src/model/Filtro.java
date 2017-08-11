package model;

public class Filtro {
	
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String eMail;
	private String telefono;
	private String indirizzo;
	private double minimo;
	private double massimo;
	private String descrizione;
	
	public Filtro(String nome, String cognome, String codiceFiscale, String eMail, String telefono, String indirizzo,
			double minimo, double massimo, String descrizione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.eMail = eMail;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.minimo = minimo;
		this.massimo = massimo;
		this.descrizione = descrizione;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public double getMinimo() {
		return minimo;
	}
	public void setMinimo(double minimo) {
		this.minimo = minimo;
	}
	public double getMassimo() {
		return massimo;
	}
	public void setMassimo(double massimo) {
		this.massimo = massimo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
