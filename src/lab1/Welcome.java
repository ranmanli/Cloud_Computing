package lab1;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Welcome extends Remote {
	public void showView() throws RemoteException;
}
