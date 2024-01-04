package mx.edu.utez.Crud5B.service.Impl;

import lombok.*;
import mx.edu.utez.Crud5B.model.dao.PersonaDao;
import mx.edu.utez.Crud5B.model.dto.PersonaDto;
import mx.edu.utez.Crud5B.model.entity.PersonaBean;
import mx.edu.utez.Crud5B.service.IPersona;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonaImpl implements IPersona{
    private final PersonaDao personaDao;

    @Transactional
    @Override
    public PersonaBean save(PersonaDto personaDto) {
        PersonaBean persona = PersonaBean.builder()
        .personaId(personaDto.getPersonaId())
        .nombre(personaDto.getNombre())
        .curp(personaDto.getCurp())
        .fechaNacimiento(personaDto.getFechaNacimiento())
        .build();
        return personaDao.save(persona);
    }

    @Transactional(readOnly = true)
    @Override
    public PersonaBean findById(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(PersonaBean personaBean) {
        personaDao.delete(personaBean);    }

    @Override
    public List<PersonaBean> findAll() {
        return (List<PersonaBean>) personaDao.findAll();   
     }
}
