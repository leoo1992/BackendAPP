package br.com.apiclient.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.apiclient.model.Cliente;
import br.com.apiclient.repository.clienteRepository;

@RestController
@RequestMapping("/clientes")//ROTA

//CLASS START
public class ClienteController{
    
//CONTROLE DO REPOSITORIO    
private clienteRepository clienteRepository;
ClienteController(clienteRepository clienteRepository){
this.clienteRepository = clienteRepository;
}

//OP. CRUD REST FULL

//CRIAR CLIENTE - METODO POST - CREAT DO  CRUD COM RETORNO DE STATUS NO PROTOCOLO HTTP
@PostMapping
@ResponseStatus(code = HttpStatus.CREATED)
public Cliente cadastrar(@RequestBody Cliente cliente) {
    return clienteRepository.save(cliente);
}

// METODO GET PARA LISTAR - FIND ALL 
@GetMapping
public List<Cliente> listar() {
    return clienteRepository.findAll();
}

//METODO GET PARA PROCURAR POR ID - FIND BY ID 
@GetMapping("/{id}")
public Cliente buscarPorId(@PathVariable Long id) {
    var clienteOptional = clienteRepository.findById(id);
    if (clienteOptional.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return clienteOptional.get();
}

//DELETAR POR ID - METODO DELETE DO CRUD
@DeleteMapping("/{id}")
@ResponseStatus(code = HttpStatus.NO_CONTENT)
public void excluirPorId(@PathVariable Long id) {
    var clienteOptional = clienteRepository.findById(id);
    if (clienteOptional.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    clienteRepository.delete(clienteOptional.get());
}

//ATUALIZAR POR ID - METODO UPDATE DO CRUD
@PutMapping("/{id}")
public Cliente atualizarPorId(@PathVariable Long id, @RequestBody Cliente cliente) {
    var clienteOptional = clienteRepository.findById(id);
    if (clienteOptional.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    cliente.setId(id);
    return clienteRepository.save(cliente);
}

}//CLASS CLOSE



