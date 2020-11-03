import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

@SuppressWarnings("serial")
public class about extends JFrame implements ActionListener{

    private JLabel title;
    private JLabel abt; 
    private JMenu menu;  
    private JMenuItem i1, i2;
    private JMenuBar mb;
    private JFrame f;
    String username;

    public void form(String username){
        username = "null";
        this.username = username;
        
        f = new JFrame("BIGBASKET");  

        title = new JLabel("BIG BASKET"); 
        title.setFont(new Font("Arial", Font.PLAIN, 60)); 
        title.setSize(500, 100); 
        title.setLocation(50, 100); 
        f.add(title);

        abt = new JLabel("MADE BY PRATHAMESH :) [Nov 2020]"); 
        abt.setFont(new Font("Arial", Font.PLAIN, 15)); 
        abt.setSize(500, 100); 
        abt.setLocation(50, 200); 
        f.add(abt);

        menu=new JMenu("Options"); 
        mb=new JMenuBar(); 
        i1=new JMenuItem("logout");
        i2=new JMenuItem("back");
        i1.addActionListener(this);    
        i2.addActionListener(this);    
        menu.add(i1); 
        menu.add(i2);
        mb.add(menu);

        f.setJMenuBar(mb);  
        f.setSize(600,400);  
        f.setLayout(null);  
        f.setVisible(true);

        setVisible(true);            
    }
    public void actionPerformed(ActionEvent e){
        login_reg_choose_form login_signup = new login_reg_choose_form(); 
        home_page home = new home_page();

        if(e.getSource()==i1){
            login_signup.form();
            f.dispose();
        }
        if(e.getSource()==i2){
            home.form(username); //if reg done successfully
            
            f.dispose();
        }
    }
}