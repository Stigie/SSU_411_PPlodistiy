import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Stig on 22.01.2016.
 */
public class Korzina implements Basket {
    HashMap<String, Integer> products = new HashMap<String, Integer>();

    @Override
    public void addProduct(String product, int quantity) {
        products.put(product, quantity);
    }

    @Override
    public void removeProduct(String product) {
        products.remove(product);
    }

    @Override
    public void udateProductQuantity(String product, int quantity) {
        products.put(product, quantity);
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        List<String> q = new LinkedList<String>();
        for (String key : products.keySet()) {
            q.add(key);
            //System.out.println("Key: " + key);
        }
        return q;
    }

    @Override
    public int getProductQuantity(String product) {
        return products.get(product).intValue();

    }
}
