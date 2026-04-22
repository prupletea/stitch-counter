import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StitchCounter extends JFrame implements ActionListener
{
    //form components
    private Container c;
    private JLabel title;
    private JTextField pattern_gauge_cm;
    private JTextField pattern_gauge_st;
    private JTextField user_gauge_cm;
    private JTextField user_gauge_st;
    private JTextField patter_requires_st;
    private JLabel pattern_gauge_cm_label;
    private JLabel pattern_gauge_st_label;
    private JLabel user_gauge_cm_label;
    private JLabel user_gauge_st_label;
    private JLabel pattern_requires_st_label;
    private JTextPane user_needs_st;
    private JLabel user_needs_st_label;
    private JButton reset;
    private JButton calculate;

    //input data
    double pattern_cm, user_cm;
    int pattern_st, user_st;

    public StitchCounter()
    {
        setTitle("Stitch Counter");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Stitch Counter");
        title.setFont(new Font("Comic Sans", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        pattern_gauge_cm_label = new JLabel("Pattern gauge (cm):");
        pattern_gauge_cm_label.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        pattern_gauge_cm_label.setSize(100, 25);
        pattern_gauge_cm_label.setLocation(225, 75);
        c.add(pattern_gauge_cm_label);

        pattern_gauge_cm = new JTextField();
        pattern_gauge_cm.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        pattern_gauge_cm.setSize(50, 25);
        pattern_gauge_cm.setLocation(225, 150);
        c.add(pattern_gauge_cm);
        
        pattern_gauge_st_label = new JLabel("Pattern gauge (stitches):");
        pattern_gauge_st_label.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        pattern_gauge_st_label.setSize(100, 25);
        pattern_gauge_st_label.setLocation(175, 75);
        c.add(pattern_gauge_st_label);

        pattern_gauge_st = new JTextField();
        pattern_gauge_st.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        pattern_gauge_st.setSize(50, 25);
        pattern_gauge_st.setLocation(175, 150);
        c.add(pattern_gauge_st);

        user_gauge_cm_label = new JLabel("My gauge (cm):");
        user_gauge_cm_label.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        user_gauge_cm_label.setSize(100, 25);
        user_gauge_cm_label.setLocation(225, 75);
        c.add(user_gauge_cm_label);

        user_gauge_cm = new JTextField();
        user_gauge_cm.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        user_gauge_cm.setSize(50, 25);
        user_gauge_cm.setLocation(225, 150);
        c.add(user_gauge_cm);
        
        user_gauge_st_label = new JLabel("My gauge (stitches):");
        user_gauge_st_label.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        user_gauge_st_label.setSize(100, 25);
        user_gauge_st_label.setLocation(175, 75);
        c.add(user_gauge_st_label);

        user_gauge_st = new JTextField();
        user_gauge_st.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        user_gauge_st.setSize(50, 25);
        user_gauge_st.setLocation(175, 150);
        c.add(user_gauge_st);
    }

    // continue by this example - https://www.geeksforgeeks.org/java/java-swing-simple-user-registration-form/ 

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}

// patern gauge x cm - y st
// user gauge z cm - u st
// pattern requires - q st
// how many stitches does the user need?