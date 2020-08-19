public class ARR_names {
    private Integer item_count = 13;
    private String items[] = new String[item_count];

    ARR_names(){
        items = new String[]{"Spinach",
                                "Cauli-flower",
                                "Mushrooms",
                                "Beet",
                                "Brocolli",
                                "Cabbage",
                                "Apple",
                                "Orange",
                                "Bananas",
                                "Cherries",
                                "Chicken",
                                "Fish",
                                "Crabs"
                                };//order must be maintained according to HM_count.java 
    }

    public String get_item_name(Integer i){
        return items[i];
    }

}