package hibernate.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

import hibernate.model.docAuto;

@Entity
@Table(name="auto")
public class Auto {
	@Id
	@Length(min = 7, max=7)
	private String targa;
	@Column(name="marca")
	private String marca;
	@Column(name="anno")
	private int year;
	@Column(name="chilometri")
	private int chilometri;
	@OneToMany(mappedBy="auto", fetch = FetchType.LAZY)
	private List<docAuto> documenti;
	
	public void setTarga(String targa){
		this.targa = targa;
	}
	
	public String getTarga(){
		return this.targa;
	}
	
	public void setMarca(String marca){
		this.marca = marca;
	}
	
	public String getMarca(){
		return this.marca;
	}
	
	public void setYear(int i){
		this.year = i;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public void setChilometri(int chilometri){
		this.chilometri = chilometri;
	}
	
	public int getChilometri(){
		return this.chilometri;
	}

	public List<docAuto> getDocumenti() {
		return documenti;
	}

	public void setDocumenti(List<docAuto> documenti) {
		this.documenti = documenti;
	}
	
/*	public void addDoc(docAuto documento){
		getDoc().add(documento);
	}
	
	public Set<docAuto> getDoc(){
		return this.getDoc();
	}
*/
}
