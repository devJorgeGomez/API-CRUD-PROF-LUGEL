package com.example.holaMundo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController()
@RequestMapping("api/v1/personas")
public class PersonaController {

    ArrayList<Persona> personas = new ArrayList<>();
    PersonaServicio service = new PersonaServicio();

    @GetMapping()
    public ArrayList<Persona> listarPersonas(){
        return this.service.listarPersonas();
    }

    @GetMapping("ciudad/{ciudad}")
    public ArrayList<Persona> listarPersonasPorCiudad(@PathVariable("ciudad") String ciudad){
        return this.service.listarPersonasPorCiudad(ciudad);}

    @GetMapping("cedula/{cedula}")
    public Optional<Persona> obtenerPersonaPorCedula(@PathVariable("cedula") String cedula){
        return this.service.obtenerPersonaPorCedula(cedula);
    }

    @DeleteMapping("{cedula}")
    public ArrayList<Persona> eliminarPersonaPorCedula(@PathVariable("cedula") String cedula){
        return this.service.eliminarPersonaPorCedula(cedula);
    }

    @PostMapping()
    public Persona crearPersona(@RequestBody Persona persona){
        return this.service.crearPersona(persona);
    }
}
