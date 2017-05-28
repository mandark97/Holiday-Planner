package Forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HolidayPlanner.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_employee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_employee frame = new Login_employee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Holiday Planner");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(151, 11, 144, 32);
		contentPane.add(label);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(118, 67, 46, 14);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setBounds(187, 66, 210, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(103, 111, 61, 17);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(187, 111, 210, 20);
		contentPane.add(password);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employeeEmail = email.getText();
				String employeePassword = new String(password.getPassword());
				
				Employee em = (Employee) Employee.login(employeeEmail, employeePassword);
				
				if(em == null) {
					JOptionPane.showMessageDialog(contentPane,
							"Your email or password is incorrect", 
							"Login Failed",
					        JOptionPane.ERROR_MESSAGE);
				} else {
					/*
					JOptionPane.showMessageDialog(contentPane,
							"You logged in successfully", 
							"Login successful",
					        JOptionPane.INFORMATION_MESSAGE);
					        */
					dispose();
					Employee_view.start(em);
				}
			}
		});
		login.setBounds(184, 165, 89, 23);
		contentPane.add(login);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Welcome.start();
			}
		});
		back.setBounds(10, 227, 89, 23);
		contentPane.add(back);
	}
}
