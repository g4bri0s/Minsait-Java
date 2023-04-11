package com.clients.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.clients.dtos.LoanDTORequest;
import com.clients.dtos.LoanDTOResponse;
import com.clients.exceptions.ClientNotFoundException;
import com.clients.exceptions.LoanNotFoundException;
import com.clients.exceptions.NoLimitException;
import com.clients.service.LoanService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clientes/{cpf}/emprestimos")
public class LoanController {

    private LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoanDTOResponse saveLoan(@Valid @RequestBody LoanDTORequest loan, @PathVariable Long cpf)
            throws ClientNotFoundException, NoLimitException {
        return this.loanService.saveLoan(loan, cpf);
    }

    @GetMapping
    public List<LoanDTOResponse> getLoans(@PathVariable Long cpf) throws ClientNotFoundException {
        return this.loanService.getLoans(cpf);
    }

    @GetMapping("/{id}")
    public LoanDTOResponse getLoanById(@PathVariable Long cpf, @PathVariable Long id)
            throws LoanNotFoundException, ClientNotFoundException {
        return this.loanService.getLoanById(cpf, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLoan(@PathVariable Long cpf, @PathVariable Long id)
            throws LoanNotFoundException, ClientNotFoundException {
        this.loanService.deleteLoan(cpf, id);
    }
}