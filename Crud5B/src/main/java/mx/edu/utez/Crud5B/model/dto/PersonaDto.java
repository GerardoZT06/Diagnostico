package mx.edu.utez.Crud5B.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonaDto {
    private Integer personaId;
    private String nombre;
    private String apellido;
    private String curp;
    private String fechaNacimiento;
}