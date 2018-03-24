package lab1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface Register extends Remote{
	public Map registerNewUser(String username, String password)
					throws RemoteException;
}
