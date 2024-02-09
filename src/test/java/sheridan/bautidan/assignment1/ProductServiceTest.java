package sheridan.bautidan.assignment1;

import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    @Test
    void testAddAndDeleteProduct() {
        ProductService service = new ProductService();
        service.addProduct("Test Product", 10.0);
        assertEquals(1, service.getAllProducts().size());

        Product product = service.getAllProducts().iterator().next();
        service.deleteProduct(product.getId());
        assertTrue(service.getAllProducts().isEmpty());
    }
}
