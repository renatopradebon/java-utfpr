import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class VerificaCpfClient {

	public VerificaCpfClient() throws MalformedURLException, RemoteException, NotBoundException {

	}

	public static void main(String args[]) {

		String resposta;
		String cpf;
		BufferedReader br;
		boolean continua = true;

		try {
			while (continua) {
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Digite o CPF por favor: ");
				cpf = br.readLine();

				VerificaCpf valida = (VerificaCpf) Naming.lookup("rmi://localhost/VerificaCpfServer");

				String isValidoCpf = valida.ValidaCpf(cpf) ? "válido" : "inválido";

				System.out.println("O CPF é " + isValidoCpf + ".");

				System.out.println("Deseja verificar um novo CPF? Qualquer caractere - Sim / N - Não: ");
				resposta = br.readLine();

				if ("N".equals(resposta.toUpperCase())) {
					continua = false;
				}
			}

			System.out.println("E isso é tudo pessoal!");
		} catch (Exception erro) {
			System.err.println("Erro no cliente => " + erro.toString());
		}

	}

}
