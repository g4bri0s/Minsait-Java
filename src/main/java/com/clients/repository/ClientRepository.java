package com.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clients.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}