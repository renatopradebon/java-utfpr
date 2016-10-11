package br.integrador.dao;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import br.integrador.modelo.Transaction;

@XmlRootElement
public class TransactionStore {

	private String name;
	private ArrayList<Transaction> transactionList;

	public String getName() {
		return name;
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTransactionList(ArrayList<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
}
