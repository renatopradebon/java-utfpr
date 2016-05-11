import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Excecao1 {

    public static void main(String arg[]) {
        BufferedReader memoria = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n Entrada de Dados");
        String s = "";
        System.out.println("\nEntre com um valor: ");

        try {
            s = memoria.readLine();
        } catch (IOException erro1) {
            System.out.println("\nErro de entrada de dados: " + erro1);
        } finally {
            System.out.println("\n Entrou no Finally");
        }
        System.out.println("\n O Valor de Entrada foi " + s);
    }
}