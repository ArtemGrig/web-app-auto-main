package webapp.service;

import org.springframework.stereotype.Service;
import webapp.models.Client;

import java.util.List;


public interface ClientService {
    List<Client> findAllClients();
    Client saveClient(Client client);
    Client findByEmail(String email);
    Client updateClient(Client client);
    void deleteClient(String email);
}
