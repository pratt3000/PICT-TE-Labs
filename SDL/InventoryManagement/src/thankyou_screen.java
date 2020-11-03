import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

@SuppressWarnings("serial")
public class thankyou_screen extends JFrame implements ActionListener{

    private Container c; 
    private JLabel title;
    private JButton home;
    private JButton logout;
    String username;

    public void form(String username){
        username = "null";
        this.username = username;

        setTitle("THANK YOU"); 
        setBounds(300, 90, 550, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("THANKS FOR SHOPPING!!!"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(500, 100); 
        title.setLocation(50, 30); 
        c.add(title);

        home = new JButton("HOME"); 
        home.setFont(new Font("Arial", Font.PLAIN, 15)); 
        home.setSize(150, 60); 
        home.setLocation(280, 350); 
        home.addActionListener(this); 
        c.add(home);

        logout = new JButton("LOGOUT"); 
        logout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        logout.setSize(150, 60); 
        logout.setLocation(125, 350); 
        logout.addActionListener(this); 
        c.add(logout);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        login_reg_choose_form login_signup = new login_reg_choose_form(); 
        home_page hom = new home_page();

        if (e.getSource() == home){
            hom.form(username);    
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        else if (e.getSource() == logout) {
            login_signup.form();
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
    }
}