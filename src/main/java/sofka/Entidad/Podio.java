package sofka.Entidad;

import lombok.Data;

@Data
public class Podio {
    private int id;
    private int posicion;
    private Juego juego;
    private EleccionJuego eleccionJuego;

    public Podio(int id, int posicion, Juego juego, EleccionJuego eleccionJuego) {
        this.id = id;
        this.posicion = posicion;
        this.juego = juego;
        this.eleccionJuego = eleccionJuego;
    }

    public Podio() {
    }
}
