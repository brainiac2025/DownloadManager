import javax.swing.*;

public class Main  extends JFrame {

    private JTextField myTextfield;
    private JTable myTable;
    private JButton pauseButton, cancelButton, resumeButton, clearButton;

    private DownloadsTableModel myTableModel;
    private Download selectDownload;
    private boolean clearing;

    public Main(){
        setTitle("Download Manager");
    }
    public static void main(String[] args) {

    }
}