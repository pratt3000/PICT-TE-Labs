import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
 
class Registrationform {

    public static void main(String[] args)
                          throws Exception
    {
        home_page f = new home_page();
    }
}

class reg_form extends JFrame implements ActionListener { 
  
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
    public reg_form() 
    { 
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

        if (e.getSource() == sub) { 
            if (term.isSelected() ) {        // to check if terms and conditions accepted  
                username = tname.getText();
                password = tpass.getText();
                mobile = tmno.getText();
                address = tadd.getText();

                res.setText("Registration Successfully..");
                
                home_page f = new home_page();
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
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
            login_reg_choose_form f = new login_reg_choose_form(); 
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        } 
    } 
} 
 

class login_form extends JFrame implements ActionListener{

    private Container c; 
    private JLabel title;

    private JLabel name; 
    private JTextField tname; 
    private JTextField tpass;
    private JButton sub;
    private JButton back;

    public login_form(){
        setTitle("User Login"); 
        setBounds(300, 90, 550, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Login Form"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(500, 100); 
        title.setLocation(200, 30); 
        c.add(title);

        name = new JLabel("Username"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(150, 20); 
        name.setLocation(100, 200); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(200, 20); 
        tname.setLocation(250, 200); 
        c.add(tname); 

        name = new JLabel("Password"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(150, 20); 
        name.setLocation(100, 240); 
        c.add(name); 
  
        tpass = new JTextField(); 
        tpass.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpass.setSize(200, 20); 
        tpass.setLocation(250, 240); 
        c.add(tpass);

        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(150, 60); 
        sub.setLocation(280, 350); 
        sub.addActionListener(this); 
        c.add(sub);

        back = new JButton("Back"); 
        back.setFont(new Font("Arial", Font.PLAIN, 15)); 
        back.setSize(150, 60); 
        back.setLocation(125, 350); 
        back.addActionListener(this); 
        c.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String username;
        String password;

        if (e.getSource() == sub){
            username = tname.getText();
            password = tpass.getText();
            home_page f = new home_page();
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        else if (e.getSource() == back) {
            login_reg_choose_form f = new login_reg_choose_form(); 
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
    }

}

class login_reg_choose_form extends JFrame implements ActionListener{
    private Container c;
    private JLabel title;
    private JButton Login; 
    private JButton Signup;

    public login_reg_choose_form(){
        setTitle("WELCOME TO BIGBASKET"); 
        setBounds(300, 90, 550, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null);

        title = new JLabel("WELCOME TO BIGBASKET"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(500, 30); 
        title.setLocation(85, 75); 
        c.add(title);

        Signup = new JButton("Signup"); 
        Signup.setFont(new Font("Arial", Font.PLAIN, 15)); 
        Signup.setSize(300, 100); 
        Signup.setLocation(125, 200); 
        Signup.addActionListener(this); 
        c.add(Signup); 
  
        Login = new JButton("Login"); 
        Login.setFont(new Font("Arial", Font.PLAIN, 15)); 
        Login.setSize(300, 100); 
        Login.setLocation(125, 350); 
        Login.addActionListener(this); 
        c.add(Login);

        setVisible(true); 
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Signup) {
            reg_form f = new reg_form(); 
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

        }
        else if (e.getSource() == Login){
            login_form f = new login_form();
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        
    }
}

class home_page extends JFrame implements ActionListener{
    private JButton market;
    private JButton checkout;
    private JButton logout;
    private JButton feedback;
    private JButton back;
    private JButton about;
    private Container c;
    private JLabel title;

    public home_page(){
        setTitle("BIG BASKET"); 
        setBounds(300, 250, 1000, 850); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null);

        title = new JLabel("BIG BASKET"); 
        title.setFont(new Font("Arial", Font.PLAIN, 60)); 
        title.setSize(500, 100); 
        title.setLocation(300, 150); 
        c.add(title);

        market = new JButton("MARKET"); 
        market.setFont(new Font("Arial", Font.PLAIN, 15)); 
        market.setSize(300, 100); 
        market.setLocation(125, 350); 
        market.addActionListener(this); 
        c.add(market);

        checkout = new JButton("CHECKOUT"); 
        checkout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        checkout.setSize(300, 100); 
        checkout.setLocation(525, 350); 
        checkout.addActionListener(this); 
        c.add(checkout);

        logout = new JButton("LOGOUT"); 
        logout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        logout.setSize(300, 100); 
        logout.setLocation(125, 500); 
        logout.addActionListener(this); 
        c.add(logout);

        feedback = new JButton("FEEDBACK"); 
        feedback.setFont(new Font("Arial", Font.PLAIN, 15)); 
        feedback.setSize(300, 100); 
        feedback.setLocation(525, 500); 
        feedback.addActionListener(this); 
        c.add(feedback);

        back = new JButton("BACK"); 
        back.setFont(new Font("Arial", Font.PLAIN, 15)); 
        back.setSize(300, 100); 
        back.setLocation(125, 650); 
        back.addActionListener(this); 
        c.add(back);

        about = new JButton("ABOUT"); 
        about.setFont(new Font("Arial", Font.PLAIN, 15)); 
        about.setSize(300, 100); 
        about.setLocation(525, 650); 
        about.addActionListener(this); 
        c.add(about);

        setVisible(true); 
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            login_reg_choose_form f = new login_reg_choose_form();  
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

        }
        else if (e.getSource() == feedback){
            
            
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        else if (e.getSource() == logout){
            login_reg_choose_form f = new login_reg_choose_form();  
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        else if (e.getSource() == about){
            
            
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        else if (e.getSource() == checkout){
            
            
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        else if (e.getSource() == market){
            
            
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        
    }
}

// Driver Code 
class Registration { 
  
    public static void main(String[] args) throws Exception 
    { 
        login_reg_choose_form f = new login_reg_choose_form();
        
    } 
} 

