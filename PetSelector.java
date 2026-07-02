package petselector;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PetSelector extends JFrame implements ActionListener {

    private JRadioButton bird, cat, dog, rabbit, pig;
    private JLabel imageLabel;

    public PetSelector() {

        setTitle("Pet Selector");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(5, 1));

        bird = new JRadioButton("Bird");
        cat = new JRadioButton("Cat");
        dog = new JRadioButton("Dog");
        rabbit = new JRadioButton("Rabbit");
        pig = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        group.add(bird);
        group.add(cat);
        group.add(dog);
        group.add(rabbit);
        group.add(pig);

        leftPanel.add(bird);
        leftPanel.add(cat);
        leftPanel.add(dog);
        leftPanel.add(rabbit);
        leftPanel.add(pig);

        add(leftPanel, BorderLayout.WEST);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        bird.addActionListener(this);
        cat.addActionListener(this);
        dog.addActionListener(this);
        rabbit.addActionListener(this);
        pig.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent e) {

    ImageIcon icon = null;

    if (bird.isSelected()) {
        icon = new ImageIcon(getClass().getResource("/images/bird.jpg"));
    } else if (cat.isSelected()) {
        icon = new ImageIcon(getClass().getResource("/images/cat.jpg"));
    } else if (dog.isSelected()) {
        icon = new ImageIcon(getClass().getResource("/images/dog.jpg"));
    } else if (rabbit.isSelected()) {
        icon = new ImageIcon(getClass().getResource("/images/rabbit.jpg"));
    } else if (pig.isSelected()) {
        icon = new ImageIcon(getClass().getResource("/images/pig.jpg"));
    }

    if (icon != null) {
        Image img = icon.getImage();

        // 🔥 resize image here
        Image scaledImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);

        imageLabel.setIcon(new ImageIcon(scaledImg));
    }
}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PetSelector());
    }
}