package gestione;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entita.Impiegato;

public class GestioneJPAImpiegato {
	
	@PersistenceContext
    public EntityManager em;
	
	
	public void inserimento(Impiegato impiegato) throws IOException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("k2JPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(impiegato);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public ArrayList<Impiegato> lettura() throws IOException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("k2JPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Impiegato> query = em.createQuery("select i from impiegato i", Impiegato.class);
		List<Impiegato> resultSet = query.getResultList();
		em.close();
		ArrayList <Impiegato> ritorno = new ArrayList<Impiegato>();
		// aggiuge nella collection tutti gli impiegati che ha letto
		for (Impiegato impiegato : resultSet) {
			ritorno.add(impiegato);
		}
		return ritorno;
	}
	
	public void modifica(Impiegato impiegato) throws IOException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("k2JPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		System.out.println(impiegato.getCodiceFiscale());
		Impiegato impiegatoDB = em.find(Impiegato.class, impiegato.getCodiceFiscale());
		impiegatoDB.setId(impiegato.getId());
		impiegatoDB.setNome(impiegato.getNome());
		impiegatoDB.setCognome(impiegato.getCognome());
		impiegatoDB.seteMail(impiegato.geteMail());
		impiegatoDB.setTelefono(impiegato.getTelefono());
		impiegatoDB.setIndirizzo(impiegato.getIndirizzo());
		impiegatoDB.setSalario(impiegato.getSalario());
		impiegatoDB.setDescrizione(impiegato.getDescrizione());
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public Impiegato cancellazione(String codiceFiscale) throws IOException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("k2JPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Impiegato impiegatoDB = em.find(Impiegato.class, codiceFiscale);
		// Verifica di aver trovato il record
		if(impiegatoDB != null){
			em.remove(impiegatoDB);
			em.getTransaction().commit();
		}
		em.close();
		emf.close();
		return impiegatoDB;
	}
	
	public ArrayList<Impiegato> filtro(String nome, String cognome, String eMail, String indirizzo, String telefono, 
									   String codiceFiscale, double minimo, double massimo, String descrizione) throws IOException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("k2JPA");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT i from impiegato i WHERE i.nome like :nome and i.cognome like :cognome and i.eMail like :eMail and i.indirizzo like :indirizzo and i.telefono like :telefono and i.codiceFiscale like :codiceFiscale and i.salario >= :minimo and i.salario <= :massimo and i.descrizione like :descrizione ");
		q.setParameter("nome", "%" + nome + "%");
		q.setParameter("cognome", "%" + cognome + "%" );
		q.setParameter("eMail", "%" + eMail + "%" );
		q.setParameter("indirizzo", "%" + indirizzo + "%" );
		q.setParameter("telefono", "%" + telefono + "%" );
		q.setParameter("codiceFiscale", "%" + codiceFiscale + "%" );
		q.setParameter("minimo", minimo );
		q.setParameter("massimo", massimo );
		q.setParameter("descrizione", "%" + descrizione + "%" );
		System.out.println("********* Valore di minimo: " + minimo);
		List<Impiegato> list = q.getResultList();
		em.close();
		ArrayList <Impiegato> ritorno = new ArrayList<Impiegato>();
		// aggiunge nella collection tutti gli impiegati che ha letto
		for (Impiegato impiegato : list) {
			ritorno.add(impiegato);
		}
		return ritorno;
	}

}
