package lab1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface Login extends Remote{
	public Map userLogin(String username, String password)throws RemoteException;
}
