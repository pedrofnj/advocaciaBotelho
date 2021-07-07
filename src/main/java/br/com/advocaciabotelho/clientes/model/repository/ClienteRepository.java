package br.com.advocaciabotelho.clientes.model.repository;

import br.com.advocaciabotelho.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
