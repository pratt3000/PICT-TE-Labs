import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

@SuppressWarnings("serial")
public class login_reg_choose_form extends JFrame implements ActionListener{
    private Container c;
    private JLabel title;
    private JButton Login; 
    private JButton Signup;

    public void form(){
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

        reg_form reg_form = new reg_form();
        login_form login_form = new login_form();

        if (e.getSource() == Signup) {
            reg_form.form();
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        else if (e.getSource() == Login){
            login_form.form();
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        
    }
}