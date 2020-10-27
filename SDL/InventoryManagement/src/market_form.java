import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

@SuppressWarnings("serial")
public class market_form extends JFrame implements ActionListener{

    private Container c;
    private JLabel title;
    private JLabel res;

    private JLabel tab_name;
    private JLabel tab_quan;
    private JLabel tab_exp;
    private JLabel tab_cost;
    private JLabel tab_buy_amt;

    private JLabel spinach;
    private JLabel cauliflower;
    private JLabel mushroom;
    private JLabel beet;
    private JLabel brocolli;
    private JLabel cabbage;
    private JLabel apple;
    private JLabel orange;
    private JLabel banana;
    private JLabel cherry;
    private JLabel chicken;
    private JLabel fish;
    private JLabel crab;

    private JLabel spinach_quan;
    private JLabel cauliflower_quan;
    private JLabel mushroom_quan;
    private JLabel beet_quan;
    private JLabel brocolli_quan;
    private JLabel cabbage_quan;
    private JLabel apple_quan;
    private JLabel orange_quan;
    private JLabel banana_quan;
    private JLabel cherry_quan;
    private JLabel chicken_quan;
    private JLabel fish_quan;
    private JLabel crab_quan;

    private JLabel spinach_exp;
    private JLabel cauliflower_exp;
    private JLabel mushroom_exp;
    private JLabel beet_exp;
    private JLabel brocolli_exp;
    private JLabel cabbage_exp;
    private JLabel apple_exp;
    private JLabel orange_exp;
    private JLabel banana_exp;
    private JLabel cherry_exp;
    private JLabel chicken_exp;
    private JLabel fish_exp;
    private JLabel crab_exp;

    private JLabel spinach_cost;
    private JLabel cauliflower_cost;
    private JLabel mushroom_cost;
    private JLabel beet_cost;
    private JLabel brocolli_cost;
    private JLabel cabbage_cost;
    private JLabel apple_cost;
    private JLabel oranges_cost;
    private JLabel banana_cost;
    private JLabel cherry_cost;
    private JLabel chicken_cost;
    private JLabel fish_cost;
    private JLabel crab_cost;

    private JTextField spinach_buy_quan;
    private JTextField cauliflower_buy_quan;
    private JTextField mushroom_buy_quan;
    private JTextField beet_buy_quan;
    private JTextField brocolli_buy_quan;
    private JTextField cabbage_buy_quan;
    private JTextField apple_buy_quan;
    private JTextField orange_buy_quan;
    private JTextField banana_buy_quan;
    private JTextField cherry_buy_quan;
    private JTextField chicken_buy_quan;
    private JTextField fish_buy_quan;
    private JTextField crab_buy_quan;

    private JButton Checkout; 
    private JButton back; 
    private JButton reset;

    static market_database_handling mdh = new market_database_handling();

    String name;
    int cost;
    int exp;
    int quan;
    int y_coor;
    
