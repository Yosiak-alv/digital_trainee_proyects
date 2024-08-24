package com.digital.spring_architecture_test.dto;


import com.digital.spring_architecture_test.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Long id;
    private String name;
    private String lastname;

    public ClientDto(Client client) {
        BeanUtils.copyProperties(client, this);
    }

    public Client toEntity() {
        Client client = new Client();
        BeanUtils.copyProperties(this, client);
        return client;
    }
}
