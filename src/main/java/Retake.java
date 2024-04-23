import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Retake extends JFrame implements ActionListener {
    JPanel retakePanel;
    JLabel retakeLabel;
    JPanel searchPanel;
    JTextField searchField;
    JButton searchButton;
    JButton backButton;
    ArrayList<TeacherData> teacherDataList;
    JTable dataTable;
    JScrollPane scrollPane;
    Retake(ArrayList<TeacherData> teacherDataList){
        //---------------------Data Table Setup---------------------
        this.teacherDataList = RetakeCSV.loadFromRetakeCSV();
        String[][] data = new String[teacherDataList.size()][8];
        for (int i = 0; i < teacherDataList.size(); i++){
                TeacherData teacherData = teacherDataList.get(i);
                data[i][0] = String.valueOf(teacherData.getId());
                data[i][1] = teacherData.getName();
                data[i][2] = teacherData.getLastName();
                data[i][3] = teacherData.getDiscepline();
                data[i][4] = teacherData.getDepartment();
                data[i][5] = teacherData.getDisceplineName();
                data[i][6] = teacherData.getDisceplineTime();
                data[i][7] = teacherData.getRating();
        }

        String[] columnsNames = {"ID", "Name", "Last Name", "Discepline", "Department", "Discepline Name", "Discepline Time", "Rating"};
        //--------------------/Data Table Setup---------------------

        //------------------------retakePanel settings--------------------
        retakePanel = new JPanel();
        retakePanel.setBounds(0, 0, 1000, 100);
        retakePanel.setBackground(new Color(255, 204, 204));
        retakePanel.setLayout(null);
        //------------------------/retakePanel settings--------------------

        //-----------------------retake Label-----------------------------
        retakeLabel = new JLabel("Retake");
        retakeLabel.setBounds(0, 25, 1000, 50);
        retakeLabel.setFont(new Font("Serif", Font.BOLD, 50));
        retakeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        retakePanel.add(retakeLabel);
        //-----------------------/retake Label-----------------------------

        //-----------------------searchPanel settings---------------------
        searchPanel = new JPanel();
        searchPanel.setBounds(0, 100, 1000, 30);
        searchPanel.setBackground(new Color(219, 169, 121));
        searchPanel.setLayout(null);
        //-----------------------/searchPanel settings---------------------

        //----------------------searchField settings---------------------
        searchField = new JTextField();
        searchField.setBounds(100, 3, 200, 25);
        searchField.setFont(new Font("Serif", Font.PLAIN, 30));
        searchPanel.add(searchField);
        //----------------------/searchField settings--------------------

        //----------------------searchButton settings-------------------
        searchButton = new JButton("Search");
        searchButton.setBounds(325, 3, 200, 25);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);
        searchPanel.add(searchButton);
        //----------------------/searchButton settings-------------------

        //----------------------backButton settings---------------------
        backButton = new JButton("Back");
        backButton.setBounds(850, 3, 100, 25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        searchPanel.add(backButton);
        //----------------------/backButton settings---------------------

        //---------------------dataTable settings---------------------
        DefaultTableModel model = new DefaultTableModel(data, columnsNames);
        dataTable = new JTable(model);
        scrollPane = new JScrollPane(dataTable);
        updateTableModel();
        scrollPane.setBounds(0, 130, 1000, 620);
        this.add(scrollPane);
        //--------------------/dataTable settings---------------------

        //-----------------------Frame settings---------------------------
        this.setTitle("Retake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(229, 255, 204));

        this.add(retakePanel);
        this.add(searchPanel);

        this.setResizable(false);
        this.setVisible(true);
        //-----------------------/Frame settings--------------------------
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            this.dispose();
            new Frame();
        }
    }
    public void updateTableModel() {
        DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
        model.setRowCount(0); // Clear the existing data
        for (TeacherData teacherData : teacherDataList) {
            model.addRow(new Object[]{teacherData.getId(), teacherData.getName(), teacherData.getLastName(), teacherData.getDiscepline(), teacherData.getDepartment(), teacherData.getDisceplineName(), teacherData.getDisceplineTime(), teacherData.getRating()});
        }
    }
}
