import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * This class will show a list of all the completed jobs, and which member of staff
 * has completed the job. This page will allow most users to be able to see what jobs has been completed
 * and by who so it possible to see if errors were made. 
 * 
 * Extends JFrame so we are able to add swing components to the window
 * 
 * @author Jamie Lee Fleming 
 * @version 1.0.0
 */
public class Reports extends JFrame {
	
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem help, logout, quit;
    private JTable completedTable;
    
    public Reports() {
    	setLayout(new FlowLayout());
    	
    	menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        file = new JMenu("File");
        menuBar.add(file);
        
        help = new JMenuItem("Help");
        file.add(help);
        
        logout = new JMenuItem("Logout");
        file.add(logout);
        
        quit = new JMenuItem("Quit");
        file.add(quit);
    	
    	MenuHelpClass mhc = new MenuHelpClass();
    	help.addActionListener(mhc);
    	
    	MenuLogoutClass mlc = new MenuLogoutClass();
    	logout.addActionListener(mlc);
    	
    	MenuQuitClass mqc = new MenuQuitClass();
    	quit.addActionListener(mqc);
    	
    	Object[] columnNames = {"Complete", "Job", "Care1", "Care2", "Care3", "Care4", "Care5", "Care6"};
        
        Object[][] data = {
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
            {true, "jobDesc", false, false, false, false, false, false},
        };
        
        /*
         * Using the default model table we are able to use checkboxes within the table. 
         * 
         * Create a class to say what each column does. The completed and caretaker columns
         * will have boolean class meaning we can use checkboxes. The job column will be a String
         * class so we can type information in about the job.
         */
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        completedTable = new JTable(model) {
            public Class getColumnClass(int column) {
                switch(column) {
                    case 0:
                    return Boolean.class;
                    case 1:
                    return String.class;
                    case 2:
                    return Boolean.class;
                    case 3:
                    return Boolean.class;
                    case 4:
                    return Boolean.class;
                    case 5:
                    return Boolean.class;
                    case 6:
                    return Boolean.class;
                    default:
                    return Boolean.class;
                }
            }
        };
        
        /*
         * Size of the table is 850 by 250, and fills the height of the window.
         * 
         * A scroll pane is added so it is possible to scroll through the jobs which do not
         * fit on the screen. This scroll pane is then added to the table.
         */
        
        completedTable.setPreferredScrollableViewportSize(new Dimension(850, 250));
        completedTable.setFillsViewportHeight(true);               
        
        JScrollPane scrollPane = new JScrollPane(completedTable);
        add(scrollPane);
    }
    
    public class MenuHelpClass implements ActionListener {
    	public void actionPerformed(ActionEvent mhc) {
    		
    	}
    }
    
    public class MenuLogoutClass implements ActionListener {
    	public void actionPerformed(ActionEvent mlc) {
    		Toolkit.getDefaultToolkit().beep();
            Logout gui = new Logout(Reports.this);
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
}
