package sofka.Servicio;

import sofka.Entidad.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServicioSeleccionarCarro {

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    public ServicioSeleccionarCarro() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void buscar(int id) {
        Carro carroActual = entityManager.find(Carro.class, 1);

        System.out.println(carroActual.getId());
        System.out.println(carroActual.getNombre());
    }
}
