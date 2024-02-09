package sheridan.bautidan.assignment1;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collection;

import java.util.List;
import java.util.ArrayList;
@Service
public class ProductService {
    private final ConcurrentHashMap<Long, Product> products = new ConcurrentHashMap<>();

    public Product getProductById(long id) {
        return products.get(id);
    }

    public void addProduct(String name, double price) {
        long id = generateId();
        Product product = new Product(id, name, price);
        products.put(id, product);
    }
    public void deleteProduct(long id) {
        products.remove(id);
    }

    private long generateId() {
        long id;
        do { // Generates random number between 100000000 and 999999999
            id = 100_000_000L + random.nextInt(900_000_000);
        } while (products.containsKey(id));
        return id;
    }
}
