package Forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HolidayPlanner.HR;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login_HR extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private final JLabel label = new JLabel("Holiday Planner");
	private JTextField email;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_HR frame = new Login_HR();
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
	public Login_HR() {
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("Holiday Planner");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(151, 11, 144, 32);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(118, 67, 46, 14);
		contentPane.add(label_2);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(187, 66, 210, 20);
		contentPane.add(email);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(103, 111, 61, 17);
		contentPane.add(lblPassword);

		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employeeEmail = email.getText();
				String employeePassword = new String(password.getPassword());
				
				HR em = (HR) HR.login(employeeEmail, employeePassword);
				
				if(em == null) {
					JOptionPane.showMessageDialog(contentPane,
							"Your email or password is incorrect", 
							"Login Failed",
					        JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"You logged in successfully", 
							"Login successful",
					        JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		login.setBounds(184, 165, 89, 23);
		contentPane.add(login);
		
		password = new JPasswordField();
		password.setBounds(187, 111, 210, 20);
		contentPane.add(password);
		
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
