package Contoller;

import Service.ClientService;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= "*", methods ={ RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,
        RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")  //localhost:8080/api/Client/all
    public List<Client> getAll() {
        return clientService.getAll();
    }
    @GetMapping("/{id}")  //localhost:8080/api/Client/id
    public Optional<Client> getClient (@PathVariable("id")int id){
        return clientService.getClient(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }


}
