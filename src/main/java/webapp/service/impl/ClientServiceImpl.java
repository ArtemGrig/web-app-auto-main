package webapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webapp.models.Client;
import webapp.repository.ClientRepository;
import webapp.service.ClientService;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    @Override
    public List<Client> findAllClients() {
        return repository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return repository.save(client);
    }

    @Override
    public Client findByEmail(String email) {
        return repository.findClientByEmail(email);
    }

    @Override
    public Client updateClient(Client client) {
        return repository.save(client);
    }

    @Override
    @Transactional
    public void deleteClient(String email) {
        repository.deleteByEmail(email);
    }
}
