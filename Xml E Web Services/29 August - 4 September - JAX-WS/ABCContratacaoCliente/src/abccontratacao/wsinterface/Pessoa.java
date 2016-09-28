/**
 * Pessoa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package abccontratacao.wsinterface;

public class Pessoa implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String cpf;

	private int idade;

	private java.lang.String nome;

	private java.lang.String resposta;

	private java.lang.String setor;

	private int sexo;

	public Pessoa() {
	}

	public Pessoa(java.lang.String cpf, int idade, java.lang.String nome, java.lang.String resposta,
			java.lang.String setor, int sexo) {
		this.cpf = cpf;
		this.idade = idade;
		this.nome = nome;
		this.resposta = resposta;
		this.setor = setor;
		this.sexo = sexo;
	}

	/**
	 * Gets the cpf value for this Pessoa.
	 * 
	 * @return cpf
	 */
	public java.lang.String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf value for this Pessoa.
	 * 
	 * @param cpf
	 */
	public void setCpf(java.lang.String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the idade value for this Pessoa.
	 * 
	 * @return idade
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * Sets the idade value for this Pessoa.
	 * 
	 * @param idade
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}

	/**
	 * Gets the nome value for this Pessoa.
	 * 
	 * @return nome
	 */
	public java.lang.String getNome() {
		return nome;
	}

	/**
	 * Sets the nome value for this Pessoa.
	 * 
	 * @param nome
	 */
	public void setNome(java.lang.String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the resposta value for this Pessoa.
	 * 
	 * @return resposta
	 */
	public java.lang.String getResposta() {
		return resposta;
	}

	/**
	 * Sets the resposta value for this Pessoa.
	 * 
	 * @param resposta
	 */
	public void setResposta(java.lang.String resposta) {
		this.resposta = resposta;
	}

	/**
	 * Gets the setor value for this Pessoa.
	 * 
	 * @return setor
	 */
	public java.lang.String getSetor() {
		return setor;
	}

	/**
	 * Sets the setor value for this Pessoa.
	 * 
	 * @param setor
	 */
	public void setSetor(java.lang.String setor) {
		this.setor = setor;
	}

	/**
	 * Gets the sexo value for this Pessoa.
	 * 
	 * @return sexo
	 */
	public int getSexo() {
		return sexo;
	}
	
	public String getSexoExtenso() {
		return getSexo() == 1 ? "Masculino" : "Feminino";
	}

	/**
	 * Sets the sexo value for this Pessoa.
	 * 
	 * @param sexo
	 */
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof Pessoa))
			return false;
		Pessoa other = (Pessoa) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& ((this.cpf == null && other.getCpf() == null)
						|| (this.cpf != null && this.cpf.equals(other.getCpf())))
				&& this.idade == other.getIdade()
				&& ((this.nome == null && other.getNome() == null)
						|| (this.nome != null && this.nome.equals(other.getNome())))
				&& ((this.resposta == null && other.getResposta() == null)
						|| (this.resposta != null && this.resposta.equals(other.getResposta())))
				&& ((this.setor == null && other.getSetor() == null)
						|| (this.setor != null && this.setor.equals(other.getSetor())))
				&& this.sexo == other.getSexo();
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if (getCpf() != null) {
			_hashCode += getCpf().hashCode();
		}
		_hashCode += getIdade();
		if (getNome() != null) {
			_hashCode += getNome().hashCode();
		}
		if (getResposta() != null) {
			_hashCode += getResposta().hashCode();
		}
		if (getSetor() != null) {
			_hashCode += getSetor().hashCode();
		}
		_hashCode += getSexo();
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			Pessoa.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName("http://wsinterface.abccontratacao/", "pessoa"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cpf");
		elemField.setXmlName(new javax.xml.namespace.QName("", "cpf"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("idade");
		elemField.setXmlName(new javax.xml.namespace.QName("", "idade"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("nome");
		elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("resposta");
		elemField.setXmlName(new javax.xml.namespace.QName("", "resposta"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("setor");
		elemField.setXmlName(new javax.xml.namespace.QName("", "setor"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("sexo");
		elemField.setXmlName(new javax.xml.namespace.QName("", "sexo"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
	}

}
