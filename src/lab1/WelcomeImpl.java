package lab1;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class WelcomeImpl implements Welcome {

	private JFrame frmWelcome;
	public JFrame getFrmWelcome() {
		return frmWelcome;
	}


	public void setFrmWelcome(JFrame frmWelcome) {
		this.frmWelcome = frmWelcome;
	}

	private JTextField inputUsername;
	private JTextField inputPassword;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeImpl window = new WelcomeImpl();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public WelcomeImpl () throws RemoteException{
		initialize();
	}
	

	/**
	 * Create the application.
	 */
	public void showView() throws RemoteException {
		WelcomeImpl window = new WelcomeImpl();
		window.frmWelcome.setVisible(true);
		System.out.println("SDfsd");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome!");
		frmWelcome.setBounds(100, 100, 534, 387);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the happy-shopping!");
		lblWelcomeToThe.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		lblWelcomeToThe.setBounds(105, 44, 300, 33);
		frmWelcome.getContentPane().add(lblWelcomeToThe);
		
		inputUsername = new JTextField();
		inputUsername.setBounds(155, 116, 316, 33);
		frmWelcome.getContentPane().add(inputUsername);
		inputUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		lblUsername.setBounds(51, 118, 72, 24);
		frmWelcome.getContentPane().add(lblUsername);
		
		inputPassword = new JPasswordField();
		inputPassword.setColumns(10);
		inputPassword.setBounds(155, 199, 316, 33);
		frmWelcome.getContentPane().add(inputPassword);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		lblPassword.setBounds(51, 201, 72, 24);
		frmWelcome.getContentPane().add(lblPassword);
		
		JButton btnRegister = new JButton("Sign up");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					RegisterImpl regObj = new RegisterImpl();
					String username = inputUsername.getText();
					String password = inputPassword.getText();
					if (null != username && null != password && !username.isEmpty() && !password.isEmpty()) {
						Map mapR = regObj.registerNewUser(username, password);
						if ((boolean) mapR.get("result")) {
							NoticeWindow frame = new NoticeWindow("You have signed up successfully!");
						}
						else {
							NoticeWindow frame = new NoticeWindow(mapR.get("faultMessage")+" Please sign up again!");
						}
					}
					else {
						NoticeWindow frame = new NoticeWindow("The username and password can not be empty!");
					}
				}
				catch (Exception e2) {
					System.err.println("log in failed! due to: "+e2.getClass()+"  "+e2.getMessage());
				}
			}
		});
		btnRegister.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		btnRegister.setBounds(73, 300, 110, 23);
		frmWelcome.getContentPane().add(btnRegister);
		
		JLabel lblDontHaveAn = new JLabel("don't have an account?");
		lblDontHaveAn.setFont(new Font("Ó×Ô²", Font.PLAIN, 16));
		lblDontHaveAn.setBounds(39, 266, 198, 24);
		frmWelcome.getContentPane().add(lblDontHaveAn);
		
		JLabel Hellolabel = new JLabel("Hi! Please log in!");
		Hellolabel.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		Hellolabel.setBounds(10, 10, 151, 24);
		frmWelcome.getContentPane().add(Hellolabel);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					LoginImpl logObj = new LoginImpl();
					String username = inputUsername.getText();
					String password = inputPassword.getText();
					if (null != username && null != password && !username.isEmpty() && !password.isEmpty()) {
						Map mapL = logObj.userLogin(username, password);
						if ((boolean)mapL.get("result")) {
							NoticeWindow frame = new NoticeWindow("Log in successfully!");
							Hellolabel.setText("Hi! "+username);
						}
						else {
							NoticeWindow frame = new NoticeWindow("The username or password is not correct! Please try again!");
						}
					}
					else {
						NoticeWindow frame = new NoticeWindow("The username and password can not be empty!");
					}
				} 
				catch (Exception e2) {
					System.err.println("log in failed! due to: "+e2.getClass()+"  "+e2.getMessage());
				}
			}
		});
		btnLogIn.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		btnLogIn.setBounds(317, 300, 110, 23);
		frmWelcome.getContentPane().add(btnLogIn);
		
	}
}
