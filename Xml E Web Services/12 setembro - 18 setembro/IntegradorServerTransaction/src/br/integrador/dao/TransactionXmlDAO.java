package br.integrador.dao;

import java.io.File;
import java.io.FileReader;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.integrador.modelo.Transaction;

public class TransactionXmlDAO {
	private static final String XML_FILE = "./public/transactionstore.xml";
	private TransactionStore transactionStore;

	public TransactionXmlDAO() {

		try {
			JAXBContext context = JAXBContext.newInstance(TransactionStore.class);
			Unmarshaller um = context.createUnmarshaller();
			transactionStore = (TransactionStore) um.unmarshal(new FileReader(XML_FILE));

		} catch (Exception e) {
			// empty store
			transactionStore = new TransactionStore();
			transactionStore.setName("store");
			transactionStore.setTransactionList(new ArrayList<Transaction>());
		}
	}

	public List<Transaction> getAll() {
		return transactionStore.getTransactionList();
	}

	public List<Transaction> get(Long acNumber) {
		List<Transaction> allTransactions = getAll();
		List<Transaction> specificTransactions = new ArrayList<Transaction>();

		for (Transaction t : allTransactions) {
			if (t.getAccountNumber().equals(acNumber))
				specificTransactions.add(t);
		}

		return specificTransactions;
	}

	public void save(Transaction transaction) {
		Format formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String date = formatter.format(new Date(System.currentTimeMillis()));
		transaction.setDate(date);

		transactionStore.getTransactionList().add(transaction);

		saveXML();
	}

	private void saveXML() {
		try {
			JAXBContext context = JAXBContext.newInstance(TransactionStore.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(transactionStore, new File(XML_FILE));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
