import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;


public class DataBase extends JFrame implements ActionListener {
    JPanel dataBasePanel;
    JPanel searchPanel;
    JLabel dataBaseLabel;
    JTextField searchField;
    JButton searchButton;
    JButton removeButton;
    ArrayList<TeacherData> teacherDataList;
    JTable dataTable;
    JScrollPane scrollPane;
    JButton backButton;
    JButton retakeButton;
    DataBase(ArrayList<TeacherData> teacherDataList) {
        //---------------------Data Table Setup---------------------
        this.teacherDataList = DataBaseCSV.loadFromCSV();
        String[][] data = new String[teacherDataList.size()][8];
        for (int i = 0; i < teacherDataList.size(); i++) {
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


        //---------------------dataBasePanel settings---------------------
        dataBasePanel = new JPanel();
        dataBasePanel.setBounds(0, 0, 1000, 100);
        dataBasePanel.setBackground(new Color(236, 202, 156));
        dataBasePanel.setLayout(null);
        //--------------------/dataBasePanel settings---------------------

        //---------------------dataBaseLabel settings---------------------
        dataBaseLabel = new JLabel("Data Base");
        dataBaseLabel.setBounds(0, 25, 1000, 50);
        dataBaseLabel.setFont(new Font("Serif", Font.BOLD, 50));
        dataBaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dataBasePanel.add(dataBaseLabel);
        //--------------------/dataBaseLabel settings---------------------

        //---------------------searchPanel settings---------------------
        searchPanel = new JPanel();
        searchPanel.setBounds(0, 100, 1000, 30);
        searchPanel.setBackground(new Color(219, 169, 121));
        searchPanel.setLayout(null);
        //--------------------/searchPanel settings---------------------

        //---------------------searchField settings---------------------
        searchField = new JTextField();
        searchField.setBounds(100, 3, 200, 25);
        searchField.setFont(new Font("Serif", Font.PLAIN, 30));
        searchPanel.add(searchField);
        //--------------------/searchField settings---------------------

        //---------------------searchButton settings---------------------
        searchButton = new JButton("Search");
        searchButton.setBounds(325, 3, 100, 25);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);
        searchPanel.add(searchButton);
        //--------------------/searchButton settings---------------------

        //---------------------removeButton settings---------------------
        removeButton = new JButton("Remove");
        removeButton.setBounds(730, 3, 100, 25);
        removeButton.setFocusable(false);
        removeButton.addActionListener(this);
        searchPanel.add(removeButton);
        //--------------------/removeButton settings---------------------

        //---------------------dataTable settings---------------------
        DefaultTableModel model = new DefaultTableModel(data, columnsNames);
        dataTable = new JTable(model);
        scrollPane = new JScrollPane(dataTable);
        updateTableModel();
        scrollPane.setBounds(0, 130, 1000, 620);
        this.add(scrollPane);
        //--------------------/dataTable settings---------------------

        //-------------------Back button--------------------------
        backButton = new JButton("Back");
        backButton.setBounds(850, 3, 100, 25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        searchPanel.add(backButton);
        //-------------------/Back button--------------------------

        //-------------------Retake button------------------------
        retakeButton = new JButton("Retake");
        retakeButton.setBounds(610, 3, 100, 25);
        retakeButton.setFocusable(false);
        retakeButton.addActionListener(this);
        searchPanel.add(retakeButton);
        //-------------------Retake button------------------------

        //---------------------Frame settings---------------------
        this.setTitle("Data Base");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(232, 239, 207));

        this.add(dataBasePanel);
        this.add(searchPanel);

        this.setResizable(false);
        this.setVisible(true);
        //--------------------/Frame settings---------------------
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String searchQuery = searchField.getText().toLowerCase();
            dataTable.clearSelection();
            for (int i = 0; i < dataTable.getRowCount(); i++) {
                for (int j = 0; j < dataTable.getColumnCount(); j++) {
                    if (dataTable.getValueAt(i, j).toString().toLowerCase().contains(searchQuery)) {
                        dataTable.getSelectionModel().addSelectionInterval(i, i);
                    }
                }
            }
        }

        if(e.getSource() == removeButton) {
            int[] selectedRows = dataTable.getSelectedRows();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                int selectedRow = selectedRows[i];
                teacherDataList.remove(selectedRow);
                ((DefaultTableModel) dataTable.getModel()).removeRow(selectedRow);
            }
            DataBaseCSV.saveToCSV(teacherDataList, false);
            RetakeCSV.saveToCSV(teacherDataList, false);
        }

        if(e.getSource() == backButton) {
            this.dispose();
            new Frame();
        }
        if(e.getSource() == retakeButton) {
            this.dispose();
            new Retake(teacherDataList);
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
