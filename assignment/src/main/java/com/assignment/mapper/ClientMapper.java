package com.assignment.mapper;

import com.assignment.dto.ClientRequestDTO;
import com.assignment.dto.ClientResponseDTO;
import com.assignment.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    // Convert RequestDTO → Entity
    public Client toEntity(ClientRequestDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setDescription(dto.getDescription());
        client.setDesignation(dto.getDesignation());
        client.setImageUrl(dto.getImageUrl());
        return client;
    }

    // Convert Entity → ResponseDTO
    public ClientResponseDTO toResponse(Client client) {
        return new ClientResponseDTO(
                client.getId(),
                client.getName(),
                client.getDescription(),
                client.getDesignation(),
                client.getImageUrl()
        );
    }
}
