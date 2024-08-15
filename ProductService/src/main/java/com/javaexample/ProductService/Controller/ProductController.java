package com.javaexample.ProductService.Controller;

import com.javaexample.ProductService.Entity.Product;
import com.javaexample.ProductService.Service.Abstracts.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.getAllProduct(pageable);
    }
    @GetMapping("/getByIdProduct/{id}")
    public Optional<Product> getByIdProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }
    @GetMapping("/productStockCount/{id}")
    public Integer getProductStockCount(@PathVariable int id)
    {
        return productService.getProductStockCount(id);
    }
    @PutMapping("/decrementStock/{id}")
    public void decrementStock(@PathVariable int id)
    {
        productService.decrementStock(id);
    }
    @PostMapping("/createProduct")
    public Product createProduct(@Valid @RequestBody Product product) {
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
