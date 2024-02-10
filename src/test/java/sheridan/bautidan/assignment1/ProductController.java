package sheridan.bautidan.assignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping(path= "api/v1/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = new productService;
    }

    @GetMapping("/product")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String name, @RequestParam double price) {
        productService.addProduct(name, price);
        return "redirect:/product";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam long id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }

}
