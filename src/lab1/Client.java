package lab1;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;
import java.util.Scanner;

public class Client {
	private static Welcome stubWelcome = null;
	private static Scanner input = new Scanner(System.in);
	private Client() {}
	
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry("localhost");
			stubWelcome = (Welcome) reg.lookup("Welcome");
			stubWelcome.showView();
		}
		catch (Exception e) {
			System.err.println("Client exception thrown: " + e.toString());
			e.printStackTrace();
		}
		
	}
	public static void welcomePage() {
		System.out.println("Do you have an account? y/n");
		String answer = input.nextLine();
		if(answer.toLowerCase().equals("y")) {
			System.out.println("Please input your username ");
			String username = input.nextLine();
			System.out.println("Please input your password ");
			String password = input.nextLine();
			
		}
		else if(answer.toLowerCase().equals("n")) {
			System.out.println("Please input an username for your account");
			String newUsername = input.nextLine();
			System.out.println("Please input an password ");
			String newPassword = input.nextLine();
			Map result = null;
			
			System.out.println(result);
		}
		else {
			welcomePage();
		}
	}
}
