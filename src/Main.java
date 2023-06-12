import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;

public class Main  extends JFrame {

    private JTextField myTextfield;
    private JTable myTable;
    private JButton pauseButton, cancelButton, resumeButton, clearButton;

    private DownloadsTableModel myTableModel;
    private Download selectDownload;
    private boolean clearing;

    public Main(){
        setTitle("Download Manager");
        setSize(500, 300);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                actionExit();
            }
        });

        //setting up the menu bar
        JMenuBar myMenubar= new JMenuBar();
        JMenu fileMenu=new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem myMenuItem= new JMenuItem("Exit", KeyEvent.VK_X);

        myMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionExit();
            }
        });

        fileMenu.add(myMenuItem);
        myMenubar.add(fileMenu);
        setJMenuBar(myMenubar);

        //setting up the Jpanel and adding the url address

        JPanel mypanel= new JPanel();
        myTextfield=new JTextField(30);
        mypanel.add(myTextfield);
        //add download button to panel
        JButton addButton = new JButton("Add Download");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionAdd();
            }
        });

        mypanel.add(addButton);

        //setting up the download table
        myTableModel=new DownLoadsTableModel();
        myTable=new JTable(myTableModel);
        myTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tableSlectionChanged();
            }
        });

        //Allowing one row to be selected at time in the table
        myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // seeting up progressBar as render for progress column

        JProgressBar jpb=new JProgressBar(0,100);
        jpb.setStringPainted(true); // showing progress text
        myTable.setDefaultRenderer(JProgressBar.class, (TableCellRenderer) jpb);

        //seeting table row and hight large enough to fit JProssbar
        myTable.setRowHeight((int) jpb.getPreferredSize().getHeight());
        //setting up download panel
        JPanel downloadsPanel=new JPanel();
        downloadsPanel.setBorder(BorderFactory.createTitledBorder("Downloads"));
        downloadsPanel.setLayout(new BorderLayout());
        downloadsPanel.add(new JScrollPane(myTable), BorderLayout.CENTER);

        //setting up button panel
        JPanel buttonPanel=new JPanel();
        pauseButton=new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionPause();
            }
        });


    }
    public static void main(String[] args) {

    }
}