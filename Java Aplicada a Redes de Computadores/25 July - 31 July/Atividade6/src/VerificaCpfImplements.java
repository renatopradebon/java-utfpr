import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VerificaCpfImplements extends UnicastRemoteObject implements VerificaCpf {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VerificaCpfImplements() throws RemoteException {
		super();
	}

	@Override
	public Boolean ValidaCpf(String cpf) throws RemoteException {

		ValidaCpf valida = new ValidaCpf();

		Boolean cpfValido = valida.validaCpf(cpf);

		// String isValidoCpf = cpfValido ? "CPF Válido" : "CPF Inválido";

		return cpfValido;
	}

}
