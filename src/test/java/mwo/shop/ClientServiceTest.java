package mwo.shop;
import mwo.shop.models.Client;
import mwo.shop.repositories.ClientRepository;
import mwo.shop.services.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Test
    public void testCreateClient() {
        Client client = new Client(1L, "John", "Doe", "john@example.com");
        Mockito.when(clientRepository.save(Mockito.any(Client.class))).thenReturn(client);

        Client createdClient = clientService.addClient(new Client("John", "Doe", "john@example.com"));

        Assertions.assertEquals("John", createdClient.getName());
    }

    @Test
    public void testReadClient() {
        Client client = new Client(1L, "John", "Doe", "john@example.com");
        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Client foundClient = clientService.getClientById(1L);

        Assertions.assertEquals("John", foundClient.getName());
    }

    @Test
    public void testUpdateClient() {
        Client client = new Client(1L, "John", "Doe", "john@example.com");
        Mockito.when(clientRepository.existsById(1L)).thenReturn(true);
        Mockito.when(clientRepository.save(Mockito.any(Client.class))).thenReturn(client);

        Client updatedClient = clientService.updateClient(new Client(1L, "Jane", "Doe", "jane@example.com"));

        Assertions.assertEquals("Jane", updatedClient.getName());
    }

    @Test
    public void testDeleteClient() {
        Mockito.when(clientRepository.existsById(1L)).thenReturn(true);

        clientService.deleteClient(1L);

        Mockito.verify(clientRepository, Mockito.times(1)).deleteById(1L);
    }
}
