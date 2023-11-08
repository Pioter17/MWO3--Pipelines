package mwo.shop.services;

import jakarta.persistence.EntityNotFoundException;
import mwo.shop.models.Order;
import mwo.shop.models.Product;
import mwo.shop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    public Order createOrder(Order order) {
        for (OrderItem item : order.getItems()) {
            Product product = productService.getProductById(item.getProductId());
            if (product == null || product.getStockQuantity() < item.getQuantity()) {
                throw new IllegalArgumentException("Product not available in stock.");
            }
        }
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new EntityNotFoundException("Order with ID " + orderId + " not found");
        }
        orderRepository.deleteById(orderId);
    }

    public Order updateOrder(Order order) {
        if (!orderRepository.existsById(order.getId())) {
            throw new EntityNotFoundException("Order with ID " + order.getId() + " not found");
        }
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }
}
