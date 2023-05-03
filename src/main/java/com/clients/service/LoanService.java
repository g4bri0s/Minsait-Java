package com.clients.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clients.dtos.LoanDTORequest;
import com.clients.dtos.LoanDTOResponse;
import com.clients.entity.Loan;
import com.clients.exceptions.ClientNotFoundException;
import com.clients.exceptions.LoanNotFoundException;
import com.clients.exceptions.NoLimitException;
import com.clients.repository.LoanRepository;

@Service
public class LoanService {

    private LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public BigDecimal consultLoanLimity(String cpf) {
        BigDecimal renda = loanRepository.findRendaByClientCpf(cpf);
        BigDecimal limite = renda.multiply(new BigDecimal(10));
        BigDecimal total = loanRepository.sumValorInicialByClientCpf(cpf);
        if (total == null) {
            total = BigDecimal.ZERO;
        }
        return limite.subtract(total);
    }

    public LoanDTOResponse saveLoan(LoanDTORequest loanDTORequest, String cpf)
            throws ClientNotFoundException, NoLimitException {
        if (this.loanRepository.existsByCpf(cpf)) {
            if (consultLoanLimity(cpf).compareTo(loanDTORequest.getValorInicial()) == 1
                    || consultLoanLimity(cpf).compareTo(loanDTORequest.getValorInicial()) == 0) {
                loanDTORequest.setCpfCliente(cpf);
                Loan loan = loanDTORequest.returnLoan(loanDTORequest);
                loan.setValorFinal(this.loanRepository.findAllByClientCpf(cpf).size());
                this.loanRepository.save(loan);
                return new LoanDTOResponse(loan);
            } else {
                throw new NoLimitException(cpf);
            }
        } else {
            throw new ClientNotFoundException(cpf);
        }
    }

    public List<LoanDTOResponse> getLoans(String cpf) throws ClientNotFoundException {
        if (this.loanRepository.existsByCpf(cpf)) {
            List<Loan> loans = this.loanRepository.findAllByClientCpf(cpf);
            if (!loans.isEmpty()) {
                return loans.stream()
                        .map(loan -> new LoanDTOResponse(loan))
                        .collect(Collectors.toList());
            } else {
                throw new ClientNotFoundException(cpf);
            }
        } else {
            throw new ClientNotFoundException(cpf);
        }
    }

    public LoanDTOResponse getLoanById(String cpf, Long id) throws LoanNotFoundException, ClientNotFoundException {
        if (this.loanRepository.existsByCpf(cpf)) {
            if (this.loanRepository.existsById(id)) {
                return new LoanDTOResponse(this.loanRepository.findById(id).get());
            } else {
                throw new LoanNotFoundException(id);
            }
        } else {
            throw new ClientNotFoundException(cpf);
        }
    }

    public void deleteLoan(String cpf, Long id) throws LoanNotFoundException, ClientNotFoundException {
        if (this.loanRepository.existsByCpf(cpf)) {
            if (this.loanRepository.existsById(id)) {
                this.loanRepository.deleteById(id);
            } else {
                throw new LoanNotFoundException(id);
            }
        } else {
            throw new ClientNotFoundException(cpf);
        }
    }
}
