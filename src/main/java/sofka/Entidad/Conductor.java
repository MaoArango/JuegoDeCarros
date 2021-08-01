package sofka.Entidad;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
}