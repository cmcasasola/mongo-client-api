package pe.com.examples.mongoclientapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.examples.mongoclientapi.dto.ClientDto;
import pe.com.examples.mongoclientapi.entity.Client;
import pe.com.examples.mongoclientapi.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientDto save(ClientDto clientDto) {
        Client client = this.clientRepository
                .save(Client.builder().id(clientDto.getId()).name(clientDto.getName()).lastName(clientDto.getLastName())
                        .age(clientDto.getAge()).birthDate(clientDto.getBirthDate()).build());

        return ClientDto.builder().id(client.getId()).name(client.getName()).lastName(client.getLastName())
                .age(client.getAge()).birthDate(client.getBirthDate()).build();
    }

    public ClientDto findClient(String id) {
        return this.clientRepository.findById(id)
                .map(client -> ClientDto.builder().id(client.getId()).name(client.getName())
                        .lastName(client.getLastName()).age(client.getAge()).birthDate(client.getBirthDate()).build())
                .get();
    }

    public List<ClientDto> listClients() {
        return clientRepository.findAll().stream()
                .map(client -> ClientDto.builder().id(client.getId()).name(client.getName())
                        .lastName(client.getLastName()).age(client.getAge()).birthDate(client.getBirthDate()).build())
                .collect(Collectors.toList());
    }

    public void updateClient(String id, ClientDto clientDto) {
        this.clientRepository.save(Client.builder().id(id).name(clientDto.getName()).lastName(clientDto.getLastName())
                .age(clientDto.getAge()).birthDate(clientDto.getBirthDate()).build());
    }

    public void deleteClient(String id) {
        this.clientRepository.deleteById(id);
    }
}
