package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HolidayPlanner.Employee;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Employee_view extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Employee employee;
	private JTextField startDate;
	private JTextField endDate;

	/**
	 * Launch the application.
	 */
	public static void start(Employee em) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee = em;
					Employee_view frame = new Employee_view();
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
	public Employee_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Holiday Planner");
		label.setBounds(151, 11, 144, 32);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Welcome, " + employee.getName() + "!");
		label_1.setBounds(139, 54, 181, 14);
		contentPane.add(label_1);
		
		JLabel lblStartDate = new JLabel("Start Date :");
		lblStartDate.setBounds(24, 86, 81, 14);
		contentPane.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End date :");
		lblEndDate.setBounds(24, 123, 81, 14);
		contentPane.add(lblEndDate);
		
		startDate = new JTextField();
		startDate.setBounds(115, 83, 109, 20);
		contentPane.add(startDate);
		startDate.setColumns(10);
		
		endDate = new JTextField();
		endDate.setBounds(115, 120, 109, 20);
		contentPane.add(endDate);
		endDate.setColumns(10);
		
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShowVacationDays.start(employee, startDate.getText(), endDate.getText());
				
			}
		});
		show.setBounds(139, 173, 89, 23);
		contentPane.add(show);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Welcome.start();
			}
		});
		logout.setBounds(10, 227, 89, 23);
		contentPane.add(logout);
	}

}
