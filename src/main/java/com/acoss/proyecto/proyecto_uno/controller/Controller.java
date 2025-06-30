package com.acoss.proyecto.proyecto_uno.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acoss.proyecto.proyecto_uno.model.Cliente;
import com.acoss.proyecto.proyecto_uno.service.ClienteService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/clientes")
public class Controller {

    @Autowired  
    private final ClienteService clienteService;

    public Controller(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Aqui muestro los clientes al entrar a la url /api/clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.listaClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    //Aqui muestro un cliente en especifico al entrar a la url /api/clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    //En este lo que hago es crear un cliente mediante un metodo POST.
    @PostMapping("/crear")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        if (cliente.getId() == 0 || cliente.getNombre() == null || cliente.getApellido() == null || cliente.getEmail() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Cliente nuevoCliente = clienteService.crearCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    //En este actualizamos un cliente mediante un metodo PUT.
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        if (cliente.getId() == 0 || cliente.getNombre() == null || cliente.getApellido() == null || cliente.getEmail() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Cliente actualizado = clienteService.actualizarCliente(id, cliente);
        return ResponseEntity.ok(actualizado);
    }
    
    //En este ultimo se elimina el cliente mediante un metodo DELETE.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
        if (!clienteService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

    
    




}
