package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estado {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	@OneToOne
	private Governador governador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Governador getGovernador() {
		return governador;
	}

	public void setGovernador(Governador governador) {
		this.governador = governador;
	}
}
