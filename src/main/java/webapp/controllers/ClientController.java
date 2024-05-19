package webapp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import webapp.models.Client;
import webapp.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping
    public List<Client> findAllClients(){
        return service.findAllClients();
    }

    @PostMapping("save_client")
    public String saveClient(@RequestBody Client client){
        service.saveClient(client);
        return "Client successfully saved";
    }

    @GetMapping("/{email}")
    public Client findByEmail(@PathVariable("email") String email){
        return service.findByEmail(email);
    }

    @PutMapping("update_client")
    public Client updateClient(@RequestBody Client client){
        return service.updateClient(client);
    }

    @DeleteMapping("/delete_client/{email}")
    public void deleteClient(@PathVariable String email){
        service.deleteClient(email);
    }

    @PutMapping("add_car")
    public void addClientCar(){
        //todo
    }

}
