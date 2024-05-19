package webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    void deleteByEmail(String email);
    Client findClientByEmail(String email);
}
