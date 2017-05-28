package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HolidayPlanner.Employee;
import HolidayPlanner.HR;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddVacation_HR extends JFrame {

	private JPanel contentPane;
	private JTextField vacantionDay;
	public static Employee emp;
	private static HR hrEmployee;
	private JTextField txtEmailemployee;

	/**
	 * Launch the application.
	 */
	public static void start(HR hr) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hrEmployee = hr;
					AddVacation_HR frame = new AddVacation_HR();
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
	public AddVacation_HR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		vacantionDay = new JTextField();
		vacantionDay.setBounds(6, 106, 206, 35);
		contentPane.add(vacantionDay);
		vacantionDay.setColumns(10);
		
		JButton btnAddDay = new JButton("Add day");
		btnAddDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String day = vacantionDay.getText();
				String email = txtEmailemployee.getText();
				emp = Employee.getEmployee(email); 
				if(day.matches("([0-9]{2})//([0-9]{2})//([0-9]{4})"))
				emp.addVacantionDay(day);
			}
		});
		btnAddDay.setBounds(233, 160, 155, 37);
		contentPane.add(btnAddDay);
		
		JLabel lblDayOfVacantion = new JLabel("Day of vacantion");
		lblDayOfVacantion.setBounds(10, 53, 202, 29);
		contentPane.add(lblDayOfVacantion);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AllEmployees.start(hrEmployee);
			}
		});
		btnBack.setBounds(16, 165, 155, 37);
		contentPane.add(btnBack);
		
		txtEmailemployee = new JTextField();
		txtEmailemployee.setBounds(348, 101, 206, 35);
		contentPane.add(txtEmailemployee);
		txtEmailemployee.setColumns(10);
		
		JLabel lblEmailOfEmployee = new JLabel("Email of employee");
		lblEmailOfEmployee.setBounds(405, 53, 104, 29);
		contentPane.add(lblEmailOfEmployee);
	}
}
