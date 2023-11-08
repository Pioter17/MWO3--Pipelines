package mwo.shop.repositories;

import mwo.shop.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    // Możesz dodać niestandardowe zapytania w tym miejscu, jeśli to konieczne
}