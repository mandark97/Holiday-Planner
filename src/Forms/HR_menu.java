package Forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HolidayPlanner.HR;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HR_menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static HR hrEmployee;

	/**
	 * Launch the application.
	 */
	public static void start(HR hr) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hrEmployee = hr;
					HR_menu frame = new HR_menu();
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
	public HR_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Holiday Planner");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(151, 11, 144, 32);
		contentPane.add(label);
		
		JButton addNewEmployee = new JButton("Add new Employee");
		addNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addNewEmployee.setBounds(151, 91, 144, 23);
		contentPane.add(addNewEmployee);
		
		JButton viewAllEmployees = new JButton("View all Employees");
		viewAllEmployees.setBounds(150, 125, 145, 23);
		contentPane.add(viewAllEmployees);
		
		JButton logout = new JButton("Log out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Welcome.start();
			}
		});
		logout.setBounds(151, 195, 144, 23);
		contentPane.add(logout);
		
		JLabel HRName = new JLabel("Welcome, " + hrEmployee.getName() + "!");
		HRName.setBounds(132, 54, 181, 14);
		contentPane.add(HRName);
	}
}
