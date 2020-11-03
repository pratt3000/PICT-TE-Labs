import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

@SuppressWarnings("serial")
public class reg_form extends JFrame implements ActionListener { 
  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel name; 
    private JTextField tname; 
    private JTextField tpass;
    private JLabel mno; 
    private JTextField tmno;
    private JLabel add; 
    private JTextArea tadd;
    private JTextArea tnc;
    private JCheckBox term; 
    private JButton sub; 
    private JButton back; 
    private JButton reset; 
    private JLabel res; 
  
    // constructor, to initialize the components 
    // with default values. 
    public void form() { 
        setTitle("User Registration Form"); 
        setBounds(300, 90, 550, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("REGISTERATION"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(500, 30); 
        title.setLocation(165, 30); 
        c.add(title); 
  
        name = new JLabel("Username"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(150, 20); 
        name.setLocation(100, 100); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(200, 20); 
        tname.setLocation(250, 100); 
        c.add(tname); 

        name = new JLabel("Password"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(150, 20); 
        name.setLocation(100, 150); 
        c.add(name); 
  
        tpass = new JTextField(); 
        tpass.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpass.setSize(200, 20); 
        tpass.setLocation(250, 150); 
        c.add(tpass);
  
        mno = new JLabel("Mobile no."); 
        mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mno.setSize(150, 20); 
        mno.setLocation(100, 200); 
        c.add(mno); 
  
        tmno = new JTextField(); 
        tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tmno.setSize(200, 20); 
        tmno.setLocation(250, 200); 
        c.add(tmno);  
  
        add = new JLabel("Address"); 
        add.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add.setSize(150, 20); 
        add.setLocation(100, 275); 
        c.add(add); 
  
        tadd = new JTextArea(); 
        tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tadd.setSize(200, 75); 
        tadd.setLocation(250, 250); 
        tadd.setLineWrap(true); 
        c.add(tadd); 
  
        term = new JCheckBox("Accept Terms And Conditions."); 
        term.setFont(new Font("Arial", Font.PLAIN, 15)); 
        term.setSize(250, 20); 
        term.setLocation(100, 350); 
        c.add(term);
        
        tnc = new JTextArea(); 
        tnc.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tnc.setSize(350, 75); 
        tnc.setLocation(100, 375); 
        tnc.setLineWrap(true); 
        tnc.setText("1. Above 18 years of age ? ");
        c.add(tnc);
  
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(340, 475); 
        sub.addActionListener(this); 
        c.add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(220, 475); 
        reset.addActionListener(this); 
        c.add(reset); 

        back = new JButton("Back"); 
        back.setFont(new Font("Arial", Font.PLAIN, 15)); 
        back.setSize(100, 20); 
        back.setLocation(100, 475); 
        back.addActionListener(this); 
        c.add(back);
  
        res = new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(500, 25); 
        res.setLocation(100, 500); 
        c.add(res); 
   
        setVisible(true); 
    } 
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        String username;
        String password;
        String mobile;
        String address;
        home_page home = new home_page();
        login_reg_choose_form login_signup = new login_reg_choose_form();
        account_handling acch = new account_handling();

        if (e.getSource() == sub) { 
            if (term.isSelected() ) {        // to check if terms and conditions accepted  
                username = tname.getText();
                password = tpass.getText();
                mobile = tmno.getText();
                address = tadd.getText();
                String status = acch.new_user_login(username,password);

                res.setText(status);
                if(status.equals("success")){
                    
                    home.form(username); //if reg done successfully
                    JComponent comp = (JComponent) e.getSource();
                    Window win = SwingUtilities.getWindowAncestor(comp);
                    win.dispose();
                }
            } 
            else {  
                res.setText("Please accept the"
                            + " terms & conditions.."); 
            } 
        } 
  
        else if (e.getSource() == reset) { 
            String def = ""; 
            tname.setText(def); 
            tpass.setText(def);
            tadd.setText(def); 
            tmno.setText(def); 
            res.setText(def); 
            term.setSelected(false); 
        } 
        else if (e.getSource() == back) { 
            login_signup.form();
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        } 
    } 
} 