package com.digital.spring_architecture_test.services;

import com.digital.spring_architecture_test.dto.ClientDto;
import com.digital.spring_architecture_test.dto.requests.ClientRequest;
import com.digital.spring_architecture_test.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<ClientDto> findAll();
    ClientDto findById(Long id);
    ClientDto create(ClientRequest clientRequest);
    ClientDto update(Long id, ClientRequest clientRequest);
    void deleteById(Long id);
}
