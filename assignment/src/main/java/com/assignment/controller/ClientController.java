package com.assignment.controller;

import com.assignment.dto.ClientRequestDTO;
import com.assignment.dto.ClientResponseDTO;
import com.assignment.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(
            @Valid @RequestBody ClientRequestDTO dto) {

        return ResponseEntity.ok(clientService.createClient(dto));
    }

    // GET ALL (paginated)
    @GetMapping
    public ResponseEntity<Page<ClientResponseDTO>> getAllClients(Pageable pageable) {
        return ResponseEntity.ok(clientService.getAllClients(pageable));
    }

    // GET BY ID
    @GetMapping("/by-id/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable String id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    // GET BY NAME
    @GetMapping("/by-name/{name}")
    public ResponseEntity<ClientResponseDTO> getClientByName(@PathVariable String name) {
        return ResponseEntity.ok(clientService.getClientByName(name));
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<ClientResponseDTO> updateClientById(
            @PathVariable String id,
            @Valid @RequestBody ClientRequestDTO dto) {

        return ResponseEntity.ok(clientService.updateClientById(id, dto));
    }

    // DELETE BY ID
    @DeleteMapping("/delete/by-id/{id}")
    public ResponseEntity<ClientResponseDTO> deleteClientById(@PathVariable String id) {
        return ResponseEntity.ok(clientService.deleteClientById(id));
    }

    // DELETE BY NAME
    @DeleteMapping("/delete/by-name/{name}")
    public ResponseEntity<ClientResponseDTO> deleteClientByName(@PathVariable String name) {
        return ResponseEntity.ok(clientService.deleteClientByName(name));
    }
}
