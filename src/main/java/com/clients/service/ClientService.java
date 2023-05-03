package com.clients.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.clients.dtos.ClientDTORequest;
import com.clients.dtos.ClientDTOResponse;
import com.clients.entity.Client;
import com.clients.exceptions.ClientNotFoundException;
import com.clients.repository.ClientRepository;
import jakarta.validation.Valid;

@Service
public class ClientService {

	private ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public ClientDTOResponse saveClient(ClientDTORequest clientDTORequest) {
		Client client = clientDTORequest.returnClient(clientDTORequest);
		this.clientRepository.save(client);
		return new ClientDTOResponse(client);
	}

	public ClientDTOResponse getClientById(String cpf) throws ClientNotFoundException {
		Optional<Client> optionalClient = this.clientRepository.findById(cpf);
		if (optionalClient.isPresent()) {
			return new ClientDTOResponse(optionalClient.get());
		} else {
			throw new ClientNotFoundException(cpf);
		}
	}

	public List<ClientDTOResponse> getClients() {
		List<Client> clients = this.clientRepository.findAll();
		return clients.stream()
				.map(client -> new ClientDTOResponse(client))
				.collect(Collectors.toList());
	}

	public ClientDTOResponse editClient(@PathVariable String cpf, @Valid ClientDTORequest clientDTORequest)
			throws ClientNotFoundException {
		Optional<Client> optionalClient = clientRepository.findById(cpf);
		if (optionalClient.isPresent()) {
			Client updatedClient = clientDTORequest.returnUpdatedClient(clientDTORequest, optionalClient.get());
			this.clientRepository.save(updatedClient);
			return new ClientDTOResponse(updatedClient);

		} else {
			throw new ClientNotFoundException(cpf);
		}
	}

	public void deleteClient(String cpf) throws ClientNotFoundException {
		Client client = clientRepository.findById(cpf).orElseThrow(() -> new ClientNotFoundException(cpf));
		clientRepository.delete(client);
	}
}