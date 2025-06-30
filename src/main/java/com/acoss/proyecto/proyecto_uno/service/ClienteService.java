package com.acoss.proyecto.proyecto_uno.service;


import com.acoss.proyecto.proyecto_uno.model.Cliente;
import com.acoss.proyecto.proyecto_uno.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> buscarPorId(int id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public Cliente actualizarCliente(int id, Cliente cliente) {
        Cliente existe = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
        existe.setNombre(cliente.getNombre());
        existe.setApellido(cliente.getApellido());
        existe.setEmail(cliente.getEmail());
        return clienteRepository.save(existe);
    }
    public void eliminarCliente(int id) {
        clienteRepository.deleteById(id);
    }

}
