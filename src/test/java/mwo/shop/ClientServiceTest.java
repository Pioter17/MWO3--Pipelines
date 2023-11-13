package mwo.shop;
import mwo.shop.models.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

@SpringBootTest(classes = ShopApplication.class)
public class ClientServiceTest {

//    @Value("${application.version}")
    private String applicationVersion;

    @Test
    public void testgetsth() {
        // Wyświetl numer wersji pobrany z właściwości
        System.out.println("Aktualny numer wersji: " + applicationVersion);

        // Przykładowy test z klientem
        Client client = new Client("imie", "n", 25);
        int age = client.getAge();
        assertEquals(25, age);
    }
}
