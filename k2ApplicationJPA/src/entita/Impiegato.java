package entita;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 


@Entity(name="impiegato")
//@NamedQuery(name="trovaImpiegati", query="select i from impiegato i WHERE i.nome LIKE :nome")
//@Table(name="impiegato")
public class Impiegato implements Serializable{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private int id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "cognome", nullable = false)
	private String cognome;
	@Id
	@Column(name = "codicefiscale", nullable = false)
	private String codiceFiscale;
	@Column(name = "eMail", nullable = false)
	private String eMail;
	@Column(name = "telefono", nullable = true)
	private String telefono;
	@Column(name = "indirizzo", nullable = true)
	private String indirizzo;
	@Column(name = "salario", nullable = false)
	private double salario;
	@Column(name = "descrizione", nullable = true)
	private String descrizione;
	
	public Impiegato() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	

}
