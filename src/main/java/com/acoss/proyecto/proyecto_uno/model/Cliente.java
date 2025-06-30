package com.acoss.proyecto.proyecto_uno.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "clientes")
public class Cliente {

    @Id
    private int id;
    private String nombre;
    private String apellido;
    private String email;

}
