import java.util.*;  

public class HM_count {

    private HashMap<Integer,Integer> mp=new HashMap<Integer,Integer>();

    HM_count(){
        // Inventory before user purchase/restock

        //VEGETABLES;
        mp.put(1, 4);//Spinach
        mp.put(2, 5 );//Cauli-flower
        mp.put(3, 20);//Mushrooms
        mp.put(4, 5);//Beet
        mp.put(5, 0);//Brocolli
        mp.put(6, 3);//Cabbage

        //FRUITS
        mp.put(7, 10);//Apple
        mp.put(8, 7);//Orange
        mp.put(9, 20);//Bananas
        mp.put(10, 20);//Cherries
        
        //MEAT
        mp.put(11, 1);//Chicken
        mp.put(12, 5);//Fish
        mp.put(13, 10);//Crabs
    }

    public boolean buy(Integer item_key, Integer item_bought_count){
        if(mp.get(item_key)>=item_bought_count){
            mp.put(item_key, mp.get(item_key) - item_bought_count);
            return true;
        }
        return false;
    }

    public Integer get_count(Integer item_key){
        return mp.get(item_key);
    }

    public void _set_(Integer item_key, Integer count){
        mp.put(item_key, count);
    }//for re-stocking

    public void set_0(Integer item_key){
        mp.put(item_key, 0);
    }//for when food get expired

}