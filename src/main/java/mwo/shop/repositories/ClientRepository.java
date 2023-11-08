package mwo.shop.repositories;

import mwo.shop.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    // Możesz dodać niestandardowe zapytania w tym miejscu, jeśli to konieczne
}
