package sofka.Entidad;

import lombok.Data;
import javax.persistence.*;

@Data
//@Entity
public class Carro {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    public Carro() {
    }

    public Carro(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
