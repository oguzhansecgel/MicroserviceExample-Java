package com.javaexample.ProductService.Controller;

import com.javaexample.ProductService.Entity.Product;
import com.javaexample.ProductService.Service.Abstracts.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findAll")
    public List<Product> findAll() {

        return productService.getAllProduct();
    }
    @GetMapping("/getByIdProduct/{id}")
    public Optional<Product> getByIdProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }
    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}
