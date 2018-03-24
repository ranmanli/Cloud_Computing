package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

import lab1.LoginImpl;

class LoginTest {

	@Test
	void test1() throws RemoteException {
		LoginImpl obj = new LoginImpl();
		String username = "ranmanli@outlook.com";
		String password = "123456";
		obj.userLogin(username, password);
	}

}
