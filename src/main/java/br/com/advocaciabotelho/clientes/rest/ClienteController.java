package br.com.advocaciabotelho.clientes.rest;

import br.com.advocaciabotelho.clientes.model.entity.Cliente;
import br.com.advocaciabotelho.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }
    // Salvando no jdbc
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid Cliente cliente){
        return repository.save(cliente);
    }
    // Buscando por id
    @GetMapping("{id}")
    public Cliente buscarPorId(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }
    // Listando clientes
    @GetMapping
    public List<Cliente> findAll(){
        return repository.findAll();
    }
    // Deletando por id
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
       // repository.deleteById(id);
        repository.findById(id).map( cliente -> {
            repository.delete(cliente);
            return Void.TYPE; }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }

    // Atualizando dados cliente
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        repository.findById(id).map( cliente -> {
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setRg(clienteAtualizado.getRg());
        cliente.setNomeDaMae(clienteAtualizado.getNomeDaMae());
        cliente.setNomeDoPai(clienteAtualizado.getNomeDoPai());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setEndereco(clienteAtualizado.getEndereco());
        return repository.save(cliente);
        }).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }
}
