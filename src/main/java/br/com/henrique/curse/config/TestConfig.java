package br.com.henrique.curse.config;

import br.com.henrique.curse.entities.*;
import br.com.henrique.curse.entities.enums.OrderStatus;
import br.com.henrique.curse.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Jacson", "jacsonr@uninove.br", "98888888", "jacsongay");
        User u2 = new User(null, "Marco", "marco@uninove.br", "97777777", "marcogay");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-06-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-06-22T15:21:21Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computer");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consecterur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor.", 1250.0, "");
        Product p4 = new Product(null, "Pc Gamer", "Pc gamer.", 6000.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Lorem ipsum dolor sit amet, consecterur.", 100.99, "");




        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        OrderItem oi1 = new OrderItem(2, p1.getPrice(), o1, p1);
        OrderItem oi2 = new OrderItem(1, p4.getPrice(), o1, p3);
        OrderItem oi3 = new OrderItem(2, p1.getPrice(), o2, p3);
        OrderItem oi4 = new OrderItem(2, p5.getPrice(), o3, p5);

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);
    }
}
