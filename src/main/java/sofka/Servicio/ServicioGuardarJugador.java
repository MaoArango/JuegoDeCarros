package sofka.Servicio;

import sofka.Entidad.Jugador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServicioGuardarJugador {

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    public ServicioGuardarJugador() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void guardar(Jugador jugador) {
        entityManager.getTransaction().begin();
        entityManager.persist(jugador);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
