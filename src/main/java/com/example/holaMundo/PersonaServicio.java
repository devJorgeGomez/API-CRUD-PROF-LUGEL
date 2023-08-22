package com.example.holaMundo;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonaServicio {
    ArrayList<Persona> personas = new ArrayList<>();

    public ArrayList<Persona> listarPersonas(){
        return this.personas;
    }

    public ArrayList<Persona> listarPersonasPorCiudad(String ciudad){
        return (ArrayList<Persona>) this.personas
                .stream()
                .filter(p-> p.getCiudad().equals(ciudad))
                .collect(Collectors.toList());
    }

    public Optional<Persona> obtenerPersonaPorCedula(String cedula){
        return this.personas
                .stream()
                .filter(p-> p.getDocumento().equals(cedula))
                .findFirst();
    }

    public Persona crearPersona(Persona persona){
        this.personas.add(persona);
        return persona;
    }

    public ArrayList<Persona> eliminarPersonaPorCedula(String cedula){
        personas.removeIf(p->p.getDocumento().equals(cedula));
        return personas;
    }
}
