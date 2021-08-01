package sofka.Entidad;

import lombok.Data;

@Data
public class EleccionJuego {
    private int id;
    private EleccionCarril eleccionCarril;
    private Juego juego;
    private int distanciaRecorrida;

    public EleccionJuego() {
    }

    public EleccionJuego(int id, EleccionCarril eleccionCarril, Juego juego) {
        this.id = id;
        this.eleccionCarril = eleccionCarril;
        this.juego = juego;
    }
}
