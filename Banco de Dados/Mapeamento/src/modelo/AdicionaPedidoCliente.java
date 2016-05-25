package modelo;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaPedidoCliente {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		// cliente
		Cliente cliente = new Cliente();
		cliente.setNome("Renato Pradebon");

		// pedido
		Pedido pedido = new Pedido();
		pedido.setData(Calendar.getInstance());
		pedido.setCliente(cliente);

		manager.persist(cliente);
		manager.persist(pedido);

		manager.getTransaction().commit();
		manager.close();

		factory.close();
	}

}
