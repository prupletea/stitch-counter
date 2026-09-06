import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class StitchCounter extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField pgsInput, pgcInput, ygsInput, ygcInput, prsInput;
    static JLabel ansLabel;
    static int yrs;

    StitchCounter(){}

    public static void setYRS(int pgs, double pgc, int ygs, double ygc, int prs){
        yrs = (int) Math.round((((prs*pgc)/pgs)*ygs)/ygc);
    }
    public static int getYRS()
    {
        return yrs;
    }

    @SuppressWarnings("deprecation")
    public static void main(String args[])
    {

        frame = new JFrame("Stitch Counter");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }

        JLabel pgsLabel, pgcLabel, ygsLabel, ygcLabel, prsLabel, tipLabel;
        tipLabel = new JLabel("Tip: when entering cm values, use a comma, for example: 10.0 or 4.25");
        pgsLabel = new JLabel("Pattern gauge (stitches)");
        pgcLabel = new JLabel("Pattern gauge (cm)");
        ygsLabel = new JLabel("Your gauge (stitches)");
        ygcLabel = new JLabel("Your gauge (cm)");
        prsLabel = new JLabel("Patter requires (stitches)");
        ansLabel = new JLabel("You need " + getYRS() + " stitches.");

        pgsInput = new JTextField();
        pgcInput = new JTextField();
        ygsInput = new JTextField(); 
        ygcInput = new JTextField();
        prsInput = new JTextField();

        JButton doneButton;
        doneButton = new JButton("Calculate stitches");

        JPanel p = new JPanel();

        p.add(tipLabel);
        p.add(pgsLabel);
        p.add(pgsInput);
        p.add(pgcLabel);
        p.add(pgcInput);
        p.add(ygsLabel);
        p.add(ygsInput);
        p.add(ygcLabel);
        p.add(ygcInput);
        p.add(prsLabel);
        p.add(prsInput);
        p.add(doneButton);

        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                int pgs = Integer.parseInt(pgsInput.getText());
                double pgc = Double.parseDouble(pgcInput.getText());
                int ygs = Integer.parseInt(ygsInput.getText());
                double ygc = Double.parseDouble(ygcInput.getText());
                int prs = Integer.parseInt(prsInput.getText());

                setYRS(pgs, pgc, ygs, ygc, prs);
                p.add(ansLabel);
            }
        });

        p.setBackground(Color.getColor("#A9BD93"));
        frame.add(p);

        frame.setSize(500, 300);
        frame.show();
    }

    public void actionPerformed(ActionEvent ae)
    {
        
    }
}

//todo
// - display label after button click
// - clean up the ui
// - test