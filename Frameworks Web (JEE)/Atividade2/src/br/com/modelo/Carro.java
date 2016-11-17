package br.com.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
@SequenceGenerator(name = "cod_carro", sequenceName = "carro_cod_carro_seq", allocationSize = 1)
@NamedQuery(name = "Carro.findByCod", 
query = "select carro from Carro carro where carro.cod_carro = :cod_carro")
public class Carro implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue //(strategy = GenerationType.SEQUENCE, generator = "cod_carro")
	@Column(name = "cod_carro", nullable = false)
	private int codCarro;

	@Column(name = "placa")
	private String placa;

	@ManyToOne
	@JoinColumn(name = "cod_proprietario")
	private Proprietario proprietario;

	public Carro() {
	}

	public Carro(String placa, Proprietario proprietario) {
		this.placa = placa;
		this.proprietario = proprietario;
	}

	public int getCodCarro() {
		return this.codCarro;
	}

	public void setCodCarro(int codCarro) {
		this.codCarro = codCarro;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Proprietario getProprietario() {
		return this.proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "Carro [codCarro=" + codCarro + ", placa=" + placa + ", proprietario=" + proprietario.toString() + "]";
	}

}
