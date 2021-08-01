package sofka;

import sofka.Entidad.EleccionCarril;
import sofka.Entidad.EleccionJuego;
import sofka.Entidad.Juego;
import sofka.Entidad.Podio;

import java.util.ArrayList;
import java.util.List;

public class IniciarJuego {
    private List<EleccionJuego> eleccionesJuego = new ArrayList<EleccionJuego>();
    private List<Podio> podios = new ArrayList<Podio>();

    public IniciarJuego() {
        ConfigurarJuego configurarJuego = new ConfigurarJuego();

        Juego juego = crearJuego(configurarJuego.getEleccionCarril());

        List<EleccionJuego> posiciones = jugar();

        crearPodio(posiciones, juego);
    }

    private void crearPodio(List<EleccionJuego> posiciones, Juego juego) {
        for (int i = 0; i < posiciones.size(); i++) {
            Podio podio = new Podio(i, i + 1,juego, posiciones.get(i));
            podios.add(podio);

        }
    }

    private List<EleccionJuego> jugar() {
        List<EleccionJuego> eleccionJuegoFinalizado = new ArrayList<EleccionJuego>();
        while(!hanTerminadoTodos()) {
            for (EleccionJuego eleccionJuego: eleccionesJuego) {
                int distanciaRecorrida = (int)(Math.random()*6 + 1) * 100;
                eleccionJuego.setDistanciaRecorrida(eleccionJuego.getDistanciaRecorrida() + distanciaRecorrida);
                if(eleccionJuego.getDistanciaRecorrida() >= eleccionJuego.getJuego().getDistancia()) {
                    eleccionJuegoFinalizado.add(eleccionJuego);
                }
            }
        }

        return eleccionJuegoFinalizado;
    }

    private boolean hanTerminadoTodos() {
        for (EleccionJuego eleccionJuego: eleccionesJuego) {
            if(eleccionJuego.getDistanciaRecorrida() < eleccionJuego.getJuego().getDistancia()) return false;
        }
        return true;
    }

    private Juego crearJuego(List<EleccionCarril> eleccionesCarril) {
        Juego juego = new Juego(1, 2000);

        for (EleccionCarril eleccionCarril: eleccionesCarril) {
            eleccionesJuego.add(new EleccionJuego(1, eleccionCarril, juego));
        }

        return juego;
    }
}
