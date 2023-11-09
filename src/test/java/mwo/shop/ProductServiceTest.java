package mwo.shop;
import mwo.shop.models.Product;
import mwo.shop.repositories.ProductRepository;
import mwo.shop.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testCreateProduct() {
        Product product = new Product(1L, "Product 1", 10.0, 50);
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        Product createdProduct = productService.addProduct(new Product("Product 1", 10.0, 50));

        Assertions.assertEquals("Product 1", createdProduct.getName());
    }

    @Test
    public void testReadProduct() {
        Product product = new Product(1L, "Product 1", 10.0, 50);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product foundProduct = productService.getProductById(1L);

        Assertions.assertEquals("Product 1", foundProduct.getName());
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product(1L, "Product 1", 10.0, 50);
        Mockito.when(productRepository.existsById(1L)).thenReturn(true);
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        Product updatedProduct = productService.updateProduct(new Product(1L, "Product 2", 15.0, 30));

        Assertions.assertEquals("Product 2", updatedProduct.getName());
    }

    @Test
    public void testDeleteProduct() {
        Mockito.when(productRepository.existsById(1L)).thenReturn(true);

        productService.deleteProduct(1L);

        Mockito.verify(productRepository, Mockito.times(1)).deleteById(1L);
    }
}

