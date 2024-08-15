package service;

import com.javaexample.ProductService.Entity.Product;
import com.javaexample.ProductService.Kafka.Producer.ElasticSearch;
import com.javaexample.ProductService.Repository.ProductRepository;
import com.javaexample.ProductService.Service.Concretes.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ElasticSearch elasticSearch;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void createProductSuccessful()
    {

        Product product = new Product();
        product.setId(1);
        product.setProductName("Test Product");
        product.setDescription("Test Description");
        product.setColor("Red");
        product.setProductPrice(100);
        product.setStock(10);

        when(productRepository.save(product)).thenReturn(product);

        Product createdProduct = productService.createProduct(product);

        assertNotNull(createdProduct);
        assertEquals(product.getId(), createdProduct.getId());
        assertEquals(product.getProductName(), createdProduct.getProductName());
        assertEquals(product.getDescription(), createdProduct.getDescription());
        assertEquals(product.getColor(), createdProduct.getColor());
        assertEquals(product.getProductPrice(), createdProduct.getProductPrice());
        assertEquals(product.getStock(), createdProduct.getStock());

        verify(productRepository, times(1)).save(product);
        verify(elasticSearch, times(1)).sendMessage(product);
    }

    @Test
    public void deleteProductSuccessful()
    {
        Product product = new Product();
        product.setId(6);

        // when tek başına dönüş tipi dönüren metotlar için kullanılır
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        // doNothing void döndüren metotlar için kullanılır
        doNothing().when(productRepository).deleteById(product.getId());

        productService.deleteProduct(product.getId());

        verify(productRepository,times(1)).deleteById(product.getId());

    }

    @Test
    public void updateProductSuccessful() {

        int productId = 4;
        Product existingProduct = new Product();
        existingProduct.setId(productId);
        existingProduct.setProductName("Old Product");
        existingProduct.setDescription("Old Description");
        existingProduct.setColor("Old Color");
        existingProduct.setProductPrice(50);
        existingProduct.setStock(5);

        Product updatedProduct = new Product();
        updatedProduct.setId(productId);
        updatedProduct.setProductName("Updated Product");
        updatedProduct.setDescription("Updated Description");
        updatedProduct.setColor("Updated Color");
        updatedProduct.setProductPrice(100);
        updatedProduct.setStock(10);

        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(productRepository.saveAndFlush(updatedProduct)).thenReturn(updatedProduct);


        Product result = productService.updateProduct(productId, updatedProduct);

        assertNotNull(result);
        assertEquals(productId, result.getId());
        assertEquals("Updated Product", result.getProductName());
        assertEquals("Updated Description", result.getDescription());
        assertEquals("Updated Color", result.getColor());
        assertEquals(100, result.getProductPrice());
        assertEquals(10, result.getStock());

        verify(productRepository, times(1)).findById(productId);
        verify(productRepository, times(1)).saveAndFlush(updatedProduct);

    }



}
