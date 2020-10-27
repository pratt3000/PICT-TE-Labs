import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

@SuppressWarnings("serial")
public class login_form extends JFrame implements ActionListener{

    private Container c; 
    private JLabel title;

    private JLabel name; 
    private JTextField tname; 
    private JTextField tpass;
    private JButton sub;
    private JButton back;

    public void form(){
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
        login_reg_choose_form login_signup = new login_reg_choose_form(); 
        home_page home = new home_page();
        
        if (e.getSource() == sub){
            username = tname.getText();
            password = tpass.getText();

            home.form();    // if login success
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        else if (e.getSource() == back) {
            login_signup.form();
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
    }

}
