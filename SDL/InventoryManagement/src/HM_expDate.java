import java.util.*;  

public class HM_expDate {
    private Integer item_count=13;
    private HashMap<Integer,Integer> mp=new HashMap<Integer,Integer>();

    HM_expDate(){
        //ID , days until it expires

        mp.put(1, 2);//Spinach
        mp.put(2, 5 );//Cauli-flower
        mp.put(3, 7);//Mushrooms
        mp.put(4, 3);//Beet
        mp.put(5, 1);//Brocolli
        mp.put(6, 7);//Cabbage

        mp.put(7, 5);//Apple
        mp.put(8, 2);//Orange
        mp.put(9, 7);//Bananas
        mp.put(10, 11);//Cherries

        mp.put(11, 6);//Chicken
        mp.put(12, 5);//Fish
        mp.put(13, 3);//Crabs
    }

    public Integer get_expDate(Integer item_key){
        return mp.get(item_key);
    }

    public Boolean pass_day(){
        Boolean flag=false;
        for(Integer ct=1; ct<=item_count; ct++){
            if(mp.get(ct) != 0)
                mp.put(ct, mp.get(ct) - 1);
            if(mp.get(ct)==0){
                flag=true;
            }
        }
        return flag;
    }

    public void set_exp_date(){
        //FIXEDD 
        
        mp.put(1, 2);//Spinach
        mp.put(2, 5 );//Cauli-flower
        mp.put(3, 7);//Mushrooms
        mp.put(4, 3);//Beet
        mp.put(5, 1);//Brocolli
        mp.put(6, 7);//Cabbage

        mp.put(7, 5);//Apple
        mp.put(8, 2);//Orange
        mp.put(9, 7);//Bananas
        mp.put(10, 11);//Cherries

        mp.put(11, 6);//Chicken
        mp.put(12, 5);//Fish
        mp.put(13, 3);//Crabs
    }
}