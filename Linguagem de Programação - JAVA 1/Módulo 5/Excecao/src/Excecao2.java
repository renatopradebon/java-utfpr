
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Excecao2 {

    public static void main(String arg[]) {
        BufferedReader memoria = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n Entrada de Dados");
        String s = "";
        System.out.println("\nEntre com um valor: ");

        try {
            s = memoria.readLine();
            int numero = Integer.parseInt(s);
            System.out.println("\n O quadrado do valor de entrada eh: " + numero * numero);
        } catch (IOException erro1) {
            System.out.println("\nErro de entrada de dados: " + erro1);
        } catch (NumberFormatException erro2) {
            System.err.println("\n Deve entrar com um número: erro2--> " + erro2);
        } finally {
            System.out.println("\n Entrou no Finally");
        }
        System.out.println("\n O valor de entrada foi " + s);
    }
}
