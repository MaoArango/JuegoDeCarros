package sofka.Entidad;

import lombok.Data;

import javax.persistence.*;

@Data
//@Entity
public class Elecccion {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //@ManyToOne
    private Jugador jugador;
    //@ManyToOne
    private Conductor conductor;
    //@ManyToOne
    private Carro carro;

    public Elecccion() {
    }

    public Elecccion(int id, Jugador jugador, Conductor conductor, Carro carro) {
        this.id = id;
        this.jugador = jugador;
        this.conductor = conductor;
        this.carro = carro;
    }
}
