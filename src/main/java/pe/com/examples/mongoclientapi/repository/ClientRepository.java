package pe.com.examples.mongoclientapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.com.examples.mongoclientapi.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, String> {
    Optional<Client> findById(String id);
    List<Client> findByName(String name);
}
