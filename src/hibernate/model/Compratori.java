package hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

public class Compratori {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="data")
	private int data;
	@OneToMany(mappedBy="compr", fetch = FetchType.LAZY)
	private List<docAuto> documenti;
	
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
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public List<docAuto> getDocumenti() {
		return documenti;
	}
	public void setDocumenti(List<docAuto> documenti) {
		this.documenti = documenti;
	}
}