    public void form(){
        

        setTitle("Market"); 
        setBounds(100, 100, 1000, 850);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 

        title = new JLabel("Market"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(500, 30); 
        title.setLocation(450, 30); 
        c.add(title);

        tab_name = new JLabel("NAME"); 
        tab_name.setFont(new Font("Arial", Font.BOLD, 15)); 
        tab_name.setSize(100, 30); 
        tab_name.setLocation(50, 100); 
        c.add(tab_name);

        tab_quan = new JLabel("QUANTITY"); 
        tab_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        tab_quan.setSize(100, 30); 
        tab_quan.setLocation(200, 100); 
        c.add(tab_quan);

        tab_cost = new JLabel("COST"); 
        tab_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        tab_cost.setSize(200, 30); 
        tab_cost.setLocation(350, 100); 
        c.add(tab_cost);

        tab_exp = new JLabel("EXPIRES IN"); 
        tab_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        tab_exp.setSize(100, 30); 
        tab_exp.setLocation(500, 100); 
        c.add(tab_exp);

        tab_buy_amt = new JLabel("BUY"); 
        tab_buy_amt.setFont(new Font("Arial", Font.BOLD, 15)); 
        tab_buy_amt.setSize(100, 30); 
        tab_buy_amt.setLocation(700, 100); 
        c.add(tab_buy_amt);

        name = "Spinach";
        y_coor = 150;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        spinach = new JLabel(name);
        spinach.setFont(new Font("Arial", Font.BOLD, 15)); 
        spinach.setSize(100, 30); 
        spinach.setLocation(50, y_coor); 
        c.add(spinach);
        spinach_quan = new JLabel(String.valueOf(quan));
        spinach_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        spinach_quan.setSize(100, 30); 
        spinach_quan.setLocation(200, y_coor); 
        c.add(spinach_quan);
        spinach_cost = new JLabel(String.valueOf(cost));
        spinach_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        spinach_cost.setSize(100, 30); 
        spinach_cost.setLocation(350, y_coor); 
        c.add(spinach_cost);
        spinach_exp = new JLabel(String.valueOf(exp));
        spinach_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        spinach_exp.setSize(100, 30); 
        spinach_exp.setLocation(500, y_coor); 
        c.add(spinach_exp);

        name = "Cauli-flower";
        y_coor = 180;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        cauliflower = new JLabel(name);
        cauliflower.setFont(new Font("Arial", Font.BOLD, 15)); 
        cauliflower.setSize(100, 30); 
        cauliflower.setLocation(50, y_coor); 
        c.add(cauliflower);
        cauliflower_quan = new JLabel(String.valueOf(quan));
        cauliflower_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        cauliflower_quan.setSize(100, 30); 
        cauliflower_quan.setLocation(200, y_coor); 
        c.add(cauliflower_quan);
        cauliflower_cost = new JLabel(String.valueOf(cost));
        cauliflower_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        cauliflower_cost.setSize(100, 30); 
        cauliflower_cost.setLocation(350, y_coor); 
        c.add(cauliflower_cost);
        cauliflower_exp = new JLabel(String.valueOf(exp));
        cauliflower_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        cauliflower_exp.setSize(100, 30); 
        cauliflower_exp.setLocation(500, y_coor); 
        c.add(cauliflower_exp);

        name = "Mushrooms";
        y_coor = 210;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        mushroom = new JLabel(name);
        mushroom.setFont(new Font("Arial", Font.BOLD, 15)); 
        mushroom.setSize(100, 30); 
        mushroom.setLocation(50, y_coor); 
        c.add(mushroom);
        mushroom_quan = new JLabel(String.valueOf(quan));
        mushroom_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        mushroom_quan.setSize(100, 30); 
        mushroom_quan.setLocation(200, y_coor); 
        c.add(mushroom_quan);
        mushroom_cost = new JLabel(String.valueOf(cost));
        mushroom_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        mushroom_cost.setSize(100, 30); 
        mushroom_cost.setLocation(350, y_coor); 
        c.add(mushroom_cost);
        mushroom_exp = new JLabel(String.valueOf(exp));
        mushroom_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        mushroom_exp.setSize(100, 30); 
        mushroom_exp.setLocation(500, y_coor); 
        c.add(mushroom_exp);

        name = "Beet";
        y_coor = 240;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        beet = new JLabel(name);
        beet.setFont(new Font("Arial", Font.BOLD, 15)); 
        beet.setSize(100, 30); 
        beet.setLocation(50, y_coor); 
        c.add(beet);
        beet_quan = new JLabel(String.valueOf(quan));
        beet_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        beet_quan.setSize(100, 30); 
        beet_quan.setLocation(200, y_coor); 
        c.add(beet_quan);
        beet_cost = new JLabel(String.valueOf(cost));
        beet_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        beet_cost.setSize(100, 30); 
        beet_cost.setLocation(350, y_coor); 
        c.add(beet_cost);
        beet_exp = new JLabel(String.valueOf(exp));
        beet_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        beet_exp.setSize(100, 30); 
        beet_exp.setLocation(500, y_coor); 
        c.add(beet_exp);

        name = "Brocolli";
        y_coor = 270;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        brocolli = new JLabel(name);
        brocolli.setFont(new Font("Arial", Font.BOLD, 15)); 
        brocolli.setSize(100, 30); 
        brocolli.setLocation(50, y_coor); 
        c.add(brocolli);
        brocolli_quan = new JLabel(String.valueOf(quan));
        brocolli_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        brocolli_quan.setSize(100, 30); 
        brocolli_quan.setLocation(200, y_coor); 
        c.add(brocolli_quan);
        brocolli_cost = new JLabel(String.valueOf(cost));
        brocolli_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        brocolli_cost.setSize(100, 30); 
        brocolli_cost.setLocation(350, y_coor); 
        c.add(brocolli_cost);
        brocolli_exp = new JLabel(String.valueOf(exp));
        brocolli_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        brocolli_exp.setSize(100, 30); 
        brocolli_exp.setLocation(500, y_coor); 
        c.add(brocolli_exp);

        name = "Cabbage";
        y_coor = 300;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        cabbage = new JLabel(name);
        cabbage.setFont(new Font("Arial", Font.BOLD, 15)); 
        cabbage.setSize(100, 30); 
        cabbage.setLocation(50, y_coor); 
        c.add(cabbage);
        cabbage_quan = new JLabel(String.valueOf(quan));
        cabbage_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        cabbage_quan.setSize(100, 30); 
        cabbage_quan.setLocation(200, y_coor); 
        c.add(cabbage_quan);
        cabbage_cost = new JLabel(String.valueOf(cost));
        cabbage_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        cabbage_cost.setSize(100, 30); 
        cabbage_cost.setLocation(350, y_coor); 
        c.add(cabbage_cost);
        cabbage_exp = new JLabel(String.valueOf(exp));
        cabbage_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        cabbage_exp.setSize(100, 30); 
        cabbage_exp.setLocation(500, y_coor); 
        c.add(cabbage_exp);

        name = "Apple";
        y_coor = 330;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        apple = new JLabel(name);
        apple.setFont(new Font("Arial", Font.BOLD, 15)); 
        apple.setSize(100, 30); 
        apple.setLocation(50, y_coor); 
        c.add(apple);
        apple_quan = new JLabel(String.valueOf(quan));
        apple_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        apple_quan.setSize(100, 30); 
        apple_quan.setLocation(200, y_coor); 
        c.add(apple_quan);
        apple_cost = new JLabel(String.valueOf(cost));
        apple_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        apple_cost.setSize(100, 30); 
        apple_cost.setLocation(350, y_coor); 
        c.add(apple_cost);
        apple_exp = new JLabel(String.valueOf(exp));
        apple_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        apple_exp.setSize(100, 30); 
        apple_exp.setLocation(500, y_coor); 
        c.add(apple_exp);

        name = "Orange";
        y_coor = 360;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        orange = new JLabel(name);
        orange.setFont(new Font("Arial", Font.BOLD, 15)); 
        orange.setSize(100, 30); 
        orange.setLocation(50, y_coor); 
        c.add(orange);
        orange_quan = new JLabel(String.valueOf(quan));
        orange_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        orange_quan.setSize(100, 30); 
        orange_quan.setLocation(200, y_coor); 
        c.add(orange_quan);
        oranges_cost = new JLabel(String.valueOf(cost));
        oranges_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        oranges_cost.setSize(100, 30); 
        oranges_cost.setLocation(350, y_coor); 
        c.add(oranges_cost);
        orange_exp = new JLabel(String.valueOf(exp));
        orange_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        orange_exp.setSize(100, 30); 
        orange_exp.setLocation(500, y_coor); 
        c.add(orange_exp);

        name = "Bananas";
        y_coor = 390;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        banana = new JLabel(name);
        banana.setFont(new Font("Arial", Font.BOLD, 15)); 
        banana.setSize(100, 30); 
        banana.setLocation(50, y_coor); 
        c.add(banana);
        banana_quan = new JLabel(String.valueOf(quan));
        banana_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        banana_quan.setSize(100, 30); 
        banana_quan.setLocation(200, y_coor); 
        c.add(banana_quan);
        banana_cost = new JLabel(String.valueOf(cost));
        banana_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        banana_cost.setSize(100, 30); 
        banana_cost.setLocation(350, y_coor); 
        c.add(banana_cost);
        banana_exp = new JLabel(String.valueOf(exp));
        banana_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        banana_exp.setSize(100, 30); 
        banana_exp.setLocation(500, y_coor); 
        c.add(banana_exp);

        name = "Cherries";
        y_coor = 420;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        cherry = new JLabel(name);
        cherry.setFont(new Font("Arial", Font.BOLD, 15)); 
        cherry.setSize(100, 30); 
        cherry.setLocation(50, y_coor); 
        c.add(cherry);
        cherry_quan = new JLabel(String.valueOf(quan));
        cherry_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        cherry_quan.setSize(100, 30); 
        cherry_quan.setLocation(200, y_coor); 
        c.add(cherry_quan);
        cherry_cost = new JLabel(String.valueOf(cost));
        cherry_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        cherry_cost.setSize(100, 30); 
        cherry_cost.setLocation(350, y_coor); 
        c.add(cherry_cost);
        cherry_exp = new JLabel(String.valueOf(exp));
        cherry_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        cherry_exp.setSize(100, 30); 
        cherry_exp.setLocation(500, y_coor); 
        c.add(cherry_exp);

        name = "Chicken";
        y_coor = 450;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        chicken = new JLabel(name);
        chicken.setFont(new Font("Arial", Font.BOLD, 15)); 
        chicken.setSize(100, 30); 
        chicken.setLocation(50, y_coor); 
        c.add(chicken);
        chicken_quan = new JLabel(String.valueOf(quan));
        chicken_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        chicken_quan.setSize(100, 30); 
        chicken_quan.setLocation(200, y_coor); 
        c.add(chicken_quan);
        chicken_cost = new JLabel(String.valueOf(cost));
        chicken_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        chicken_cost.setSize(100, 30); 
        chicken_cost.setLocation(350, y_coor); 
        c.add(chicken_cost);
        chicken_exp = new JLabel(String.valueOf(exp));
        chicken_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        chicken_exp.setSize(100, 30); 
        chicken_exp.setLocation(500, y_coor); 
        c.add(chicken_exp);

        name = "Fish";
        y_coor = 480;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        fish = new JLabel(name);
        fish.setFont(new Font("Arial", Font.BOLD, 15)); 
        fish.setSize(100, 30); 
        fish.setLocation(50, y_coor); 
        c.add(fish);
        fish_quan = new JLabel(String.valueOf(quan));
        fish_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        fish_quan.setSize(100, 30); 
        fish_quan.setLocation(200, y_coor); 
        c.add(fish_quan);
        fish_cost = new JLabel(String.valueOf(cost));
        fish_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        fish_cost.setSize(100, 30); 
        fish_cost.setLocation(350, y_coor); 
        c.add(fish_cost);
        fish_exp = new JLabel(String.valueOf(exp));
        fish_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        fish_exp.setSize(100, 30); 
        fish_exp.setLocation(500, y_coor); 
        c.add(fish_exp);

        name = "Crabs";
        y_coor = 510;
        cost = mdh.get_cost(name);
        exp = mdh.get_expiry(name);
        quan = mdh.get_quantity(name);
        crab = new JLabel(name);
        crab.setFont(new Font("Arial", Font.BOLD, 15)); 
        crab.setSize(100, 30); 
        crab.setLocation(50, y_coor); 
        c.add(crab);
        crab_quan = new JLabel(String.valueOf(quan));
        crab_quan.setFont(new Font("Arial", Font.BOLD, 15)); 
        crab_quan.setSize(100, 30); 
        crab_quan.setLocation(200, y_coor); 
        c.add(crab_quan);
        crab_cost = new JLabel(String.valueOf(cost));
        crab_cost.setFont(new Font("Arial", Font.BOLD, 15)); 
        crab_cost.setSize(100, 30); 
        crab_cost.setLocation(350, y_coor); 
        c.add(crab_cost);
        crab_exp = new JLabel(String.valueOf(exp));
        crab_exp.setFont(new Font("Arial", Font.BOLD, 15)); 
        crab_exp.setSize(100, 30); 
        crab_exp.setLocation(500, y_coor); 
        c.add(crab_exp);

        //////TEXT FIELDS
        y_coor = 150;
        spinach_buy_quan = new JTextField("0"); 
        spinach_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        spinach_buy_quan.setSize(50, 30); 
        spinach_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(spinach_buy_quan);

        cauliflower_buy_quan = new JTextField("0"); 
        cauliflower_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cauliflower_buy_quan.setSize(50, 30); 
        cauliflower_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(cauliflower_buy_quan);

        mushroom_buy_quan = new JTextField("0"); 
        mushroom_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        mushroom_buy_quan.setSize(50, 30); 
        mushroom_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(mushroom_buy_quan);

        beet_buy_quan = new JTextField("0"); 
        beet_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        beet_buy_quan.setSize(50, 30); 
        beet_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(beet_buy_quan);

        brocolli_buy_quan = new JTextField("0"); 
        brocolli_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        brocolli_buy_quan.setSize(50, 30); 
        brocolli_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(brocolli_buy_quan);

        cabbage_buy_quan = new JTextField("0"); 
        cabbage_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cabbage_buy_quan.setSize(50, 30); 
        cabbage_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(cabbage_buy_quan);

        apple_buy_quan = new JTextField("0"); 
        apple_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        apple_buy_quan.setSize(50, 30); 
        apple_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(apple_buy_quan);

        orange_buy_quan = new JTextField("0"); 
        orange_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        orange_buy_quan.setSize(50, 30); 
        orange_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(orange_buy_quan);

        banana_buy_quan = new JTextField("0"); 
        banana_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        banana_buy_quan.setSize(50, 30); 
        banana_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(banana_buy_quan);

        cherry_buy_quan = new JTextField("0"); 
        cherry_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cherry_buy_quan.setSize(50, 30); 
        cherry_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(cherry_buy_quan);

        chicken_buy_quan = new JTextField("0"); 
        chicken_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        chicken_buy_quan.setSize(50, 30); 
        chicken_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(chicken_buy_quan);

        fish_buy_quan = new JTextField("0"); 
        fish_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        fish_buy_quan.setSize(50, 30); 
        fish_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(fish_buy_quan);

        crab_buy_quan = new JTextField("0"); 
        crab_buy_quan.setFont(new Font("Arial", Font.PLAIN, 15)); 
        crab_buy_quan.setSize(50, 30); 
        crab_buy_quan.setLocation(700, y_coor); 
        y_coor = y_coor + 30;
        c.add(crab_buy_quan);

        //////BUTTONS
        
        back = new JButton("Back"); 
        back.setFont(new Font("Arial", Font.PLAIN, 20)); 
        back.setSize(150, 40); 
        back.setLocation(250, 750); 
        back.addActionListener(this); 
        c.add(back);

        Checkout = new JButton("Checkout"); 
        Checkout.setFont(new Font("Arial", Font.PLAIN, 20)); 
        Checkout.setSize(150, 40); 
        Checkout.setLocation(450, 750); 
        Checkout.addActionListener(this); 
        c.add(Checkout); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 20)); 
        reset.setSize(150, 40); 
        reset.setLocation(650, 750); 
        reset.addActionListener(this); 
        c.add(reset); 

