package sofka;

import sofka.Entidad.Carro;
import sofka.Entidad.Conductor;
import sofka.Entidad.Jugador;
import sofka.Servicio.ServicioSeleccionarCarro;
import sofka.Servicio.ServicioSeleccionarConductor;

public class Aplicacion {

    public static void main(String[] args) {

        Jugador jugador = new Jugador();
        jugador.setNombre("Mauricio Arngo");

        Conductor conductor = new Conductor();
        conductor.setNombre("Luigi");

        Carro carro = new Carro();
        carro.setNombre("Mercedes");


     /*   ServicioGuardarJugador servicioGuardarJugador = new ServicioGuardarJugador();
        servicioGuardarJugador.guardar(jugador);
*/
        ServicioSeleccionarCarro servicioSeleccionarCarro = new ServicioSeleccionarCarro();
        servicioSeleccionarCarro.buscar(1);




        ServicioSeleccionarConductor servicioSeleccionarConductor = new ServicioSeleccionarConductor();
        servicioSeleccionarConductor.buscar(1);
    }
}
