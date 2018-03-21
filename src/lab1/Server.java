package lab1;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public Server() {}
	
	public static void main(String[] args) {
		try {
			RegisterImpl robj = new RegisterImpl();
			Register stubRegister = (Register) UnicastRemoteObject.exportObject(robj, 0);
			
			LoginImpl lobj = new LoginImpl();
			Login stubLogin = (Login)UnicastRemoteObject.exportObject(lobj, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("shopping", stubRegister);
			registry.bind("shopping", stubLogin);
			System.out.println("shopping server is ready to listen..");
			
			
		}
		catch(Exception e) {
			System.err.println("Server exception thrown: "+e.toString());
			e.printStackTrace();
		}
	}
}
