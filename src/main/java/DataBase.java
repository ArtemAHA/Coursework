import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataBase extends JFrame implements ActionListener {
    JPanel dataBasePanel;
    JPanel searchPanel;
    JLabel dataBaseLabel;
    JTextField searchField;
    JButton searchButton;
    JButton removeButton;

    DataBase() {

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
        searchField.setBounds(300, 0, 400, 25);
        searchField.setFont(new Font("Serif", Font.PLAIN, 30));
        searchPanel.add(searchField);
        //--------------------/searchField settings---------------------

        //---------------------searchButton settings---------------------
        searchButton = new JButton("Search");
        searchButton.setBounds(200, 0, 100, 25);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);
        searchPanel.add(searchButton);
        //--------------------/searchButton settings---------------------

        //---------------------removeButton settings---------------------
        removeButton = new JButton("Remove");
        removeButton.setBounds(700, 0, 100, 25);
        removeButton.setFocusable(false);
        removeButton.addActionListener(this);
        searchPanel.add(removeButton);
        //--------------------/removeButton settings---------------------

        //---------------------Frame settings---------------------
        this.setTitle("Data Base");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(232, 239, 207));

        this.add(dataBasePanel);
        this.add(searchPanel);

        this.setVisible(true);
        //--------------------/Frame settings---------------------
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
