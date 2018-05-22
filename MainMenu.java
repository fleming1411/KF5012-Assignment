import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame {
	
	/*
	 * Declare variables
	 */
	
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem preferences, menuLogout, quit;
	
	private JButton jobs, staff, reports, logout;
	
	/*
	 * Constructor
	 */
	
	public MainMenu() {
		setLayout(new GridLayout(4, 1));
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		file = new JMenu("File");
		menuBar.add(file);
		
		preferences = new JMenuItem("Preferences");
		file.add(preferences);
		
		menuLogout = new JMenuItem("Logout");
		file.add(menuLogout);
		
		quit = new JMenuItem("Exit");
		file.add(quit);
		
		/*
		 * Action listeners on menu buttons
		 */
		
		MenuPrefClass mpc = new MenuPrefClass();
		preferences.addActionListener(mpc);
		
		LogoutButtonClass lbc = new LogoutButtonClass();
		menuLogout.addActionListener(lbc);
		
		MenuQuitClass mqc = new MenuQuitClass();
		quit.addActionListener(mqc);
		
		/*
		 * Add buttons to window
		 */
		
		jobs = new JButton("Jobs");
		add(jobs);
		
		staff = new JButton("Staff");
		add(staff);
		
		reports = new JButton("Reports");
		add(reports);
		
		logout = new JButton("Logout");
		add(logout);
		
		/*
		 * Add action listeners to buttons
		 */
		
		JobsButtonClass jbc = new JobsButtonClass();
		jobs.addActionListener(jbc);;
		
		StaffButtonClass sbc = new StaffButtonClass();
		staff.addActionListener(sbc);;
		
		ReportsButtonClass rbc = new ReportsButtonClass();
		reports.addActionListener(rbc);
		
		logout.addActionListener(lbc);
	}
	
	/*
	 * Classes for all menu buttons
	 */
	
	public class MenuPrefClass implements ActionListener {
		public void actionPerformed(ActionEvent mpc) {
			Preferences gui = new Preferences();
			gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			gui.setVisible(true);
			gui.setSize(300, 150);
			gui.setTitle("Preferences");
			gui.setLocationRelativeTo(null);
		}
	}
	
	public class LogoutButtonClass implements ActionListener {
		public void actionPerformed(ActionEvent lbc) {
			dispose();
			Toolkit.getDefaultToolkit().beep();
			Logout gui = new Logout(MainMenu.this);
			gui.setSize(300, 100);
			gui.setVisible(true);
			gui.setTitle("Logout");
			gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			gui.setLocationRelativeTo(null);
		}
	}
	
	public class MenuQuitClass implements ActionListener {
		public void actionPerformed(ActionEvent mpc) {
			System.exit(0);
		}
	}
	
	/*
	 * Classes for all main buttons
	 */
	
	public class JobsButtonClass implements ActionListener {
		public void actionPerformed(ActionEvent jbc) {
			Jobs gui = new Jobs();
			gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			gui.pack();
			gui.setLocationRelativeTo(null);
			gui.setTitle("Capytec Jobs");
			gui.setVisible(true);
		}
	}
	
	public class StaffButtonClass implements ActionListener {
		public void actionPerformed(ActionEvent sbc) {
			Staff gui = new Staff();
			gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			gui.pack();
			gui.setLocationRelativeTo(null);
			gui.setTitle("Capytec Staff");
			gui.setVisible(true);
		}
	}
	
	public class ReportsButtonClass implements ActionListener {
		public void actionPerformed(ActionEvent rbc) {
			Reports gui = new Reports();
			gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			gui.pack();
			gui.setLocationRelativeTo(null);
			gui.setTitle("Capytec Reports");
			gui.setVisible(true);
		}
	}
	
	/*
	 * Main Method to bypass login page on computers without db
	 */
	
	public static void main(String args[]) {
		MainMenu gui = new MainMenu();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setTitle("Capytec Main Menu");
		gui.setSize(300, 400);
		gui.setLocationRelativeTo(null);
	}
}
