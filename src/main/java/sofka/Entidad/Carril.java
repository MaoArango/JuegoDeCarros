package sofka.Entidad;

import lombok.Data;

import javax.persistence.*;

@Data
//@Entity
public class Carril {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int numeroCarril;

    //@ManyToOne
    private Pista pista;

    public Carril() {
    }

    public Carril(int id, int numeroCarril, Pista pista) {
        this.id = id;
        this.numeroCarril = numeroCarril;
        this.pista = pista;
    }
}
