package sheridan.bautidan.assignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
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
