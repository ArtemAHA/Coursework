import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
        Frame(){
                super("CourseWork");
                //Window size
                final int width = 1000;
                final int height = 750;

                //---------------------Labels and TextFields---------------------
                JLabel name = new JLabel("Enter name:");
                name.setBounds(30, 40, 200, 20);
                JTextField nameField = new JTextField();
                nameField.setBounds(165, 40, 150, 20);

                JLabel lastName = new JLabel("Enter last name:");
                lastName.setBounds(30, 70, 200, 20);
                JTextField lastNameField = new JTextField();
                lastNameField.setBounds(165, 70, 150,20);

                JLabel discepline = new JLabel("Enter discepline:");
                discepline.setBounds(30, 110, 200, 20);
                //--------------------/Labels and TextFields---------------------

                //---------------------Discipline Buttons---------------------
                JRadioButton disceplineElectiveButton = new JRadioButton("Elective");
                disceplineElectiveButton.setBounds(165, 110, 100, 20);

                JRadioButton disceplineProgramButton = new JRadioButton("According to the program");
                disceplineProgramButton.setBounds(265, 110, 200, 20);

                ButtonGroup disceplineGroup = new ButtonGroup();
                disceplineGroup.add(disceplineProgramButton);
                disceplineGroup.add(disceplineElectiveButton);
                //--------------------/Discipline Buttons---------------------

                //---------------------Frame Setup---------------------
                this.add(name);
                this.add(nameField);
                this.add(lastName);
                this.add(lastNameField);
                this.add(discepline);
                this.add(disceplineElectiveButton);
                this.add(disceplineProgramButton);

                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setSize(width, height);
                this.setLocationRelativeTo(null);
                this.setLayout(null);
                this.setVisible(true);
                this.setResizable(false);
                //--------------------/Frame Setup---------------------
    }
}