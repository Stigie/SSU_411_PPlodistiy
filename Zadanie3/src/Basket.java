import java.util.List;

/**
 * Created by Stig on 22.01.2016.
 */
public interface Basket {
    void addProduct(String product, int quantity);
    void removeProduct(String product);
    void udateProductQuantity(String product, int quantity);
    void clear();
    List<String> getProducts();
    int getProductQuantity(String product);
}
