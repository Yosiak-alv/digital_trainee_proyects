package com.digital.spring_architecture_test.controller;

import com.digital.spring_architecture_test.common.ApiResponse;
import com.digital.spring_architecture_test.dto.requests.ClientRequest;
import com.digital.spring_architecture_test.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<?> index() {
        return ApiResponse.collectionResponse(this.clientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        return ApiResponse.singleResponse(this.clientService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ClientRequest clientRequest) {
        return ApiResponse.messageWithSingleResponse(
                "Client created successfully",
                this.clientService.create(clientRequest),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody ClientRequest clientRequest) {
        return ApiResponse.messageWithSingleResponse(
                "Client updated successfully",
                this.clientService.update(id, clientRequest),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        this.clientService.deleteById(id);
        return ApiResponse.messageResponse("Client deleted successfully", HttpStatus.OK);
    }

}
