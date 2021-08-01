package sofka.Entidad;

import lombok.Data;

import javax.persistence.*;

@Data
//@Entity
//@Table(name = "eleccion_carril")
public class EleccionCarril {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //@ManyToOne
    private Elecccion elecccion;
    //@ManyToOne
    private Carril carril;

    public EleccionCarril() {
    }

    public EleccionCarril(int id, Elecccion elecccion, Carril carril) {
        this.id = id;
        this.elecccion = elecccion;
        this.carril = carril;
    }
}
