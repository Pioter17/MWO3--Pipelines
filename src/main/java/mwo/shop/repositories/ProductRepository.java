package mwo.shop.repositories;

import mwo.shop.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    // Możesz dodać niestandardowe zapytania w tym miejscu, jeśli to konieczne
}