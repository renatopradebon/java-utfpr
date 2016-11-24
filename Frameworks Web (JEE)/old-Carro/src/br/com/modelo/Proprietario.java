package br.com.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "proprietario")
@SequenceGenerator(name = "cod_proprietario", sequenceName = "proprietario_cod_proprietario_seq", allocationSize = 1)
public class Proprietario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue //(strategy = GenerationType.SEQUENCE, generator = "cod_proprietario")
	@Column(name = "cod_proprietario", nullable = false)
	private int codProprietario;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "proprietario")
	@Cascade(CascadeType.ALL)
	private List<Carro> carros;

	public Proprietario() {
	}

	public Proprietario(List<Carro> carros, String nome) {
		this.carros = carros;
		this.nome = nome;
	}

	public int getCodProprietario() {
		return this.codProprietario;
	}

	public void setCodProprietario(int codProprietario) {
		this.codProprietario = codProprietario;
	}

	public List<Carro> getCarros() {
		return this.carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Proprietario [codProprietario=" + codProprietario + ", nome=" + nome + "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
