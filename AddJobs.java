import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddJobs extends JFrame {
	
	/*
	 * Declare variables
	 */
	
	private JLabel job;
	private JTextField jobDesc;
	private JButton add;
	
	private String driver = "jdbc:sqlite:";
	private String db = "C:\\Users\\flemi\\Documents\\folder\\capytec.db";
	private String url = driver + db;
	protected Connection conn = null;
	
	/*
	 * Constructor
	 */
	
	public AddJobs() {
		setLayout(new FlowLayout());
		
		job = new JLabel("Enter job to add");
		add(job);
		
		jobDesc = new JTextField(10);
		add(jobDesc);
		
		add = new JButton("Add");
		add(add);
		
		/*
		 * Action listener on add button
		 */
		
		AddButtonClass abc = new AddButtonClass();
		add.addActionListener(abc);
	}
	
	public class AddButtonClass implements ActionListener {
		public void actionPerformed(ActionEvent abc) {
			String newJob = jobDesc.getText();
			String sql = "INSERT INTO jobs VALUES ('false', '" + newJob + "', 'false', 'false', 'false', 'false', 'false', 'false')";
			try {
				conn = DriverManager.getConnection(url);
				Statement st = conn.createStatement();
				st.executeUpdate(sql);
				conn.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			
			dispose();
			Jobs gui = new Jobs();
			gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			gui.pack();
			gui.setLocationRelativeTo(null);
			gui.setTitle("Capytec Jobs");
			gui.setVisible(true);
		}
	}
}
