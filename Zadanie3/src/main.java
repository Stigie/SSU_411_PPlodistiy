import java.util.LinkedList;
import java.util.List;

/**
 * Created by Stig on 22.01.2016.
 */
public  class main {

    public static void main(String[] args) throws Exception{

        Korzina k = new Korzina();
        k.addProduct("Vanna", 2);
        k.addProduct("Car", 3);
        k.removeProduct("Car");
        k.udateProductQuantity("Vanna",10);
        k.clear();
        k.addProduct("Vanna", 2);
        k.addProduct("Car", 3);
        List<String> q = new LinkedList<String>();
        q=k.getProducts();
        System.out.println(q.toString());
        k.getProductQuantity("Car");
        //return k;
    }
}
