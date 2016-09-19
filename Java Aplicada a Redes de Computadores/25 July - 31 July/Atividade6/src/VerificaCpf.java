import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VerificaCpf extends Remote {
	public Boolean ValidaCpf(String cpf) throws RemoteException;
}
