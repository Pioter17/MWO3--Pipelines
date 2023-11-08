package mwo.shop.services;

import jakarta.persistence.EntityNotFoundException;
import mwo.shop.models.Product;
import mwo.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        if (product == null){
            throw new NullPointerException("Product cannot be null");
        }
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new EntityNotFoundException("Product with ID " + productId + " not found");
        }
        productRepository.deleteById(productId);
    }

    public Product updateProduct(Product product) {
        if (!productRepository.existsById(product.getId())) {
            throw new EntityNotFoundException("Product with ID " + product.getId() + " not found");
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
