package sheridan.bautidan.assignment1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping(path= "api/v1/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProducts()
    {
        return productService.getProducts();
    }
}
