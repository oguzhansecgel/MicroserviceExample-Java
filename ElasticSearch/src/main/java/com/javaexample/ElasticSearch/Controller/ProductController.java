package com.javaexample.ElasticSearch.Controller;

import com.javaexample.ElasticSearch.Document.Product;
import com.javaexample.ElasticSearch.Service.Abstracts.ProductService;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/productPriceBetween")
    public List<Product> getProductPriceBetween(@RequestParam int lower, @RequestParam int upper)
    {
        return productService.productPriceBetween(lower,upper);
    }

    @GetMapping("/findAll")
    public Iterable<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }
    @GetMapping("/findByProductName")
    public List<Product> findByProductName(@RequestParam String productName)
    {
        return productService.findByProductNameContaining(productName);
    }

}
