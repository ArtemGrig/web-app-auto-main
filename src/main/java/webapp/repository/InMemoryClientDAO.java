package webapp.repository;

import org.springframework.stereotype.Repository;
import webapp.models.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryClientDAO {
    private final List<Client> CLIENTS = new ArrayList<>();

    public List<Client> findAllClients(){
        return CLIENTS;
    }

    public Client saveClient(Client client) {
        CLIENTS.add(client);
        return client;
    }

    public Client findByEmail(String email) {
        return CLIENTS.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Client updateClient(Client client) {
        var clientIndax = IntStream.range(0,CLIENTS.size())
                .filter(index -> CLIENTS.get(index).getEmail().equals(client.getEmail()))
                .findFirst()
                .orElse(-1);
        if (clientIndax > -1){
            CLIENTS.set(clientIndax, client);
            return client;
        }
        return null;
    }

    public void deleteClient(String email) {
        var client = findByEmail(email);
        if (client != null){
            CLIENTS.remove(client);
        }
    }
}
