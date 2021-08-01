package sofka.Servicio;

import sofka.Entidad.Conductor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServicioSeleccionarConductor {

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    public ServicioSeleccionarConductor() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void buscar(int id) {
        Conductor conductorActual = entityManager.find(Conductor.class, 1);

        System.out.println(conductorActual.getId());
        System.out.println(conductorActual.getNombre());
    }
}
