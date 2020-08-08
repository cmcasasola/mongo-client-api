package pe.com.examples.mongoclientapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.com.examples.mongoclientapi.dto.ClientDto;
import pe.com.examples.mongoclientapi.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/clients")
    public ClientDto save(@RequestBody ClientDto clientDto) {

        return this.clientService.save(clientDto);
    }

    @GetMapping("/clients/{id}")
    public ClientDto get(@PathVariable("id") String id) {
        return this.clientService.findClient(id);
    }

    @GetMapping("/clients")
    public List<ClientDto> list() {
        return this.clientService.listClients();
    }

    @PutMapping("/clients/{id}")
    public ClientDto updateClient(@PathVariable String id, @RequestBody ClientDto clientDto) {
        return this.clientService.updateClient(id, clientDto);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable("id") String id) {
        this.clientService.deleteClient(id);
    }
}