        res = new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(500, 25); 
        res.setLocation(100, 600); 
        c.add(res);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        home_page home = new home_page();
        thankyou_screen ty = new thankyou_screen();

        if (e.getSource() == Checkout) {
            int quan;
            int total_cost=0;
            quan = Integer.parseInt(spinach_buy_quan.getText());
            total_cost += mdh.buy_item("Spinach", quan);
            quan = Integer.parseInt(cauliflower_buy_quan.getText());
            total_cost += mdh.buy_item("Cauli-flower", quan);
            quan = Integer.parseInt(mushroom_buy_quan.getText());
            total_cost += mdh.buy_item("Mushrooms", quan);
            quan = Integer.parseInt(beet_buy_quan.getText());
            total_cost += mdh.buy_item("Beet", quan);
            quan = Integer.parseInt(brocolli_buy_quan.getText());
            total_cost += mdh.buy_item("Brocolli", quan);
            quan = Integer.parseInt(cabbage_buy_quan.getText());
            total_cost += mdh.buy_item("Cabbage", quan);
            quan = Integer.parseInt(apple_buy_quan.getText());
            total_cost += mdh.buy_item("Apple", quan);
            quan = Integer.parseInt(orange_buy_quan.getText());
            total_cost += mdh.buy_item("Orange", quan);
            quan = Integer.parseInt(banana_buy_quan.getText());
            total_cost += mdh.buy_item("Bananas", quan);
            quan = Integer.parseInt(cherry_buy_quan.getText());
            total_cost += mdh.buy_item("Cherries", quan);
            quan = Integer.parseInt(chicken_buy_quan.getText());
            total_cost += mdh.buy_item("Chicken", quan);
            quan = Integer.parseInt(fish_buy_quan.getText());
            total_cost += mdh.buy_item("Fish", quan);
            quan = Integer.parseInt(crab_buy_quan.getText());
            total_cost += mdh.buy_item("Crabs", quan);
            System.out.print(total_cost);
            if(res.getText()!=""){
                ty.form();
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
            else{
                String bill = "COST :"+total_cost;
                res.setText(bill);
            }
        }
        else if (e.getSource() == back){
            
            home.form();
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        else if (e.getSource() == reset){
            String def = "0"; 
            spinach_buy_quan.setText(def); 
            cauliflower_buy_quan.setText(def);
            mushroom_buy_quan.setText(def);
            beet_buy_quan.setText(def);
            brocolli_buy_quan.setText(def);
            cabbage_buy_quan.setText(def);
            apple_buy_quan.setText(def);
            orange_buy_quan.setText(def);
            banana_buy_quan.setText(def);
            cherry_buy_quan.setText(def);
            chicken_buy_quan.setText(def);
            fish_buy_quan.setText(def);
            crab_buy_quan.setText(def);
        }
    }

    public static void main(String[] args) throws Exception 
    { 
        market_form F = new market_form();
        F.form();
    } 
}