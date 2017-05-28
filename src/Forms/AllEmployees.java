package Forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import HolidayPlanner.Employee;
import HolidayPlanner.HR;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllEmployees extends JFrame {

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
					AllEmployees frame = new AllEmployees();
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
	public AllEmployees() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Holiday Planner");
		label.setBounds(263, 11, 144, 32);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(label);
		

        JScrollPane table = new JScrollPane(generateTable());
        table.setBounds(10, 54, 645, 196);
        contentPane.add(table);
        
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		HR_menu.start(hrEmployee);
        	}
        });
        back.setBounds(10, 269, 89, 23);
        contentPane.add(back);
		      
	}
	
	private static JTable generateTable() {
		String[] columns = {"First Name", "Last Name", "Password", "Email", "Vacation Days"};
		String[][] data = Employee.getAllEmployees();
		return new JTable(data, columns);
	}
}
