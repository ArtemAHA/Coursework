import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
        Frame(){
        super("CourseWork");
        //Встановлюємо розмір вікна програми
        final int width = 650;
        final int height = 350;
        setSize(width, height);
        //Визначаємо розмір екрану коористувача
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //Розміщуємо вікно програми по центру екрану
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        setLocation(x, y);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container conteiner = super.getContentPane();
        conteiner.setLayout(null);

        JLabel name = new JLabel("Введіть ім'я:");
        name.setBounds(30, 40, 200, 20);
        JTextField name_field = new JTextField();
        name_field.setBounds(165, 40, 150, 20);

        JLabel last_name = new JLabel("Введіть прізвище:");
        last_name.setBounds(30, 70, 200, 20);
        JTextField last_name_field = new JTextField();
        last_name_field.setBounds(165, 70, 150,20);

        conteiner.add(name);
        conteiner.add(name_field);
        conteiner.add(last_name);
        conteiner.add(last_name_field);

        JLabel disceplin = new JLabel("Зазначте тип десцепліни:");
        disceplin.setBounds(30, 110, 200, 20);

        JRadioButton disceplin_viber = new JRadioButton("Вибіркова");
        disceplin_viber.setBounds(190, 110, 90, 20);
        JRadioButton disceplin_osnov = new JRadioButton("За програмою");
        disceplin_osnov.setBounds(290, 110, 150, 20);

        disceplin_osnov.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(disceplin_osnov);
        group.add(disceplin_viber);

        //String[] option

        conteiner.add(disceplin);
        conteiner.add(disceplin_viber);
        conteiner.add(disceplin_osnov);

        this.setVisible(true);
        this.setResizable(false);
    }
}