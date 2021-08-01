package sofka.Entidad;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
//@Entity
public class Pista {

    public Pista() {
    }

    public Pista(int id, String nombre, List<Carril> carriles) {
        this.id = id;
        this.nombre = nombre;
        this.carriles = carriles;
    }

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private List<Carril> carriles;
}
