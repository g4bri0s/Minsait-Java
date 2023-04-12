package com.clients.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.clients.dtos.ClientDTORequest;
import com.clients.dtos.ClientDTOResponse;
import com.clients.exceptions.ClientNotFoundException;
import com.clients.service.ClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clientes")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTOResponse saveClient(@Valid @RequestBody ClientDTORequest client) {
        return this.clientService.saveClient(client);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<ClientDTOResponse> getClients() {
        return this.clientService.getClients();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{cpf}")
    public ClientDTOResponse getClientById(@PathVariable Long cpf) throws ClientNotFoundException {
        return this.clientService.getClientById(cpf);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{cpf}")
    public ClientDTOResponse editClient(@Valid @RequestBody ClientDTORequest client, @PathVariable Long cpf)
            throws ClientNotFoundException {
        return this.clientService.editClient(cpf, client);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable Long cpf) throws ClientNotFoundException {
        this.clientService.deleteClient(cpf);
    }

}