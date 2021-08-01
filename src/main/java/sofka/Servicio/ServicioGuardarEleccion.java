package sofka.Servicio;

import sofka.Entidad.Elecccion;
import sofka.Entidad.Jugador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServicioGuardarEleccion {

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;
    public ServicioGuardarEleccion() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void guardar(Elecccion elecccion) {
        entityManager.getTransaction().begin();
        entityManager.persist(elecccion);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
