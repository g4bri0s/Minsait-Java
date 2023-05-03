package com.clients.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.clients.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT e FROM Loan e WHERE e.cpfCliente = :cpf")
    List<Loan> findAllByClientCpf(@Param("cpf") String cpf);

    @Query("SELECT c.rendimentoMensal FROM Client c WHERE c.cpf = :cpf")
    BigDecimal findRendaByClientCpf(@Param("cpf") String cpf);

    @Query("SELECT SUM(l.valorInicial) FROM Loan l WHERE l.cpfCliente = :cpf")
    BigDecimal sumValorInicialByClientCpf(@Param("cpf") String cpf);

    @Query("SELECT COUNT(c) > 0 FROM Client c WHERE c.cpf = :cpf")
    Boolean existsByCpf(@Param("cpf") String cpf);

}