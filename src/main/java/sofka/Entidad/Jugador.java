package sofka.Entidad;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;


   }
