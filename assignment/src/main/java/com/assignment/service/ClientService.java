package com.assignment.service;

import com.assignment.dto.ClientRequestDTO;
import com.assignment.dto.ClientResponseDTO;
import com.assignment.exception.DuplicateProjectException; // or DuplicateClientException
import com.assignment.exception.ResourceNotFoundException;
import com.assignment.mapper.ClientMapper;
import com.assignment.model.Client;
import com.assignment.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper){
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    // CREATE
    public ClientResponseDTO createClient(@Valid ClientRequestDTO dto) {

        if (clientRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new DuplicateProjectException(
                    "Client with name '" + dto.getName() + "' already exists");
        }

        Client client = clientMapper.toEntity(dto);
        Client saved = clientRepository.save(client);

        return clientMapper.toResponse(saved);
    }

    // GET ALL
    public Page<ClientResponseDTO> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable)
                .map(clientMapper::toResponse);
    }

    // GET BY ID
    public ClientResponseDTO getClientById(String id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Client not found with id: " + id));

        return clientMapper.toResponse(client);
    }

    // GET BY NAME
    public ClientResponseDTO getClientByName(String name) {
        Client client = clientRepository.findByNameIgnoreCase(name)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Client not found with name: " + name));

        return clientMapper.toResponse(client);
    }

    // UPDATE
    public ClientResponseDTO updateClientById(String id, @Valid ClientRequestDTO dto) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Client not found with id: " + id));

        if (!client.getName().equalsIgnoreCase(dto.getName())
                && clientRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new DuplicateProjectException(
                    "Client with name '" + dto.getName() + "' already exists");
        }

        client.setName(dto.getName());
        client.setDescription(dto.getDescription());
        client.setDesignation(dto.getDesignation());
        client.setImageUrl(dto.getImageUrl());

        Client updated = clientRepository.save(client);
        return clientMapper.toResponse(updated);
    }

    // DELETE BY ID
    public ClientResponseDTO deleteClientById(String id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Client not found with id: " + id));

        clientRepository.delete(client);
        return clientMapper.toResponse(client);
    }

    // DELETE BY NAME
    public ClientResponseDTO deleteClientByName(String name) {
        Client client = clientRepository.findByNameIgnoreCase(name)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Client not found with name: " + name));

        clientRepository.delete(client);
        return clientMapper.toResponse(client);
    }
}
