package lab1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Register extends Remote{
	public String registerNewUser(String username, String password)
					throws RemoteException;
}
