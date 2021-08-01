package sofka;

import sofka.Entidad.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConfigurarJuego {
    private List<EleccionCarril> eleccionCarril = new ArrayList<EleccionCarril>();
    private List<Conductor> conductores = new ArrayList<Conductor>();
    private List<Carro> carros = new ArrayList<Carro>();
    private List<Pista> pistas = new ArrayList<Pista>();
    private List<Carril> carriles = new ArrayList<Carril>();

    public ConfigurarJuego() {
        crearDatos();
        List<Jugador> jugadores = ingresarJugadores();
        List<Conductor> conductores = seleccionarConductores(jugadores.size());
        List<Carro> carros = seleccionarCarros(jugadores.size());

        List<Elecccion> eleccciones = crearElecciones(jugadores, conductores, carros);

        seleccionarPista(eleccciones);
    }

    private void crearDatos() {


        this.conductores.add(new Conductor(1, "Mario"));
        this.conductores.add(new Conductor(2, "Crash"));

        this.carros.add(new Carro(1, "Mario Kart"));
        this.carros.add(new Carro(2, "Crash CTR"));

        Pista pista = new Pista(1, "Montaña", null);

        this.carriles.add(new Carril(1, 1, pista));
        this.carriles.add(new Carril(2, 2, pista));
        this.carriles.add(new Carril(3, 3, pista));
        this.carriles.add(new Carril(4, 4, pista));

        pista.setCarriles(this.carriles);

        this.pistas.add(pista);
    }

    private void seleccionarPista(List<Elecccion> eleccciones) {
        String mensaje = "Escriba el numero del Carro";

        for (Pista pista : this.pistas) {
            mensaje += "\n " + pista.getId() + " " + pista.getNombre();
        }
        boolean numeroValido = false;
        int idPista = 0;
        while(!numeroValido) {
            try {
                idPista = Integer.parseInt(recibirDatosConsola(mensaje));
                numeroValido = idPista > 0 && idPista <= this.carros.size();
                if(!numeroValido) imprimirEnConsola("Elija un numero de una pista");
            } catch (NumberFormatException exception) {
                imprimirEnConsola("Escriba un número");
            }
        }

        Pista pistaSeleccionada = this.pistas.get(idPista - 1);

        for (int i = 0; i < eleccciones.size(); i++) {
            EleccionCarril eleccion = new EleccionCarril(1, eleccciones.get(i), pistaSeleccionada.getCarriles().get(i));
            eleccionCarril.add(eleccion);
        }
    }

    private List<Elecccion> crearElecciones(List<Jugador> jugadores, List<Conductor> conductores, List<Carro> carros) {
        List<Elecccion> eleccciones = new ArrayList<Elecccion>();
        for (int i = 0; i < jugadores.size(); i++) {
            Elecccion eleccion = new Elecccion();
            eleccion.setCarro(carros.get(i));
            eleccion.setJugador(jugadores.get(i));
            eleccion.setConductor(conductores.get(i));
        }

        return eleccciones;
    }

    private List<Carro> seleccionarCarros(int cantidadDeJugadores) {
        String mensaje = "Escriba el numero del Carro";
        List<Carro> carros = new ArrayList<Carro>();

        for (Carro carro : this.carros) {
            mensaje += "\n " + carro.getId() + " " + carro.getNombre();
        }
        for (int i = 0; i < cantidadDeJugadores; i++) {
            boolean numeroValido = false;
            int idCarro = 0;
            while(!numeroValido) {
                try {
                    idCarro = Integer.parseInt(recibirDatosConsola(mensaje));
                    numeroValido = idCarro > 0 && idCarro <= this.carros.size();
                    if(!numeroValido) imprimirEnConsola("Elija un numero de un carro");
                } catch (NumberFormatException exception) {
                    imprimirEnConsola("Escriba un número");
                }
            }
            carros.add(this.carros.get(idCarro - 1));
        }

        return carros;
    }

    private List<Conductor> seleccionarConductores(int cantidadDeJugadores) {
        String mensaje = "Escriba el numero del Conductor";
        List<Conductor> conductores = new ArrayList<Conductor>();

        for (Conductor conductor : this.conductores) {
            mensaje += "\n " + conductor.getId() + " " + conductor.getNombre();
        }
        for (int i = 0; i < cantidadDeJugadores; i++) {
            boolean numeroValido = false;
            int idConductor = 0;
            while(!numeroValido) {
                try {
                    idConductor = Integer.parseInt(recibirDatosConsola(mensaje));
                    numeroValido = idConductor > 0 && idConductor <= this.conductores.size();
                    if(!numeroValido) imprimirEnConsola("Elija un numero de un conductor");
                } catch (NumberFormatException exception) {
                    imprimirEnConsola("Escriba un número");
                }
            }
            conductores.add(this.conductores.get(idConductor - 1));
        }

        return conductores;
    }


    private List<Jugador> ingresarJugadores() {
        List<Jugador> jugadores = new ArrayList<Jugador>();
        boolean numeroValido = false;
        int cantidadDeJugadores = 0;
        while(!numeroValido) {
            try {
                cantidadDeJugadores = Integer.parseInt(recibirDatosConsola("Elije la cantidad de jugadores"));
                numeroValido = cantidadDeJugadores >= 3 && cantidadDeJugadores <=6;
                if(!numeroValido) imprimirEnConsola("Elija un numero de 3 a 6");
            } catch (NumberFormatException exception) {
                imprimirEnConsola("Escriba un número");
            }
        }
        for (int i = 0; i < cantidadDeJugadores; i++) {
            String nombre = recibirDatosConsola("Escriba el nombre del Jugador " + (i + 1));
            Jugador jugador = new Jugador();
            jugador.setNombre(nombre);
            jugadores.add(jugador);
        }

        return jugadores;
    }

    public void imprimirEnConsola(String mensaje) {
        System.out.println(mensaje);
    }

    public String recibirDatosConsola(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        imprimirEnConsola(mensaje);
        return scanner.next();
    }

    public List<EleccionCarril> getEleccionCarril() {
        return eleccionCarril;
    }

}
