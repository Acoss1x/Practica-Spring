package com.acoss.proyecto.proyecto_uno.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private String nombre, apellido;
    private int id;
    private String email;

}
