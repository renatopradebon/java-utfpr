package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaUsuario {

	public static void main(String[] args) throws IOException {
		String caminho = new File("public/gremio.png").getCanonicalPath();
		System.out.println(caminho);
		
		File foto = new File(caminho);
		byte[] byteFoto = new byte[(int) foto.length()];

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		Usuario usuario = new Usuario();

		usuario.setEmail("contato3@utfpr.edu.br");
		usuario.setDataDeCadastro(Calendar.getInstance());

		try {
			FileInputStream fileInputStreamFoto = new FileInputStream(foto);
			fileInputStreamFoto.read(byteFoto);
			fileInputStreamFoto.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		usuario.setFoto(byteFoto);

		manager.persist(usuario);
		manager.getTransaction().commit();

		manager.close();

		factory.close();
	}

}
