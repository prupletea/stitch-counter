import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class StitchCounter {
    public static void main(String args[])
    {
        // FRAMES
        JFrame frame = new JFrame("Stitch Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 365);

        JFrame res = new JFrame("Result");
        res.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // PANEL
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.decode("#f4c064"));

        // LABELS
        JLabel pgsLabel, pgcLabel, ygsLabel, ygcLabel, prsLabel;
        pgsLabel = new JLabel("Pattern gauge (stitches)");
        pgsLabel.setBounds(30, 20, 250, 30);
        pgsLabel.setFont(loadFont("./resources/fonts/Lexend.ttf", 20));
        pgsLabel.setForeground(Color.decode("#000"));
        p.add(pgsLabel);

        pgcLabel = new JLabel("Pattern gauge (cm)");
        pgcLabel.setBounds(30, 80, 250, 30);
        pgcLabel.setFont(loadFont("./resources/fonts/Lexend.ttf", 20));
        pgcLabel.setForeground(Color.decode("#000"));
        p.add(pgcLabel);

        ygsLabel = new JLabel("Your gauge (stitches)");
        ygsLabel.setBounds(30, 140, 250, 30);
        ygsLabel.setFont(loadFont("./resources/fonts/Lexend.ttf", 20));
        ygsLabel.setForeground(Color.decode("#000"));
        p.add(ygsLabel);
        
        ygcLabel = new JLabel("Your gauge (cm)");
        ygcLabel.setBounds(30, 200, 250, 30);
        ygcLabel.setFont(loadFont("./resources/fonts/Lexend.ttf", 20));
        ygcLabel.setForeground(Color.decode("#000"));
        p.add(ygcLabel);
        
        prsLabel = new JLabel("Patter requires (stitches)");
        prsLabel.setBounds(30, 260, 250, 30);
        prsLabel.setFont(loadFont("./resources/fonts/Lexend.ttf", 20));
        prsLabel.setForeground(Color.decode("#000"));
        p.add(prsLabel);
        
        // TEXT FIELDS
        JTextField pgsInput, pgcInput, ygsInput, ygcInput, prsInput;
        pgsInput = new JTextField("");
        pgsInput.setBounds(290, 20, 100, 30);
        pgsInput.setFont(loadFont("./resources/fonts/Lexend.ttf", 20));
        pgsInput.setBackground(Color.decode("#ffe7bf"));
        pgsInput.setForeground(Color.decode("#73664e"));
        pgsInput.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
        setOnFocusText(pgsInput, "stitches", Color.decode("#000"), Color.decode("#73664e"));
        p.add(pgsInput);

        pgcInput = new JTextField();
        pgcInput.setBounds(290, 80, 100, 30);
        pgcInput.setFont(loadFont("./resources/fonts/Lexend.ttf", 20));
        pgcInput.setBackground(Color.decode("#ffe7bf"));
        pgcInput.setForeground(Color.decode("#73664e"));
        pgcInput.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
        setOnFocusText(pgcInput, "cm", Color.decode("#000"), Color.decode("#73664e"));
        p.add(pgcInput);

        ygsInput = new JTextField();
        ygsInput.setBounds(290, 140, 100, 30);
        ygsInput.setFont(loadFont("./resources/fonts/Lexend.ttf", 20));
        ygsInput.setBackground(Color.decode("#ffe7bf"));
        ygsInput.setForeground(Color.decode("#73664e"));
        ygsInput.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
        setOnFocusText(ygsInput, "stitches", Color.decode("#000"), Color.decode("#73664e"));
        p.add(ygsInput);

        ygcInput = new JTextField();
        ygcInput.setBounds(290, 200, 100, 30);
        ygcInput.setFont(loadFont("./resources/fonts/Lexend.ttf", 20));
        ygcInput.setBackground(Color.decode("#ffe7bf"));
        ygcInput.setForeground(Color.decode("#73664e"));
        ygcInput.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
        setOnFocusText(ygcInput, "cm", Color.decode("#000"), Color.decode("#73664e"));
        p.add(ygcInput);

        prsInput = new JTextField();
        prsInput.setBounds(290, 260, 100, 30);
        prsInput.setFont(loadFont("./resources/fonts/Lexend.ttf", 20));
        prsInput.setBackground(Color.decode("#ffe7bf"));
        prsInput.setForeground(Color.decode("#73664e"));
        prsInput.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
        setOnFocusText(prsInput, "stitches", Color.decode("#000"), Color.decode("#73664e"));
        p.add(prsInput);

        // BUTTON
        JButton calculateButton;
        calculateButton = new JButton("Calculate stitches");
        calculateButton.setBounds(425, 250, 125, 50);
        calculateButton.setBackground(Color.decode("#bca8e4"));
        calculateButton.setForeground(Color.decode("#000"));
        calculateButton.setFont(loadFont("./resources/fonts/Lexend.ttf", 14));
        calculateButton.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
        calculateButton.setFocusPainted(false);
        setOnClickColor(calculateButton, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
        p.add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                int pgs = Integer.parseInt(pgsInput.getText());
                double pgc = Double.parseDouble(pgcInput.getText());
                int ygs = Integer.parseInt(ygsInput.getText());
                double ygc = Double.parseDouble(ygcInput.getText());
                int prs = Integer.parseInt(prsInput.getText());

                int yrs = (int) Math.round((((prs*pgc)/pgs)*ygs)/ygc);
                
                JOptionPane.showMessageDialog(frame, "You need " + yrs + " stitches.");
            }
        });

        frame.add(p);
        frame.setVisible(true);
    }

    public static Font loadFont(String path, float size){
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            font = font.deriveFont(size);
            return font;
        } catch (FontFormatException | IOException e) {
            return new Font("Arial", Font.PLAIN, (int) size);
        }
    }

    public static void setOnClickColor(JButton button, Color pressedColor, Color originalColor){
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button.setContentAreaFilled(false);
                button.setBackground(pressedColor);
                button.setOpaque(true);
                button.repaint();
                System.out.println("Button Clicked");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(originalColor);
                button.repaint();
            }
        });
    }

    public static void setOnFocusText(JTextComponent textComponent, String placeholderText, Color focusGainedColor, Color focusLostColor) {
        textComponent.setText(placeholderText);
        textComponent.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textComponent.getText().equals(placeholderText)) {
                    textComponent.setText("");
                    textComponent.setForeground(focusGainedColor);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textComponent.getText().isEmpty()) {
                    textComponent.setText(placeholderText);
                    textComponent.setForeground(focusLostColor);
                }
            }
        });
    }
}