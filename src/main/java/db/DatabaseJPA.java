package db;

import domain.Player;
import exception.DatabaseException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dries
 */
public class DatabaseJPA extends Database {
    
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    @Override
    public List<Player> getPlayers() throws DatabaseException {
        List<Player> players = entityManager.createQuery("Select p from Player p", Player.class).getResultList();
        return players;
    }

    @Override
    public Player getPlayer(Long id) throws DatabaseException {
        TypedQuery<Player> q = entityManager.createQuery("Select p from Player p WHERE p.id =?1",Player.class);
        Player player = q.setParameter(1, id).getSingleResult();
        return player;
    }

    @Override
    public void addPlayer(Player player) throws DatabaseException {
        entityManager.getTransaction().begin();
        entityManager.persist(player);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removePlayer(Long id) throws DatabaseException {
        entityManager.getTransaction().begin();
        Player player = getPlayer(id);
        entityManager.remove(player);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updatePlayer(Player player) throws DatabaseException {
        entityManager.getTransaction().begin();
        entityManager.merge(player);
        entityManager.getTransaction().commit();
    }
    
}
