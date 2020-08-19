public class Admin_AUTH {
    private int key;

    Admin_AUTH(){
        key = 1234;
    }
    public boolean authenticate(int passkey){
        //System.out.println(key);
        //System.out.println(passkey);
        if(passkey == key)
            return true;
        else
            return false;
    }
}