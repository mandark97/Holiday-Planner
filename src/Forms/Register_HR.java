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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register_HR extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Register_HR EmployeesList = null;
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_HR frame = new Register_HR();
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
	public Register_HR() {
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
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(57, 55, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(57, 80, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(57, 105, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(57, 130, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		firstName = new JTextField();
		firstName.setBounds(193, 54, 192, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(193, 77, 192, 20);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		email = new JTextField();
		email.setBounds(193, 102, 192, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(193, 127, 192, 20);
		contentPane.add(password);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String emLastName = lastName.getText();
				String emFirstName = firstName.getText();
				String emEmail = email.getText();
				String emPassword = new String(password.getPassword());
				
				
				HR hr = new HR(emLastName, emFirstName, emPassword, emEmail);
				boolean added = hr.register();
				
				if(added == false) {
					JOptionPane.showMessageDialog(contentPane,
							"The email address you have entered is already registered", 
							"Error",
					        JOptionPane.ERROR_MESSAGE);
				} else {
					//dispose();
					//EmployeesList.start();
					JOptionPane.showMessageDialog(contentPane,
							"You registered as HR successfully", 
							"Register",
					        JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		register.setBounds(162, 172, 89, 23);
		contentPane.add(register);
		
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
