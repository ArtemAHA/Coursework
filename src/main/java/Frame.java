import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
        JLabel nameLabel;
        JTextField nameField;
        JLabel lastNameLabel;
        JTextField lastNameField;
        JLabel disceplineLabel;
        JRadioButton disceplineElectiveButton;
        JRadioButton disceplineProgramButton;
        ButtonGroup disceplineGroup;
        JComboBox<String> departmentList;
        JLabel departmentLabel;
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
                departmentList = new JComboBox<>(departments);
                departmentList.setBounds(200, 150, 200, 20);
                //--------------------/DepartmentComboBox---------------------

                //---------------------Frame Setup---------------------
                this.add(nameLabel);
                this.add(nameField);
                this.add(lastNameLabel);
                this.add(lastNameField);
                this.add(disceplineLabel);
                this.add(disceplineElectiveButton);
                this.add(disceplineProgramButton);
                this.add(departmentList);
                this.add(departmentLabel);

                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setSize(width, height);
                this.setLocationRelativeTo(null);
                this.setLayout(null);
                this.getContentPane().setBackground(new Color(179, 200, 207));
                this.setVisible(true);
                this.setResizable(false);
                //--------------------/Frame Setup---------------------
    }
}