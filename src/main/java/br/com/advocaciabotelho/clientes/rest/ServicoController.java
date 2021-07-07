package br.com.advocaciabotelho.clientes.rest;

import br.com.advocaciabotelho.clientes.model.entity.Cliente;
import br.com.advocaciabotelho.clientes.model.entity.Servico;
import br.com.advocaciabotelho.clientes.model.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    private final ServicoRepository repository;

    @Autowired
    public ServicoController(ServicoRepository repository){
        this.repository = repository;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico salvar(@RequestBody Servico servico){
        return repository.save(servico);
    }
}
