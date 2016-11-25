package br.com.modelo;

import java.io.Serializable;
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

import br.com.modelo.interfaces.BaseEntity;

@Entity
@Table(name = "proprietario")
@SequenceGenerator(name = "cod_proprietario", sequenceName = "proprietario_cod_proprietario_seq", allocationSize = 1)
public class Proprietario implements Serializable, BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue // (strategy = GenerationType.SEQUENCE, generator = "cod_proprietario")
	@Column(name = "cod_proprietario", nullable = false)
	private Integer codProprietario;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "proprietario")
	@Cascade(CascadeType.ALL)
	// @Cascade(CascadeType.MERGE)
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
		return "(" + codProprietario + ") " + nome + "]";
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (codProprietario != null ? codProprietario.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Proprietario)) {
			return false;
		}
		Proprietario other = (Proprietario) object;
		if ((this.codProprietario == null && other.codProprietario != null)
				|| (this.codProprietario != null && !this.codProprietario.equals(other.codProprietario))) {
			return false;
		}
		return true;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return getCodProprietario();
	}

}
