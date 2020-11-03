import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

@SuppressWarnings("serial")
public class admin_form extends JFrame implements ActionListener{
    private JComboBox<String> cb;
    private JFrame f;    
    private JButton back;
    private JButton resetall;
    private JButton setval;
    private JLabel quantity;
    private JLabel expiry;
    private JLabel cost;
    private JTextField quantity_val;
    private JTextField expiry_val;
    private JTextField cost_val;


    public void form(){

        f = new JFrame("BIGBASKET - ADMIN MODE"); 

        quantity = new JLabel("Q :"); 
        quantity.setFont(new Font("Arial", Font.BOLD, 15)); 
        quantity.setSize(100, 30); 
        quantity.setLocation(150, 45); 
        f.add(quantity);

        expiry = new JLabel("E : "); 
        expiry.setFont(new Font("Arial", Font.BOLD, 15)); 
        expiry.setSize(100, 30); 
        expiry.setLocation(250, 45); 
        f.add(expiry);

        cost = new JLabel("C : "); 
        cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        cost.setSize(100, 30); 
        cost.setLocation(350, 45); 
        f.add(cost);

        quantity_val = new JTextField("0"); 
        quantity_val.setFont(new Font("Arial", Font.PLAIN, 15)); 
        quantity_val.setSize(30, 30); 
        quantity_val.setLocation(180, 45); 
        f.add(quantity_val);

        expiry_val = new JTextField("0"); 
        expiry_val.setFont(new Font("Arial", Font.PLAIN, 15)); 
        expiry_val.setSize(30, 30); 
        expiry_val.setLocation(280, 45); 
        f.add(expiry_val);

        cost_val = new JTextField("0"); 
        cost_val.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cost_val.setSize(30, 30); 
        cost_val.setLocation(380, 45); 
        f.add(cost_val);

        resetall = new JButton("RESET ALL"); 
        resetall.setFont(new Font("Arial", Font.PLAIN, 15)); 
        resetall.setSize(120, 30); 
        resetall.setLocation(250, 150); 
        resetall.addActionListener(this); 
        f.add(resetall);

        back = new JButton("Logout"); 
        back.setFont(new Font("Arial", Font.PLAIN, 15)); 
        back.setSize(75, 30); 
        back.setLocation(50, 150); 
        back.addActionListener(this); 
        f.add(back);

        setval = new JButton("SET"); 
        setval.setFont(new Font("Arial", Font.PLAIN, 15)); 
        setval.setSize(75, 30); 
        setval.setLocation(150, 150); 
        setval.addActionListener(this); 
        f.add(setval);

        String products[]={"Spinach","Cauli-flower","Mushrooms","Beet","Brocolli","Cabbage","Apple","Orange","Bananas","Cherries","Chicken","Fish","Crabs"};        
        cb=new JComboBox<>(products); 

        cb.setBounds(50, 50,90,20);    
        f.add(cb);        
        f.setLayout(null);    
        f.setSize(500,250);    
        f.setVisible(true);         
    }

    public void actionPerformed(ActionEvent e){
        login_reg_choose_form login_signup = new login_reg_choose_form(); 
        market_database_handling mdh = new market_database_handling();

        if(e.getSource()==back){
            login_signup.form();
            f.dispose();
        }
        if(e.getSource()==resetall){
            mdh.run_default_market();            
        }
        if(e.getSource()==setval){
            String product = cb.getItemAt(cb.getSelectedIndex());
            Integer Quantity = Integer.parseInt(quantity_val.getText());
            Integer Cost = Integer.parseInt(cost_val.getText());
            Integer Expiry_days = Integer.parseInt(expiry_val.getText());

            mdh.update_item(product, Quantity, Cost, Expiry_days);

        }
    }
}