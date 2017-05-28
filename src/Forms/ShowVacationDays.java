package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import HolidayPlanner.Employee;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowVacationDays extends JFrame {

	private JPanel contentPane;
	private static Employee employee;
	private static String startDate;
	private static String endDate;

	/**
	 * Launch the application.
	 */
	public static void start(Employee em, String sd, String ed) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee = em;
					startDate = sd;
					endDate = ed;
					
					ShowVacationDays frame = new ShowVacationDays();
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
	public ShowVacationDays() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Holiday Planner");
		label.setBounds(134, 11, 135, 21);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(label);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Employee_view.start(employee);
			}
		});
		back.setBounds(26, 227, 89, 23);
		contentPane.add(back);
	
		/*
		 JScrollPane table = new JScrollPane(generateTable());
	        table.setBounds(10, 54, 645, 196);
	        contentPane.add(table);
	        */
	}
	
	private static JTable generateTable() {
		String[] columns = {"Date"};
		return new JTable();
		//String[][] data = employee.getVacationDays(startDate, endDate);
		//return new JTable(data, columns);
	}
	

}
