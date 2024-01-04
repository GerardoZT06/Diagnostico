package mx.edu.utez.Crud5B.model.dao;

import mx.edu.utez.Crud5B.model.entity.PersonaBean;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<PersonaBean, Integer > {

}