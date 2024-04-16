import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Frame extends JFrame implements ActionListener {
        JLabel nameLabel;
        JTextField nameField;
        JLabel lastNameLabel;
        JTextField lastNameField;
        JLabel disceplineLabel;
        JRadioButton disceplineElectiveButton;
        JRadioButton disceplineProgramButton;
        ButtonGroup disceplineGroup;
        JComboBox<String> departmenComboBox;
        JLabel departmentLabel;
        JLabel disceplineName;
        JTextField disceplineNameField;
        JLabel disceplineTime;
        JTextField disceplineTimeField;
        JButton addItemButton;
        JButton dataBaseButton;
        ArrayList<TeacherData> teacherData = new ArrayList<TeacherData>();
        Frame(){
                super("CourseWork");
                //Window size
                final int width = 1000;
                final int height = 750;

                //---------------------Labels and TextFields---------------------
                nameLabel = new JLabel("Enter name:");
                nameLabel.setBounds(30, 40, 200, 20);
                nameField = new JTextField();
                nameField.setBounds(165, 40, 150, 20);

                lastNameLabel = new JLabel("Enter last name:");
                lastNameLabel.setBounds(30, 70, 200, 20);
                lastNameField = new JTextField();
                lastNameField.setBounds(165, 70, 150,20);

                disceplineLabel = new JLabel("Enter discepline:");
                disceplineLabel.setBounds(30, 110, 200, 20);
                //--------------------/Labels and TextFields---------------------

                //---------------------Discipline Buttons---------------------
                disceplineElectiveButton = new JRadioButton("Elective");
                disceplineElectiveButton.setBounds(165, 110, 100, 20);
                disceplineElectiveButton.setFocusable(false);

                disceplineProgramButton = new JRadioButton("According to the program");
                disceplineProgramButton.setBounds(265, 110, 200, 20);
                disceplineProgramButton.setFocusable(false);
                disceplineProgramButton.setSelected(true);

                disceplineGroup = new ButtonGroup();
                disceplineGroup.add(disceplineProgramButton);
                disceplineGroup.add(disceplineElectiveButton);
                //--------------------/Discipline Buttons---------------------

                //---------------------DepartmentLabel---------------------
                departmentLabel = new JLabel("Choose department:");
                departmentLabel.setBounds(30, 150, 200, 20);
                //--------------------/DepartmentLabel---------------------

                //---------------------DepartmentComboBox---------------------
                String[] departments = {"Department of Computer Science", "Department of Mathematics", "Department of Physics"};
                departmenComboBox = new JComboBox<>(departments);
                departmenComboBox.setBounds(165, 150, 200, 20);
                //--------------------/DepartmentComboBox---------------------

                //---------------------Discepline name------------------------
                disceplineName = new JLabel("Enter discepline name:");
                disceplineName.setBounds(30, 200, 200, 20);
                disceplineNameField = new JTextField();
                disceplineNameField.setBounds(165, 200, 150,20);
                //---------------------/Discepline name----------------------

                //---------------------Time for exam-------------------------
                disceplineTime = new JLabel("Alloted time for exam:");
                disceplineTime.setBounds(30, 235, 200, 20);
                disceplineTimeField = new JTextField();
                disceplineTimeField.setBounds(165, 235, 150,20);
                //---------------------/Time for exam-----------------------

                //---------------------AddItemButton------------------------
                addItemButton = new JButton("ADD");
                addItemButton.setSize(170, 50);
                addItemButton.setBounds(150, 330, 170, 50);
                addItemButton.addActionListener(this);
                //---------------------/AddItemButton------------------------

                //----------------------Database-----------------------------
                dataBaseButton = new JButton("Database");
                dataBaseButton.setSize(170, 50);
                dataBaseButton.setBounds(620, 330, 170, 50);
                dataBaseButton.addActionListener(this);
                //----------------------/Database-----------------------------

                //---------------------Frame Setup---------------------
                this.add(nameLabel);
                this.add(nameField);
                this.add(lastNameLabel);
                this.add(lastNameField);
                this.add(disceplineLabel);
                this.add(disceplineElectiveButton);
                this.add(disceplineProgramButton);
                this.add(departmenComboBox);
                this.add(departmentLabel);
                this.add(disceplineName);
                this.add(disceplineNameField);
                this.add(disceplineTime);
                this.add(disceplineTimeField);
                this.add(addItemButton);
                this.add(dataBaseButton);

                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setSize(width, height);
                this.setLocationRelativeTo(null);
                this.setLayout(null);
                this.getContentPane().setBackground(new Color(179, 200, 207));
                this.setVisible(true);
                this.setResizable(false);
                //--------------------/Frame Setup---------------------
    }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == addItemButton){
                        String name = nameField.getText();
                        String lastName = lastNameField.getText();
                        String discepline = "";
                        if(disceplineElectiveButton.isSelected()){
                                discepline = "Elective";
                        } else {
                                discepline = "According to the program";
                        }
                        String department = departmenComboBox.getSelectedItem().toString();
                        String disceplineName = disceplineNameField.getText();
                        String disceplineTime = disceplineTimeField.getText();
                        teacherData.add(new TeacherData(name, lastName, discepline, department, disceplineName, disceplineTime));
                        DataBaseCSV.saveToCSV(teacherData, true);
                        nameField.setText("");
                        lastNameField.setText("");
                        disceplineNameField.setText("");
                        disceplineTimeField.setText("");
                }
                if(e.getSource() == dataBaseButton){
                        this.dispose();
                        new DataBase(teacherData);
                }
        }
}