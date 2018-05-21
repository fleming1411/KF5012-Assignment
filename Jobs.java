import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

public class Jobs extends JFrame {
	
	/*
	 * Declare variables
	 */
	
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem add, logout, quit;
	
	private JTable jobsTable = new JTable();
	private JScrollPane scrollPane = new JScrollPane();
	
	private String driver = "jdbc:sqlite:";
	private String db = "C:\\Users\\flemi\\Documents\\folder\\capytec.db";
	private String url = driver + db;
	protected Connection conn = null;
	
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	/*
	 * Constructor
	 */
	
	public Jobs() {
		setLayout(new FlowLayout());
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		file = new JMenu("File");
		menuBar.add(file);
		
		add = new JMenuItem("Add");
		file.add(add);
		
		logout = new JMenuItem("Logout");
		file.add(logout);
		
		quit = new JMenuItem("Exit");
		file.add(quit);
		
		/*
		 * Action Listeners for menu buttons
		 */
		
		MenuAddClass mac = new MenuAddClass();
		add.addActionListener(mac);
		
		MenuLogoutClass mlc = new MenuLogoutClass();
		logout.addActionListener(mlc);
		
		MenuQuitClass mqc = new MenuQuitClass();
		quit.addActionListener(mqc);
		
		initComponents();
		show_jobs();
	}
	
	private void initComponents() {
		/*
		 * Table for jobs		
		 */
		
		jobsTable.setModel(new DefaultTableModel(
				new Object [][] {
					
		},
				new String [] {
						"Complete", "Job", "Caretaker 1", "Caretaker 2",
						"Caretaker 3", "Caretaker 4", "Caretaker 5", 
						"Caretaker 6"}
		));
		
		scrollPane.setViewportView(jobsTable);
		
		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
        );

        pack();
	}
	
	public ArrayList<JobsArray> jobsList(){
		ArrayList<JobsArray> jobsList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url);
			String query1 = "SELECT * FROM jobs";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query1);
			JobsArray jobs1;
			while(rs.next()) {
				jobs1 = new JobsArray(rs.getBoolean("Complete"), rs.getString("JobDesc"),
						rs.getBoolean("Caretaker1"), rs.getBoolean("Caretaker2"), rs.getBoolean("Caretaker3"),
						rs.getBoolean("Caretaker4"), rs.getBoolean("Caretaker5"), rs.getBoolean("Caretaker6"));
				jobsList.add(jobs1);
			}
			st.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  e);
		}
		return jobsList;
	}
	
	
	
	public void show_jobs() {
		ArrayList<JobsArray> list = jobsList();
		DefaultTableModel model = (DefaultTableModel)jobsTable.getModel();
		Object[] row = new Object[8];
		for(int i=0; i<list.size(); i++) {
			row[0]=list.get(i).getComplete();
			row[1]=list.get(i).getJobDesc();
			row[2]=list.get(i).getCare1();
			row[3]=list.get(i).getCare2();
			row[4]=list.get(i).getCare3();
			row[5]=list.get(i).getCare4();
			row[6]=list.get(i).getCare5();
			row[7]=list.get(i).getCare6();
			model.addRow(row);;
		}
	}
	
	public class MenuAddClass implements ActionListener {
        public void actionPerformed(ActionEvent mac) {
        	dispose();
        	AddJobs gui = new AddJobs();
            gui.setSize(300, 100);
            gui.setVisible(true);
            gui.setTitle("Add Jobs");
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setLocationRelativeTo(null);
        }
    }
	
	public class MenuLogoutClass implements ActionListener {
        public void actionPerformed(ActionEvent mlc) {
        	dispose();
        	Toolkit.getDefaultToolkit().beep();
            Logout gui = new Logout(Jobs.this);
            gui.setSize(300, 100);
            gui.setVisible(true);
            gui.setTitle("Logout");
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setLocationRelativeTo(null);
        }
    }
	
	public class MenuQuitClass implements ActionListener {
        public void actionPerformed(ActionEvent mqc) {
            System.exit(0);
        }
    }
	
	public static void main(String args[]) {
		Jobs gui = new Jobs();
		gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gui.setVisible(true);
		gui.pack();
		gui.setLocationRelativeTo(null);
	}
}
