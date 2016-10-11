package br.integrador.modelo;

import javax.xml.bind.annotation.XmlRootElement;

import br.integrador.modelo.enums.TransactionType;

@XmlRootElement
public class Transaction {

	public static final String CREATE = "CREATE";
	public static final String WITHDRAW = "WITHDRAW";
	public static final String DEPOSIT = "DEPOSIT";
	public static final String CLOSE = "CLOSE";

	private Long accountNumber;
	private String type;
	private String description;
	private String date;
	private TransactionType transactionType;

	public Transaction() {
		this.accountNumber = 0l;
		this.type = "";
		this.description = "";
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return " Account: " + getAccountNumber().toString() + " " + " Date: " + getDate() + " " + "Operation: "
				+ getType() + " " + "Description: " + getDescription();
	}

}
