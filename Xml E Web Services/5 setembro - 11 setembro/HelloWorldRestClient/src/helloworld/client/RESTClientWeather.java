package helloworld.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RESTClientWeather {
	private final static String authHost = "10.20.10.50";
	private final static String authPort = "3128";
	private final static String authUser = "renatopradebon";
	private final static String authPassword = "laikajeri01";
	private static Client cliente;

	public static void main(String[] args) {
		RESTClientWeather.iniciaProperties();

		cliente = Client.create();
		String url = "http://api.openweathermap.org/data/2.5/weather?q=Londrina&mode=xml";
		WebResource resource = cliente.resource(url);

		String retorno = resource.get(String.class);
		System.out.println("Resultado => " + retorno);

	}

	public static void iniciaProperties() {
		System.setProperty("http.proxyHost", authHost);
		System.setProperty("http.proxyPort", authPort);
		System.setProperty("http.proxyUser", authUser);
		System.setProperty("http.proxyPassword", authPassword);

		Authenticator.setDefault(new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(authUser, authPassword.toCharArray());
			}
		});
	}
}
