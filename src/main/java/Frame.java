import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    JTextField firstNameField;
    JTextField secondNameField;

    public Frame() {
        super("CourseWork");

        //Встановлюємо розмір вікна програми
        final int width = 650;
        final int height = 350;

        //Визначаємо розмір екрану коористувача
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //Розміщуємо вікно програми по центру екрану
        //int x = (screenSize.width - width) / 2;
        //int y = (screenSize.height - height) / 2;
        //setLocation(x, y);

        JLabel name = new JLabel("Введіть ім'я:");
        name.setBounds(30, 40, 200, 10);
        JTextField name_field = new JTextField();
        name_field.setBounds(120, 37, 150, 20);

        JLabel last_name = new JLabel("Введіть прізвище:");
        JTextField last_name_field = new JTextField();
        last_name_field.setPreferredSize(new Dimension(50, 10));

        JLabel disceplin = new JLabel("Зазначте тип десцепліни:");
        JPanel disciplinePanel = new JPanel();
        disciplinePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JRadioButton disceplin_viber = new JRadioButton("Вибіркова");
        JRadioButton disceplin_osnov = new JRadioButton("За програмою");

        disceplin_osnov.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(disceplin_osnov);
        group.add(disceplin_viber);

        disciplinePanel.add(disceplin);
        disciplinePanel.add(disceplin_viber);
        disciplinePanel.add(disceplin_osnov);


        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(width, height);

        this.add(name);
        this.add(name_field);
        this.add(last_name);
        this.add(last_name_field);

        this.setVisible(true);
    }
}
