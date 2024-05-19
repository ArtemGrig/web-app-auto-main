package webapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import webapp.models.Client;
import webapp.repository.InMemoryClientDAO;
import webapp.service.ClientService;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryClientServiceImpl implements ClientService {
    private final InMemoryClientDAO repository;

    @Override
    public List<Client> findAllClients(){
        return repository.findAllClients();
    }

    @Override
    public Client saveClient(Client client) {
        return repository.saveClient(client);
    }

    @Override
    public Client findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Client updateClient(Client client) {
        return repository.updateClient(client);
    }

    @Override
    public void deleteClient(String email) {
        repository.deleteClient(email);
    }
}
