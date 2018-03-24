package lab1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome {

	private JFrame frmWelcome;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
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
		lblWelcomeToThe.setBounds(110, 10, 300, 33);
		frmWelcome.getContentPane().add(lblWelcomeToThe);
		
		textField = new JTextField();
		textField.setBounds(153, 82, 316, 33);
		frmWelcome.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		lblUsername.setBounds(49, 84, 72, 24);
		frmWelcome.getContentPane().add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(153, 165, 316, 33);
		frmWelcome.getContentPane().add(textField_1);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		lblPassword.setBounds(49, 167, 72, 24);
		frmWelcome.getContentPane().add(lblPassword);
		
		JButton btnRegister = new JButton("Sign up");
		btnRegister.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		btnRegister.setBounds(71, 266, 110, 23);
		frmWelcome.getContentPane().add(btnRegister);
		
		JLabel lblDontHaveAn = new JLabel("don't have an account?");
		lblDontHaveAn.setFont(new Font("Ó×Ô²", Font.PLAIN, 16));
		lblDontHaveAn.setBounds(37, 232, 198, 24);
		frmWelcome.getContentPane().add(lblDontHaveAn);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		btnLogIn.setBounds(315, 266, 110, 23);
		frmWelcome.getContentPane().add(btnLogIn);
	}
}
