package lab1;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends WelcomeImpl{
	
	public Server() throws RemoteException{}
	
	public static void main(String[] args) {
		try {
			
//			RegisterImpl robj = new RegisterImpl();
//			Register stubRegister = (Register) UnicastRemoteObject.exportObject(robj, 0);
//			
//			LoginImpl lobj = new LoginImpl();
//			Login stubLogin = (Login)UnicastRemoteObject.exportObject(lobj, 0);
//
//			registry.bind("Register", stubRegister);
//			registry.bind("Login", stubLogin);
//			
			
			WelcomeImpl wobj = new WelcomeImpl();
			Welcome stubWelcome = (Welcome)UnicastRemoteObject.exportObject(wobj, 0);
			
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("Welcome", stubWelcome);
			
			System.out.println("shopping server is ready to listen..");
			
		}
		catch(Exception e) {
			System.err.println("Server exception thrown: "+e.toString());
			e.printStackTrace();
		}
	}
}
