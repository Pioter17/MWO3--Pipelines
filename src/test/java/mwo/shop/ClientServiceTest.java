package mwo.shop;
import mwo.shop.models.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ClientServiceTest {

    @Test
    public void testgetsth() {
        Client client = new Client("imie", "n", 25);
        int age = client.getAge();
        AssertEquals(25, age);
    }
}
