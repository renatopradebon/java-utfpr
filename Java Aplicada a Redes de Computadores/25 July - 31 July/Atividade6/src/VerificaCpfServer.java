import java.rmi.Naming;

public class VerificaCpfServer {

	public VerificaCpfServer() {
	}

	public static void main(String args[]) {
		try {
			VerificaCpf verificaCpf = new VerificaCpfImplements();

			// String cpf = "021.303.231-70";
			//
			// Boolean valido = cpfVerificado.ValidaCpf(cpf);

			Naming.rebind("rmi://localhost:1099/VerificaCpfServer", verificaCpf);
		} catch (Exception e) {
			System.out.println("Erro RMI: " + e.toString());
		}
	}

}
