import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImplements extends UnicastRemoteObject implements Calculadora {

	protected CalculadoraImplements() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public long add(long a, long b) throws RemoteException {

		return a + b;
	}

	@Override
	public long sub(long a, long b) throws RemoteException {

		return a - b;
	}

	@Override
	public long mul(long a, long b) throws RemoteException {

		return a * b;
	}

	@Override
	public long div(long a, long b) throws RemoteException {

		return a / b;
	}

}
