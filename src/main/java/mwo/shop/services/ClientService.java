package mwo.shop.services;

import mwo.shop.models.Client;
import mwo.shop.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return (List<Client>) clientRepository.findAll();
    }
}
