package hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="doc_compr")
public class docCompr {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	@Column(name="documento")
	private String documento;
	@ManyToOne(cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
	@JoinColumn(name="id_compr")
	private Compratore compratore;
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setDocumento(String documento){
		this.documento = documento;
	}
	
	public String getDocumento(){
		return this.documento;
	}

	public Compratore getCompratore() {
		return compratore;
	}

	public void setCompratore(Compratore compratore) {
		this.compratore = compratore;
	}
}
