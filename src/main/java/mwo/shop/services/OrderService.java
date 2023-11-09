package mwo.shop.services;

import jakarta.persistence.EntityNotFoundException;
import mwo.shop.enums.OrderStatus;
import mwo.shop.models.Client;
import mwo.shop.models.Order;
import mwo.shop.models.OrderItem;
import mwo.shop.models.Product;
import mwo.shop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;

    public Order createOrder(Order order) {
        // Sprawdzamy, czy klient istnieje
        Client client = clientService.getClientById(order.getClientId());
        if (client == null) {
            throw new EntityNotFoundException("Client with ID " + order.getClientId() + " not found");
        }

        for (OrderItem item : order.getItems()) {
            Product product = productService.getProductById(item.getProductId());
            if (product == null || product.getStockQuantity() < item.getQuantity()) {
                throw new IllegalArgumentException("Product not available in stock.");
            }
            // Aktualizujemy ilość produktu w magazynie
            productService.updateStockQuantity(product, -item.getQuantity());
        }
        order.setStatus(OrderStatus.NEW);
        return orderRepository.save(order);
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElse(null);
    }

    public Order updateOrder(Order updatedOrder) {
        // Sprawdzamy, czy zamówienie istnieje
        Order existingOrder = orderRepository.findById(updatedOrder.getId())
                .orElseThrow(() -> new EntityNotFoundException("Order with ID " + updatedOrder.getId() + " not found"));

        existingOrder.setItems(updatedOrder.getItems());

        return orderRepository.save(existingOrder);
    }

    public void updateOrderStatus(Long orderId, OrderStatus newStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order with ID " + orderId + " not found"));
        order.setStatus(newStatus);
        orderRepository.save(order);
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order with ID " + orderId + " not found"));
        for (OrderItem item : order.getItems()) {
            Product product = productService.getProductById(item.getProductId());
            // Zwracamy produkty na magazyn
            productService.updateStockQuantity(product, item.getQuantity());
        }
        orderRepository.deleteById(orderId);
    }

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }
}

