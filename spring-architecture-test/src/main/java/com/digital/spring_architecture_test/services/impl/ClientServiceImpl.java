package com.digital.spring_architecture_test.services.impl;

import com.digital.spring_architecture_test.dto.ClientDto;
import com.digital.spring_architecture_test.dto.requests.ClientRequest;
import com.digital.spring_architecture_test.exceptions.ResourceNotFoundException;
import com.digital.spring_architecture_test.models.Client;
import com.digital.spring_architecture_test.repositories.ClientRepository;
import com.digital.spring_architecture_test.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository repository;

    @Override
    public List<ClientDto> findAll() {
        return this.repository.findAll().stream().map(ClientDto::new).toList();
    }

    @Override
    public ClientDto findById(Long id) {
        Client client = this.repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
        return new ClientDto(client);
    }

    @Override
    public ClientDto create(ClientRequest clientRequest) {
        Client newClient = new Client();
        newClient.setName(clientRequest.getName());
        newClient.setLastname(clientRequest.getLastname());
        return new ClientDto(this.repository.save(newClient));
    }

    @Override
    public ClientDto update(Long id, ClientRequest clientRequest) {
        ClientDto clientDto = this.findById(id);
        Client client = clientDto.toEntity();
        client.setName(clientRequest.getName());
        client.setLastname(clientRequest.getLastname());

        return new ClientDto(this.repository.save(client));
    }

    @Override
    public void deleteById(Long id) {
        ClientDto clientDto = this.findById(id);
        this.repository.deleteById(clientDto.getId());
    }
}
