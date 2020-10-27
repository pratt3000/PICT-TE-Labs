public class test {
    static market_database_handling mdh = new market_database_handling();
    public static void main(String[] args) throws Exception{
        //mdh.get_market_status();
        int p = mdh.get_quantity("Chicken");
        System.out.println(p);
    }
}
