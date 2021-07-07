package br.com.advocaciabotelho.clientes.model.repository;

import br.com.advocaciabotelho.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
