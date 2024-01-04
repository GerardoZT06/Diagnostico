package mx.edu.utez.Crud5B.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import mx.edu.utez.Crud5B.model.dto.PersonaDto;
import mx.edu.utez.Crud5B.model.entity.PersonaBean;
import mx.edu.utez.Crud5B.service.Impl.PersonaImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class PersonaController {

    private final PersonaImpl personaService;
    
    @PostMapping("/personas")
    public PersonaDto create(@RequestBody PersonaDto personaDto){
        PersonaBean personaSave = personaService.save(personaDto);
        return personaDto.builder()
                .personaId(personaSave.getPersonaId())
                .nombre(personaSave.getNombre())
                .curp(personaSave.getCurp())
                .fechaNacimiento(personaSave.getFechaNacimiento())
                .build();
    }

        @PutMapping("/personas")
    public PersonaDto update(@RequestBody PersonaDto personaDto){
        PersonaBean personaSave = personaService.save(personaDto);
        return personaDto.builder()
                .personaId(personaSave.getPersonaId())
                .nombre(personaSave.getNombre())
                .curp(personaSave.getCurp())
                .fechaNacimiento(personaSave.getFechaNacimiento())
                .build();
    }
    //
    @DeleteMapping("/personas/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            PersonaBean persona = personaService.findById(id);
            personaService.delete(persona);
            return new ResponseEntity<>(persona, HttpStatus.NO_CONTENT);
        } catch (DataAccessException ex){
            response.put("msj", ex.getMessage());
            response.put("Personas", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/personas/{id}")
    public PersonaBean showById(@PathVariable Integer id){
        try {
            return personaService.findById(id);
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }
    }

    @GetMapping("/persona")
    public List<PersonaBean> findAll() {
        try {
            return personaService.findAll();
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }
    }
    
}