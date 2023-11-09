package mwo.shop;

import junit.framework.Assert;
import mwo.shop.enums.OrderStatus;
import mwo.shop.models.Client;
import mwo.shop.models.Order;
import mwo.shop.models.OrderItem;
import mwo.shop.models.Product;
import mwo.shop.repositories.OrderRepository;
import mwo.shop.services.ClientService;
import mwo.shop.services.OrderService;
import mwo.shop.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductService productService;

    @Mock
    private ClientService clientService;

    @Test
    public void testCreateOrder() {
        Client client = new Client(1L, "John", "Doe", "john@example.com");
        Product product = new Product(1L, "Product 1", 10.0, 50);
        Mockito.when(clientService.getClientById(1L)).thenReturn(client);
        Mockito.when(productService.getProductById(1L)).thenReturn(product);

        OrderItem orderItem = new OrderItem(1L, 1);
        Order order = new Order(1L, Collections.singletonList(orderItem));

        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);

        Assertions.assertEquals(OrderStatus.NEW, createdOrder.getStatus());
    }

    @Test
    public void testReadOrder() {
        Order order = new Order(1L, Collections.emptyList());
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order foundOrder = orderService.getOrderById(1L);

        // Dodaj asercje
    }

    @Test
    public void testUpdateOrder() {
        Order order = new Order(1L, Collections.emptyList());
        Mockito.when(orderRepository.existsById(1L)).thenReturn(true);
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(order);

        Order updatedOrder = orderService.updateOrder(order);

        // Dodaj asercje
    }

    @Test
    public void testDeleteOrder() {
        Mockito.when(orderRepository.existsById(1L)).thenReturn(true);

        orderService.cancelOrder(1L);

        Mockito.verify(orderRepository, Mockito.times(1)).deleteById(1L);
    }
}


//@RunWith(MockitoJUnitRunner.class)
//public class OrderServiceTest {
//
//    @InjectMocks
//    private OrderService orderService;
//    @Mock
//    private OrderRepository orderRepository;
//    @Mock
//    private ProductService productService;
//    @Mock
//    private ClientService clientService;
//
//    @Test
//    public void testCreateOrder_PositiveScenario() {
//        Client client = new Client(1L, "John", "Doe", "john@example.com");
//        Product product = new Product(1L, "Product 1", 10.0, 50);
//        when(clientService.getClientById(1L)).thenReturn(client);
//        when(productService.getProductById(1L)).thenReturn(product);
//
//        OrderItem orderItem = new OrderItem(1L, 1);
//        List<OrderItem> items = Collections.singletonList(orderItem);
//        Order order = new Order(1L, items);
//
//        when(orderRepository.save(any())).thenReturn(order);
//
//        Order createdOrder = orderService.createOrder(order);
//
//        assertNotNull(createdOrder);
//        Assert.assertEquals(OrderStatus.NEW, createdOrder.getStatus());
//    }
//
//    @Test
//    public void testCreateOrder_ProductNotAvailable() {
//        Client client = new Client(1L, "John", "Doe", "john@example.com");
//        Product product = new Product(1L, "Product 1", 10.0, 5); // Not enough stock
//        when(clientService.getClientById(1L)).thenReturn(client);
//        when(productService.getProductById(1L)).thenReturn(product);
//
//        OrderItem orderItem = new OrderItem(1L, 10); // Trying to order 10, but only 5 available
//        List<OrderItem> items = Collections.singletonList(orderItem);
//        Order order = new Order(1L, items);
//
//        orderService.createOrder(order);
//        assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(order));
//    }
//
//    @Test
//    public void testUpdateOrderStatus() {
//        Order order = new Order(1L, Collections.emptyList());
//        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
//
//        orderService.updateOrderStatus(1L, OrderStatus.IN_PROGRESS);
//
//        Assert.assertEquals(OrderStatus.IN_PROGRESS, order.getStatus());
//    }
//
//    @Test
//    public void testCancelOrder() {
//        Product product = new Product(1L, "Product 1", 10.0, 10);
//        OrderItem orderItem = new OrderItem(1L, 5);
//        List<OrderItem> items = Collections.singletonList(orderItem);
//        Order order = new Order(1L, items);
//
//        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
//        when(productService.getProductById(1L)).thenReturn(product);
//
//        orderService.cancelOrder(1L);
//
//        Assert.assertEquals(10, product.getStockQuantity());
//    }
//}
