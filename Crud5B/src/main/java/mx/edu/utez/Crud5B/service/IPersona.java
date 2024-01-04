package mx.edu.utez.Crud5B.service;

import java.util.List;

import mx.edu.utez.Crud5B.model.dto.PersonaDto;
import mx.edu.utez.Crud5B.model.entity.PersonaBean;
public interface IPersona {
    PersonaBean save(PersonaDto personaDto);

    PersonaBean findById(Integer id);

    void delete(PersonaBean personaBean);

    List<PersonaBean> findAll();

}