import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class CalculadoraClient {

	public static void main(String args[]) {
		String resposta;
		String opcao;
		long resultado = 0;
		long valor1;
		long valor2;
		BufferedReader br;
		boolean continua = true;

		try {
			while (continua) {
				resultado = 0;

				br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("Digite a operação desejada: ");
				System.out.println("(a) Soma");
				System.out.println("(b) Subtração");
				System.out.println("(c) Multiplicação");
				System.out.println("(d) Divisão");
				opcao = br.readLine();

				System.out.println("Digite o valor 1 por favor: ");
				valor1 = Long.parseLong(br.readLine());

				System.out.println("Digite o valor 2 por favor: ");
				valor2 = Long.parseLong(br.readLine());

				Calculadora calculadora = (Calculadora) Naming.lookup("rmi://localhost/CalculadoraServer");

				switch (opcao.toLowerCase()) {
				case "a":
					resultado = calculadora.add(valor1, valor2);
					break;
				case "b":
					resultado = calculadora.sub(valor1, valor2);
					break;
				case "c":
					resultado = calculadora.mul(valor1, valor2);
					break;
				case "d":
					resultado = calculadora.div(valor1, valor2);
					break;
				default:
					resultado = 0;
					break;
				}

				System.out.println("O resultado é " + String.valueOf(resultado) + ".");

				System.out.println("Deseja realizar uma nova operação? Qualquer caractere - Sim / N - Não: ");
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
