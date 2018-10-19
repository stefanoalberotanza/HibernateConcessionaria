package hibernate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Compratori")
public class Compratore {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compr")
	private int id;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="data_nascita")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	@OneToMany(mappedBy="compratore", fetch = FetchType.LAZY)
	private List<docCompr> documenti;
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<docCompr> getDocumenti() {
		return documenti;
	}
	public void setDocumenti(List<docCompr> documenti) {
		this.documenti = documenti;
	}
}
