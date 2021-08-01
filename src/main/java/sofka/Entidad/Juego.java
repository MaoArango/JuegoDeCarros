package sofka.Entidad;

import lombok.Data;

@Data
public class Juego {
    private int id;
    private int distancia;

    public Juego() {
    }

    public Juego(int id, int distancia) {
        this.id = id;
        this.distancia = distancia;
    }
}
