package gestionvacacionesbackend.gestionvacaciones.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "usuario")
@Entity
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_usuario")
    private Integer userName;
    @Column(name = "contraseña")
    private Integer password;
    @Column(name = "nombre")
    private Integer name;
    @Column(name = "apellido")
    private Integer lastName;

    @Column(name = "correo")
    private Integer email;
    @Column(name = "autorizado")
    private boolean authorize = true;


}
