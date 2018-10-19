package hibernate.model;

import javax.persistence.*;
import hibernate.model.Auto;


@Entity
@Table(name="doc_auto")
public class docAuto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	@Column(name="documento")
	private String documento;
	@ManyToOne(cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
	@JoinColumn(name="targa")
	private Auto auto;
	
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

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	

	
}
