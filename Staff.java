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

public class Staff extends JFrame {
	
	/*
	 * Declare variables
	 */
	
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem add, logout, quit;
	
	private JTable staffTable = new JTable();
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
	
	public Staff() {
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
		show_staff();
	}
	
	private void initComponents() {
		/*
		 * Table for jobs		
		 */
		
		staffTable.setModel(new DefaultTableModel(
				new Object [][] {
					
		},
				new String [] {
						"ID", "Position", "Surname", "Forename", "DoB",
						"Address", "Strength", "Weakness", "Notes"}
		));
		
		scrollPane.setViewportView(staffTable);
		
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
	
	public ArrayList<StaffArray> staffList(){
		ArrayList<StaffArray> staffList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url);
			String query1 = "SELECT * FROM staff";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query1);
			StaffArray staff1;
			while(rs.next()) {
				staff1 = new StaffArray(rs.getInt("ID"), rs.getString("Position"), rs.getString("Surname"), rs.getString("Forname"), 
						rs.getString("DoB"), rs.getString("Address"), rs.getString("Strength"),
						rs.getString("Weakness"), rs.getString("Notes"));
				staffList.add(staff1);
			}
			st.close();
			rs.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  e);
		}
		return staffList;
	}
	
	
	
	public void show_staff() {
		ArrayList<StaffArray> list = staffList();
		DefaultTableModel model = (DefaultTableModel)staffTable.getModel();
		Object[] row = new Object[10];
		for(int i=0; i<list.size(); i++) {
			row[0]=list.get(i).getID();
			row[1]=list.get(i).getPosition();
			row[2]=list.get(i).getSurname();
			row[3]=list.get(i).getForename();
			row[4]=list.get(i).getDob();
			row[5]=list.get(i).getAddress();
			row[6]=list.get(i).getStrength();
			row[7]=list.get(i).getWeakness();
			row[8]=list.get(i).getNotes();
			model.addRow(row);;
		}
	}
	
	public class MenuAddClass implements ActionListener {
        public void actionPerformed(ActionEvent mac) {
        	dispose();
        	AddStaff gui = new AddStaff();
            gui.setSize(750, 750);
            gui.setVisible(true);
            gui.setTitle("Add Staff");
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setLocationRelativeTo(null);
        }
    }
	
	public class MenuLogoutClass implements ActionListener {
        public void actionPerformed(ActionEvent mlc) {
        	dispose();
        	Toolkit.getDefaultToolkit().beep();
            Logout gui = new Logout(Staff.this);
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
		Staff gui = new Staff();
		gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gui.setVisible(true);
		gui.pack();
		gui.setLocationRelativeTo(null);
	}
}
