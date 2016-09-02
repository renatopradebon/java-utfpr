import java.rmi.Naming;

public class CalculadoraServer {

	public static void main(String args[]) {
		try {
			Calculadora calculadora = new CalculadoraImplements();

			Naming.rebind("rmi://localhost:1099/CalculadoraServer", calculadora);
		} catch (Exception e) {
			System.out.println("Erro RMI: " + e.toString());
		}
	}
}
